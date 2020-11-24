package com.telefonica.somt.business.alta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.util.StringUtil;
import com.telefonica.somt.business.others.Cluster;
import com.telefonica.somt.business.recurringPrice.ClientMaintainTenure;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.entity.rtdm.FactRecargaKpi;
import com.telefonica.somt.entity.rtdm.Offeringquad;
import com.telefonica.somt.pojo.business.ArpaClusterResponse;
import com.telefonica.somt.pojo.business.OfferResponse;
import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
import com.telefonica.somt.repository.rtdm.AltaOfferRepository;
import com.telefonica.somt.repository.rtdm.FactRecargaKpiRepository;
import com.telefonica.somt.repository.rtdm.OfferingquadRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: Alta.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las ofertas que aplican a un alta
 */
@Component
public class Alta {

    @Autowired
    private OfferingquadRepository   offeringquadRepository;
    @Autowired
    private ClientMaintainTenure     clientMaintainTenure;
    @Autowired
    private Cluster		     cluster;
    @Autowired
    private FactRecargaKpiRepository factRecargaKpiRepository;
    @Autowired
    private AltaOfferRepository	     altaOfferRepository;

    /**
     * Metodo principal. Filtra las ofertas elegibles MT y selecciona aquellas que
     * quedan como sugeridas
     * 
     * @param customerProduct:
     *            Response de la clase CustomerProductVariable
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @return List<OfferResponse> : Retorna lista de tenencias y codigo de oferta
     *         MT
     */
    public List<OfferResponse> getAlta(CustomerProduct customerProduct, PublicIdResponse publicIdResponse,
	    List<ElegibleOffersMt> elegibleOffersMtList) {

	List<OfferResponse> offerResponseList = null;
	List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	FijaProduct fijaProduct = customerProduct.getFijaProduct();

	if (mobileProductList.size() == 1 && fijaProduct == null
		&& Constant.NO.equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {
	    mobileProductList.get(0).setOriginOfferType(Constant.SOLO_MOVIL);

	}

	if (Objects.nonNull(fijaProduct)) {
	    if (Constant.TRIO.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		    || Constant.DUO_BA_TV.equalsIgnoreCase(fijaProduct.getOriginOfferType())) {

		offerResponseList = getTriosAndDuos(customerProduct, publicIdResponse, elegibleOffersMtList);

	    } else if (Constant.DUO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		    || Constant.DUO_TV.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		    || Constant.MONO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		    || Constant.MONO_TV.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		    || Constant.MONO_LINEA.equalsIgnoreCase(fijaProduct.getOriginOfferType())) {

		offerResponseList = getDuosAndMono(customerProduct, publicIdResponse, elegibleOffersMtList);
	    }

	} else {
	    if (Constant.SOLO_MOVIL.equalsIgnoreCase(mobileProductList.get(0).getOriginOfferType())) {

		offerResponseList = getDuosAndMono(customerProduct, publicIdResponse, elegibleOffersMtList);
	    }

	}

	return offerResponseList;
    }

    /**
     * El metodo se encarga de obtener las ofertas sugeridas como altas para tios y
     * duos BA+TV
     * 
     * @param customerProduct:
     *            Response de la clase CustomerProductVariable
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @param: elegibleOffersMtList
     *             Listado de ofertas elegibles MT
     * @return List<OfferResponse>: Listado del tipo OfferResponse, con tenencias,
     *         precio recurrente y id de la oferta MT
     */
    private List<OfferResponse> getTriosAndDuos(CustomerProduct customerProduct, PublicIdResponse publicIdResponse,
	    List<ElegibleOffersMt> elegibleOffersMtList) {

	List<OfferResponse> offerResponseList = new ArrayList<>();

	List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	FijaProduct fijaProduct = customerProduct.getFijaProduct();

	ArpaClusterResponse arpaClusterResponse = getArpaAndCluster(mobileProductList, fijaProduct, publicIdResponse);

	String prioritizedOffer = altaOfferRepository.findByArpa(fijaProduct.getOriginOfferType(), fijaProduct.getTvType(),
		arpaClusterResponse.getCluster(), arpaClusterResponse.getArpa());

	if (!StringUtil.isNullOrEmpty(prioritizedOffer)) {

	    Offeringquad offeringquad = offeringquadRepository.findByTipoParrillaAndAmountwithtax(Constant.PARRILLA, prioritizedOffer);

	    if (!StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId())) {

		Offeringquad offeringquadId = offeringquadRepository.findByOfferingquadId(offeringquad.getOfferingquadId());

		if (!StringUtil.isNullOrEmpty(offeringquadId.getOfferingquadId())) {

		    for (ElegibleOffersMt elegibleOffersMt : elegibleOffersMtList) {

			if (elegibleOffersMt.getCodOffer().equalsIgnoreCase(offeringquadId.getOfferingquadId())) {

			    ClientTenureResponse clientTenureResponse = clientMaintainTenure.getClientTenure(fijaProduct, elegibleOffersMt);

			    if (Boolean.TRUE.equals(clientTenureResponse.getAvalibleOffer())) {
				OfferResponse offerResponse = new OfferResponse();
				offerResponse.setCodOffer(elegibleOffersMt.getCodOffer());
				offerResponse.setClientTenureResponse(clientTenureResponse);
				offerResponse.setRecurringPrice(getRecurringPrice(clientTenureResponse, fijaProduct.getTvType()));

				offerResponseList.add(offerResponse);
			    }

			}
		    }

		}

	    }

	}

	return offerResponseList;
    }

    /**
     * El metodo se encarga de obtener las ofertas sugeridas como altas para duos,
     * monos y soloMovil
     * 
     * @param customerProduct:
     *            Response de la clase CustomerProductVariable
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @param: elegibleOffersMtList
     *             Listado de ofertas elegibles MT
     * @return List<OfferResponse>: Listado del tipo OfferResponse, con tenencias,
     *         precio recurrente y id de la oferta MT
     */
    private List<OfferResponse> getDuosAndMono(CustomerProduct customerProduct, PublicIdResponse publicIdResponse,
	    List<ElegibleOffersMt> elegibleOffersMtList) {

	List<OfferResponse> offerResponseList = new ArrayList<>();
	List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	FijaProduct fijaProduct = customerProduct.getFijaProduct();

	String product = null;

	if (Boolean.TRUE.equals(Util.isEmptyOrNullList(mobileProductList))) {
	    product = mobileProductList.get(0).getOriginOfferType();
	}

	for (ElegibleOffersMt elegibleOffersMt : elegibleOffersMtList) {

	    ArpaClusterResponse arpaClusterResponse = getArpaAndCluster(mobileProductList, fijaProduct, publicIdResponse);

	    BigDecimal gapArpa = elegibleOffersMt.getTotalPrice().subtract(Util.addIgv(arpaClusterResponse.getArpa()));

	    String altaOfferId = null;

	    if (Objects.nonNull(fijaProduct)) {

		altaOfferId = getFijaAltaOfferId(fijaProduct, arpaClusterResponse, elegibleOffersMt, product);

	    } else {

		altaOfferId = altaOfferRepository.findByGapArpa(product, gapArpa, arpaClusterResponse.getCluster());
	    }

	    if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(altaOfferId))) {

		Offeringquad offeringquad = offeringquadRepository.findByOfferingquadIdAndTipoParrilla(elegibleOffersMt.getCodOffer(), "3");
		OfferResponse offerResponse = new OfferResponse();
		if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId())) && Objects.nonNull(fijaProduct)) {

		    ClientTenureResponse clientTenureResponse = clientMaintainTenure.getClientTenure(fijaProduct, elegibleOffersMt);

		    if (Boolean.TRUE.equals(clientTenureResponse.getAvalibleOffer())) {

			offerResponse.setCodOffer(elegibleOffersMt.getCodOffer());
			offerResponse.setClientTenureResponse(clientTenureResponse);
			offerResponse.setRecurringPrice(getRecurringPrice(clientTenureResponse, fijaProduct.getTvType()));

			offerResponseList.add(offerResponse);
		    }

		} else if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId()))) {
		   
		    offerResponse.setCodOffer(elegibleOffersMt.getCodOffer());
		    offerResponse.setRecurringPrice(elegibleOffersMt.getTotalPrice());

		    offerResponseList.add(offerResponse);
		}

	    }
	}

	return offerResponseList;

    }

    /**
     * Obtiene el altaOfferId de las tenencias fijas, necesario para el metodo
     * getDuosAndMono
     * 
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @param arpaClusterResponse:
     *            trae el arpa y el cluster de la oferta
     * @param: elegibleOffersMtList
     *             Ofertas elegibles MT
     * @param: product
     *             producto movil
     * @return String: altaOfferId
     */

    private String getFijaAltaOfferId(FijaProduct fijaProduct, ArpaClusterResponse arpaClusterResponse, ElegibleOffersMt elegibleOffersMt,
	    String product) {

	String altaOfferId = null;
	BigDecimal gapArpa = elegibleOffersMt.getTotalPrice().subtract(Util.addIgv(arpaClusterResponse.getArpa()));

	if (Constant.DUO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())
		|| Constant.MONO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())) {

	    BigDecimal originSpeed = new BigDecimal(fijaProduct.getOriginSpeed());
	    BigDecimal mtSpeed = new BigDecimal(elegibleOffersMt.getSpeed());
	    BigDecimal gapSpeed = mtSpeed.subtract(originSpeed).divide(originSpeed);

	    if (Constant.DUO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())) {
		altaOfferId = altaOfferRepository.findByGapArpaDuoBa(fijaProduct.getOriginOfferType(), gapArpa, gapSpeed,
			arpaClusterResponse.getCluster());
	    } else if (Constant.MONO_BA.equalsIgnoreCase(fijaProduct.getOriginOfferType())) {
		altaOfferId = altaOfferRepository.findByGapArpaAndSpeed(fijaProduct.getOriginOfferType(), gapArpa, gapSpeed,
			arpaClusterResponse.getCluster());
	    }

	} else {
	    altaOfferId = altaOfferRepository.findByGapArpa(product, gapArpa, arpaClusterResponse.getCluster());
	}

	return altaOfferId;

    }

    /**
     * Obtiene el arpa y cluster
     * 
     * @param mobileProductList:
     *            Lista de objetos con las variables de mobil
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @return ArpaClusterResponse: arpa y cluster
     */
    private ArpaClusterResponse getArpaAndCluster(List<MobileProduct> mobileProductList, FijaProduct fijaProduct,
	    PublicIdResponse publicIdResponse) {

	ArpaClusterResponse arpaClusterResponse = new ArpaClusterResponse();

	String clusterType = null;
	Float arpa = (float) 0;

	if (Boolean.FALSE.equals(mobileProductList.isEmpty())) {

	    for (MobileProduct mobileProduct : mobileProductList) {

		clusterType = cluster.getCluster(publicIdResponse, fijaProduct, mobileProduct);

		FactRecargaKpi factRecargaKpi = factRecargaKpiRepository.findByTelefono(mobileProduct.getMobileNumber());

		Float promPrepago = (float) 0;
		if (Objects.nonNull(factRecargaKpi)) {
		    promPrepago = factRecargaKpi.getPrommontorecargas();
		}

		if (Objects.nonNull(fijaProduct)) {
		    arpa = fijaProduct.getRentPackageOrigin() + fijaProduct.getRentTvBlockOrigin() + mobileProduct.getRentMobile()
			    + promPrepago;
		} else {
		    arpa = mobileProduct.getRentMobile() + promPrepago;
		}

	    }

	} else {

	    clusterType = cluster.getCluster(publicIdResponse, fijaProduct, null);
	    arpa = fijaProduct.getRentPackageOrigin() + fijaProduct.getRentTvBlockOrigin();
	}

	arpaClusterResponse.setArpa(arpa);
	arpaClusterResponse.setCluster(clusterType);

	return arpaClusterResponse;

    }

    /**
     * Realiza la logica para el precio recurrente segun las tenencias a mantener
     * 
     * @param clientTenureResponse:
     *            Tenencia que debe mantener el cliente
     * @param tvType:
     *            si es o no estelar
     * 
     * @return BigDecimal:precio recurrente de la oferta
     */
    private BigDecimal getRecurringPrice(ClientTenureResponse clientTenureResponse, String tvType) {

	BigDecimal recurringPrice;
	BigDecimal tvEstelar = new BigDecimal(0);

	if (Constant.YES.equalsIgnoreCase(tvType)) {

	    tvEstelar = new BigDecimal(20);
	    recurringPrice = clientTenureResponse.getRecurringPrice().add(tvEstelar);
	} else {
	    recurringPrice = clientTenureResponse.getRecurringPrice().add(tvEstelar);
	}

	return recurringPrice;
    }

}
