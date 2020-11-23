package com.telefonica.somt.business.recurringPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.entity.rtdm.PriceProperties;
import com.telefonica.somt.entity.rtdm.RelationsMaster;
import com.telefonica.somt.generated.model.ComposingProductType.ProductTypeEnum;
import com.telefonica.somt.generated.model.ProductSpecCharacteristicType.ValueTypeEnum;
import com.telefonica.somt.pojo.clientTenure.ClientTenure;
import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;
import com.telefonica.somt.pojo.clientTenure.ProductCharacteristic;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.repository.rtdm.PricePropertiesRepository;
import com.telefonica.somt.repository.rtdm.RelationsMasterRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: ClientMaintainTenure.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase obtiene las tenencias actuales del cliente para
 *               mantenerlas
 */
@Component
public class ClientMaintainTenure {

    @Autowired
    private RelationsMasterRepository relationsMasterRepository;
    @Autowired
    private PricePropertiesRepository pricePropertiesRepository;

    /**
     * Metodo principal. Realiza la logica que define las tenencias que mantendra el
     * cliente de acuerdo a su plan actual
     * 
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @param: elegibleOffersMt
     *             Pfertas elegibles MT
     * @return ClientTenureResponse: Retorna las tenencias que mantendra el cliente
     */
    public ClientTenureResponse getClientTenure(FijaProduct fijaProduct, ElegibleOffersMt elegibleOffersMt) {

	ClientTenureResponse recurringPriceResponse = new ClientTenureResponse();

	ClientTenure repeaterTenue = null;
	ClientTenure modemTenue = null;
	List<ClientTenure> decoTenue = null;
	ClientTenure blockTenue = null;
	PriceProperties priceProperties = null;

	recurringPriceResponse.setAvalibleOffer(Boolean.TRUE);

	if (Boolean.FALSE.equals(elegibleOffersMt.getIdSvaBb().equalsIgnoreCase(fijaProduct.getIdRepeaterOrigin()))) {

	    repeaterTenue = getTepeaterTenue(fijaProduct.getIdRepeaterOrigin(), elegibleOffersMt.getCodFija());
	}

	if (elegibleOffersMt.getInternetTechnology().equalsIgnoreCase(fijaProduct.getInternetTechnology())
		&& Boolean.FALSE.equals(Util.compare(elegibleOffersMt.getSvaTypeEq(), fijaProduct.getTypeModemOrigin()))) {

	    modemTenue = getModemTenue(fijaProduct.getTypeModemOrigin());

	}

	if (!("DTH".equalsIgnoreCase(fijaProduct.getTypeModemOrigin()) && "CATV".equalsIgnoreCase(elegibleOffersMt.getTvTechnology()))) {

	    decoTenue = getDecoTenue(fijaProduct.getTypeDecoOrigin(), elegibleOffersMt.getSvaTypeTvDeco());
	}

	if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(fijaProduct.getCodParentTvBlockOrigin()))) {

	    blockTenue = getBlockTenue(fijaProduct, elegibleOffersMt);

	    if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(blockTenue.getId()))) {

		priceProperties = pricePropertiesRepository
			.findByBillingOfferCidAndRevenueTypeAndNamePropAbp(blockTenue.getProductCharacteristic().getId(), "RC", "Rate");

		recurringPriceResponse.setRecurringPrice(priceProperties.getValueAbp().add(elegibleOffersMt.getTotalPrice()));
	    }
	    recurringPriceResponse.setAvalibleOffer(Boolean.FALSE);

	}

	recurringPriceResponse.setBlockTenue(blockTenue);
	recurringPriceResponse.setDecoTenue(decoTenue);
	recurringPriceResponse.setModemTenue(modemTenue);
	recurringPriceResponse.setRepeaterTenue(repeaterTenue);
	recurringPriceResponse.setRecurringPrice(elegibleOffersMt.getTotalPrice());

	return recurringPriceResponse;

    }

    /**
     * Realiza la logica para mantener la tenencia de repetidor
     * 
     * @param idReapeterOrigin:
     *            Este campo viene en FijaProduct
     * @param codFijaElegibleMt:
     *            Este campo viene en ElegibleOffersMt
     * @return ClientTenure: objeto poblado con toda la informacion sobre el
     *         repetidor a mantener
     */
    private ClientTenure getTepeaterTenue(String idReapeterOrigin, String codFijaElegibleMt) {

	ClientTenure repeaterResponse = new ClientTenure();

	RelationsMaster relationsMaster = relationsMasterRepository.findByRootCidAndParentId(codFijaElegibleMt, idReapeterOrigin);

	if (Objects.nonNull(relationsMaster)) {
	    repeaterResponse.setId("34105211");
	    repeaterResponse.setName("Ultra WiFi");
	    repeaterResponse.setProductType(ProductTypeEnum.SVAINCLUDED);
	}

	return repeaterResponse;
    }

    /**
     * Realiza la logica para mantener la tenencia de modem
     * 
     * @param typeModemOrigin:
     *            Este campo viene en FijaProduct
     * @return ClientTenure: objeto poblado con toda la informacion sobre el
     *         repetidor a mantener
     */
    private ClientTenure getModemTenue(String typeModemOrigin) {

	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	clientTenure.setId("3192652");
	clientTenure.setName(typeModemOrigin);
	clientTenure.setProductType(ProductTypeEnum.SVAINCLUDED);
	productCharacteristic.setId("Equipment_Sub_Type");
	productCharacteristic.setName("Sub Tipo de Equipo");
	productCharacteristic.setValue("SubTipo_Modem_Origen");
	productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
	clientTenure.setProductCharacteristic(productCharacteristic);

	return clientTenure;
    }

    /**
     * Realiza la logica para mantener la tenencia de modem
     * 
     * @param typeModemOrigin:
     *            Este campo viene en FijaProduct
     * @return ClientTenure: objeto poblado con toda la informacion sobre el modem a
     *         mantener
     */
    private List<ClientTenure> getDecoTenue(List<String> typeDecoOriginList, List<String> typeDecoElegibleMtList) {

	List<ClientTenure> clientTenureList = new ArrayList<>();
	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	Integer numOriginDecoHd = 0;
	Integer numOriginDecoSd = 0;

	if (Boolean.TRUE.equals(Util.isEmptyOrNullList(typeDecoOriginList))) {
	    for (String typeDecoOrigin : typeDecoOriginList) {
		if ("HD".equalsIgnoreCase(typeDecoOrigin)) {
		    numOriginDecoHd += 1;
		}
		if ("SD".equalsIgnoreCase(typeDecoOrigin)) {
		    numOriginDecoSd += 1;
		}
	    }
	}

	Integer numElegibleMtDecoHd = 0;
	Integer numElegibleMtDecoSd = 0;

	if (Boolean.TRUE.equals(Util.isEmptyOrNullList(typeDecoElegibleMtList))) {
	    for (String typeDecoElegibleMt : typeDecoElegibleMtList) {
		if ("HD".equalsIgnoreCase(typeDecoElegibleMt)) {
		    numElegibleMtDecoHd += 1;
		}
		if ("SD".equalsIgnoreCase(typeDecoElegibleMt)) {
		    numElegibleMtDecoSd += 1;
		}
	    }

	}

	if (numOriginDecoHd > numElegibleMtDecoHd) {

	    clientTenure.setId("3197701");
	    clientTenure.setName("Caption_Deco_Origen");
	    clientTenure.setProductType(ProductTypeEnum.SVAINCLUDED);
	    productCharacteristic.setId("STB_Type");
	    productCharacteristic.setName("Tipo de Decodificador");
	    productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
	    productCharacteristic.setValue("HD");
	    clientTenure.setProductCharacteristic(productCharacteristic);
	    clientTenureList.add(clientTenure);

	}

	if (numOriginDecoSd > numElegibleMtDecoSd) {

	    clientTenure.setId("3197701");
	    clientTenure.setName("Caption_Deco_Origen");
	    clientTenure.setProductType(ProductTypeEnum.SVAINCLUDED);
	    productCharacteristic.setId("STB_Type");
	    productCharacteristic.setName("Tipo de Decodificador");
	    productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
	    productCharacteristic.setValue("SD");
	    clientTenure.setProductCharacteristic(productCharacteristic);
	    clientTenureList.add(clientTenure);

	}

	return clientTenureList;
    }

    /**
     * Realiza la logica para mantener la tenencia de bloque
     * 
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @param: elegibleOffersMt
     *             Pfertas elegibles MT
     * @return ClientTenure: objeto poblado con toda la informacion sobre el bloque
     *         a mantener
     */
    private ClientTenure getBlockTenue(FijaProduct fijaProduct, ElegibleOffersMt elegibleOffersMt) {

	ClientTenure clientTenure = new ClientTenure();
	ProductCharacteristic productCharacteristic = new ProductCharacteristic();

	Integer index = 0;

	for (String codeBlockTvOrigin : fijaProduct.getCodeTvBlockOrigin()) {

	    index += 1;

	    if (Boolean.FALSE.equals(elegibleOffersMt.getCodSvaTvBlock().contains(codeBlockTvOrigin))) {
		RelationsMaster relationsMaster = relationsMasterRepository
			.findByRootCidAndChildIdAndParentId(elegibleOffersMt.getCodFija(), codeBlockTvOrigin, "3196671");

		if (Boolean.TRUE.equals(Objects.nonNull(relationsMaster))) {
		    clientTenure.setId(fijaProduct.getCodParentTvBlockOrigin());
		    clientTenure.setName("Bloque de Canales");
		    clientTenure.setProductType(ProductTypeEnum.SVAINCLUDED);
		    productCharacteristic.setId(relationsMaster.getChildId());
		    productCharacteristic.setName("Billing Offer");
		    productCharacteristic.setValue(fijaProduct.getNameTvBlockOrigin().get(index));
		    productCharacteristic.setValueType(ValueTypeEnum.STRINGWRAPPER);
		    clientTenure.setProductCharacteristic(productCharacteristic);

		}
	    }

	}

	return clientTenure;
    }

}
