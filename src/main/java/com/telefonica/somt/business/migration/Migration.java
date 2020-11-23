package com.telefonica.somt.business.migration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.somt.business.recurringPrice.ClientMaintainTenure;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.entity.rtdm.MigrationOffer;
import com.telefonica.somt.entity.rtdm.Offeringquad;
import com.telefonica.somt.entity.rtdm.Offeringquaddetail;
import com.telefonica.somt.pojo.business.OfferResponse;
import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
import com.telefonica.somt.repository.daas.PrincipalcomponentFAldmRepository;
import com.telefonica.somt.repository.rtdm.MigrationOfferRepository;
import com.telefonica.somt.repository.rtdm.OfferingquadRepository;
import com.telefonica.somt.repository.rtdm.OfferingquaddetailRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: Migration.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las ofertas que aplican a migracion
 */
@Component
public class Migration {

    @Autowired
    private OfferingquaddetailRepository      offeringquaddetailRepository;
    @Autowired
    private PrincipalcomponentFAldmRepository principalcomponentFAldmRepository;
    @Autowired
    private MigrationOfferRepository	      migrationOfferRepository;
    @Autowired
    private OfferingquadRepository	      offeringquadRepository;
    @Autowired
    private ClientMaintainTenure	      recurringPrice;

    /**
     * Metodo principal. Filtra las ofertas elegibles MT y selecciona aquellas que
     * quedan como sugeridas
     * 
     * @param networkTechnology:
     *            valor que viene del request del front
     * @param customerProduct:
     *            Response de la clase CustomerProductVariable
     * @param elegibleOffersMtList:
     *            Listado de ofertas elegibles mt
     * @return List<OfferResponse> : Retorna lista de tenencias y codigo de oferta
     *         MT
     */
    public List<OfferResponse> getMigration(String networkTechnology, CustomerProduct customerProduct,
	    List<ElegibleOffersMt> elegibleOffersMtList) {

	List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	FijaProduct fijaProduct = customerProduct.getFijaProduct();

	List<OfferResponse> offerResponseList = null;

	List<MigrationOffer> priorizedOfferList = new ArrayList<>();
	List<String> offeringIdList = new ArrayList<>();

	if (Boolean.FALSE.equals(networkTechnology.equalsIgnoreCase("HFC"))
		&& Boolean.FALSE.equals(networkTechnology.equalsIgnoreCase("FIBER"))) {

	    MigrationOffer migrationOffer = migrationOfferRepository.findByPrioritizedOfferAndDestinationParrillaIgnoreCase("275",
		    Constant.CURRENT_PARRILLA);

	    priorizedOfferList.add(migrationOffer);

	} else {

	    if (Constant.YES.equalsIgnoreCase(fijaProduct.getFijaMtClient())) {

		offeringIdList.add(getFijaMigration(fijaProduct));
	    }

	    if (Boolean.TRUE.equals(Util.isEmptyOrNullList(mobileProductList))
		    && Constant.YES.equalsIgnoreCase(mobileProductList.get(0).getMobileMtClient())) {

		getMobileMigration(mobileProductList).forEach(id -> offeringIdList.add(id));
	    }

	    List<Offeringquad> offeringquadList = offeringquadRepository.findByOfferingquadIdIn(offeringIdList);

	    if (Boolean.TRUE.equals(Util.isEmptyOrNullList(offeringquadList))) {
		for (Offeringquad offeringquad : offeringquadList) {

		    MigrationOffer migrationOffer = migrationOfferRepository
			    .findByCurrentPlanAndAffiliatedMobileLineAndDestinationParrillaIgnoreCase(offeringquad.getAmountwithtax(),
				    customerProduct.getNumMobileLine(), Constant.CURRENT_PARRILLA);
		    if (Boolean.TRUE.equals(Objects.nonNull(migrationOffer))
			    && migrationOffer.getCurrentParrilla().contains(offeringquad.getTipoParrilla())) {
			priorizedOfferList.add(migrationOffer);

		    }
		}

	    }

	}
	if (Boolean.TRUE.equals(Util.isEmptyOrNullList(priorizedOfferList))) {

	    offerResponseList = getPrioritizedOffer(priorizedOfferList, elegibleOffersMtList, fijaProduct);
	}

	return offerResponseList;

    }

    /**
     * Obtiene el altaOfferId de las tenencias fijas
     * 
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @return String: altaOfferId
     */
    private String getFijaMigration(FijaProduct fijaProduct) {

	List<Offeringquaddetail> offeringquaddetailList;

	offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(fijaProduct.getOfferCodeOrigin());
	String offeringId = null;

	if (Boolean.TRUE.equals(Util.isEmptyOrNullList(offeringquaddetailList))) {

	    offeringId = offeringquaddetailList.stream().filter(x -> fijaProduct.getOriginSpeed().equalsIgnoreCase(x.getDownloadspeed()))
		    .map(Offeringquaddetail::getOfferingid).collect(Collectors.joining());
	} else {
	    String productKey = principalcomponentFAldmRepository.findProductkeyByIdProductOffer(fijaProduct.getOfferCodeOrigin());

	    offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(productKey);

	    System.out.println(fijaProduct.getOriginSpeed().equalsIgnoreCase(offeringquaddetailList.get(0).getDownloadspeed()));

	    offeringId = offeringquaddetailList.stream().filter(x -> fijaProduct.getOriginSpeed().equalsIgnoreCase(x.getDownloadspeed()))
		    .map(Offeringquaddetail::getOfferingid).collect(Collectors.joining());
	}

	return offeringId;

    }

    /**
     * Obtiene el altaOfferId de las tenencias fijas, necesario para el metodo
     * getDuosAndMono
     * 
     * @param mobileProductList:
     *            Lista de objetos con las variables de mobil
     * @return List<String>: altaOfferId
     */
    private List<String> getMobileMigration(List<MobileProduct> mobileProductList) {

	List<String> offeringIdList = new ArrayList<>();

	mobileProductList.forEach(mobileProduct -> {
	    List<Offeringquaddetail> offeringquaddetailList;

	    offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(mobileProduct.getMobileOfferCodeOrigin());

	    if (Boolean.TRUE.equals(Util.isEmptyOrNullList(offeringquaddetailList))) {

		for (Offeringquaddetail offeringquaddetail : offeringquaddetailList) {

		    offeringIdList.add(offeringquaddetail.getOfferingid());
		}

	    } else {
		String productKey = principalcomponentFAldmRepository
			.findProductkeyByIdProductOffer(mobileProduct.getMobileOfferCodeOrigin());

		offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(productKey);

		for (Offeringquaddetail offeringquaddetail : offeringquaddetailList) {

		    offeringIdList.add(offeringquaddetail.getOfferingid());
		}

	    }
	});

	return offeringIdList;

    }

    /**
     * El metodo se encarga de obtener las ofertas priorizadas para la migracion
     * 
     * @param priorizedOfferList:
     *            Ofertas priorizadas que han quedado del metodo getMigration
     * @param: elegibleOffersMtList
     *             Listado de ofertas elegibles MT
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @return List<OfferResponse>: Listado del tipo OfferResponse, con tenencias,
     *         precio recurrente y id de la oferta MT
     */
    private List<OfferResponse> getPrioritizedOffer(List<MigrationOffer> priorizedOfferList, List<ElegibleOffersMt> elegibleOffersMtList,
	    FijaProduct fijaProduct) {

	List<OfferResponse> offerResponseList = new ArrayList<>();

	for (MigrationOffer migrationOffer : priorizedOfferList) {

	    Offeringquad offeringquad = offeringquadRepository.findByTipoParrillaAndAmountwithtax(migrationOffer.getCurrentParrilla(),
		    migrationOffer.getPrioritizedOffer());

	    if (!StringUtil.isNullOrEmpty(offeringquad.getOfferingquadId())) {
		for (ElegibleOffersMt elegibleOffersMt : elegibleOffersMtList) {

		    if (elegibleOffersMt.getCodOffer().equalsIgnoreCase(offeringquad.getOfferingquadId())) {

			OfferResponse offerResponse = new OfferResponse();

			ClientTenureResponse clientTenureResponse = recurringPrice.getClientTenure(fijaProduct, elegibleOffersMt);

			offerResponse.setCodOffer(elegibleOffersMt.getCodOffer());
			offerResponse.setClientTenureResponse(clientTenureResponse);
			offerResponse.setRecurringPrice(clientTenureResponse.getRecurringPrice());
			offerResponseList.add(offerResponse);

		    }

		}
	    }

	}

	return offerResponseList;
    }

}
