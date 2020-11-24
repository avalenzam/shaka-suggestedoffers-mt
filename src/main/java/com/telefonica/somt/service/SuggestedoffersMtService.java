package com.telefonica.somt.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.util.StringUtil;
import com.telefonica.somt.business.alta.Alta;
import com.telefonica.somt.business.migration.Migration;
import com.telefonica.somt.business.others.PublicId;
import com.telefonica.somt.business.variables.CustomerProduct.CustomerProductVariable;
import com.telefonica.somt.business.variables.ElegibleOfferMt.ElegibleOffersMtVariable;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.exception.HttpException;
import com.telefonica.somt.generated.model.ComponentProdOfferPriceType;
import com.telefonica.somt.generated.model.ComposingProductType;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.OfferingType;
import com.telefonica.somt.generated.model.PaginationInfoType;
import com.telefonica.somt.generated.model.ProductSpecCharacteristicType;
import com.telefonica.somt.generated.model.ProductSpecCharacteristicValueType;
import com.telefonica.somt.generated.model.RefinedProductType;
import com.telefonica.somt.generated.model.ResponseType;
import com.telefonica.somt.generated.model.StringWrapper;
import com.telefonica.somt.pojo.business.OfferResponse;
import com.telefonica.somt.pojo.clientTenure.ClientTenure;
import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
import com.telefonica.somt.proxy.elegibleOffersMt.ElegibleOffersMtConnection;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: SuggestedoffersMtService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las ofertas sugeridas MT
 */
@Service
public class SuggestedoffersMtService implements ISuggestedoffersMt {

    @Autowired
    private ElegibleOffersMtConnection elegibleOffersMtConnection;
    @Autowired
    private PublicId		       publicId;
    @Autowired
    private CustomerProductVariable    customerProductVariable;
    @Autowired
    private ElegibleOffersMtVariable   elegibleOffersMtVariable;
    @Autowired
    private Migration		       migration;
    @Autowired
    private Alta		       alta;

    /**
     * Metodo principal. Retorna el response poblado con las ofertas MT que puede
     * adquirir el cliente
     * 
     * @param SuggestedOffersMtRequestDto:
     *            request que viene del front
     * @return ResponseType : lista de ofertas sugeridad MT
     * @throws Exception
     */

    public ResponseType getSuggestedoffersMt(SuggestedOffersMtRequestDto request) throws HttpException {

	try {

	    ResponseType responseType = new ResponseType();

	    List<OfferingType> offeringsList = new ArrayList<>();
	    PaginationInfoType paginationInfo = null;

	    List<OfferResponse> offerResponseList = null;

	    PublicIdResponse publicIdResponse = publicId.getPublicId(request.getProduct().getPublicId());

	    ResponseType elegibleOfferMtService = elegibleOffersMtConnection.callRestService(request);

	    if (Objects.nonNull(elegibleOfferMtService)) {

		offerResponseList = getOffer(request, elegibleOfferMtService, publicIdResponse);

		if (Boolean.TRUE.equals(Util.isEmptyOrNullList(offerResponseList))) {

		    for (OfferResponse offerResponse : offerResponseList) {

			for (OfferingType offering : elegibleOfferMtService.getOfferings()) {

			    if (offerResponse.getCodOffer().equals(offering.getId())) {

				paginationInfo = elegibleOfferMtService.getPaginationInfo();
				offeringsList.add(getElegibleOfferMt(offering, offerResponse));

			    }

			}

		    }
		}

	    }

	    if (Boolean.TRUE.equals(Util.isEmptyOrNullList(offeringsList))) {
		responseType.setOfferings(
			offeringsList.stream().sorted(Comparator.comparing(OfferingType::getId)).collect(Collectors.toList()));
		responseType.setPaginationInfo(paginationInfo);

		return responseType;
	    } else {
		throw new Exception("1");
	    }
	} catch (Exception e) {

	    throw HttpException.HttpExceptionResponse(e);
	}

    }

    /**
     * El metodo se encarga de obtener las ofertas del cliente de acuerdo a su
     * tenencia
     * 
     * @param: request
     *             request que viene del front
     * @param: elegibleOfferMtService
     *             Response de ofertas elegibles MT
     * @return List<OfferResponse>: Listado del tipo OfferResponse, con tenencias,
     *         precio recurrente y id de la oferta MT
     */
    private List<OfferResponse> getOffer(SuggestedOffersMtRequestDto request, ResponseType elegibleOfferMtService,
	    PublicIdResponse publicIdResponse) {

	List<OfferResponse> offerResponseList = null;
	List<ElegibleOffersMt> elegibleOffersMtList = elegibleOffersMtVariable.getElegibleOffersMtVariable(request, elegibleOfferMtService);

	CustomerProduct customerProduct = customerProductVariable.getCustomerProductVariable(request, publicIdResponse);

	List<MobileProduct> mobileProductList = customerProduct.getMobileProduct();
	FijaProduct fijaProduct = Objects.isNull(customerProduct.getFijaProduct()) ? new FijaProduct() : customerProduct.getFijaProduct();

	String mobileMtClient = mobileProductList.isEmpty() ? Constant.NO : mobileProductList.get(0).getMobileMtClient();

	if (Constant.YES.equalsIgnoreCase(fijaProduct.getFijaMtClient()) || Constant.YES.equalsIgnoreCase(mobileMtClient)) {

	    offerResponseList = migration.getMigration(request.getNetworkTechnology(), customerProduct, elegibleOffersMtList);
	} else {
	    offerResponseList = alta.getAlta(customerProduct, publicIdResponse, elegibleOffersMtList);
	}
	return offerResponseList;

    }

    /**
     * El metodo retorna la oferta elegible MT que coincida con la devuelta por
     * sugeridas
     * 
     * @param: offering
     *             offerta del response de ofertas elegibles MT
     * @param: clientTenureResponse
     *             Tenencias que el cliente debe mantener
     * @return OfferingType: response poblado con Oferta elegible MT y precios de
     *         las tenencias
     */

    private OfferingType getElegibleOfferMt(OfferingType offering, OfferResponse offerResponse) {
	
	ClientTenureResponse clientTenureResponse = offerResponse.getClientTenureResponse();
	
	OfferingType offeringResponse = new OfferingType();
	List<ComposingProductType> productSpecificationList = new ArrayList<>();
	List<ComponentProdOfferPriceType> productOfferingPriceList = new ArrayList<>();

	offering.getProductOfferingPrice().forEach(
		productOfferingPrice -> productOfferingPriceList.add(fillProductOfferingPrice(productOfferingPrice, offerResponse)));

	offering.getProductSpecification().forEach(productSpecification -> productSpecificationList.add(productSpecification));
	if (Boolean.TRUE.equals(Objects.nonNull(clientTenureResponse))) {
	    clientTenureResponse.getDecoTenue().forEach(decoTenue -> {
		if (Boolean.TRUE.equals(Objects.nonNull(decoTenue))) {
		    productSpecificationList.add(fillProductSpecification(decoTenue));
		}
	    });
	    if (Boolean.TRUE.equals(Objects.nonNull(clientTenureResponse.getBlockTenue()))) {
		productSpecificationList.add(fillProductSpecification(clientTenureResponse.getBlockTenue()));
	    }
	    if (Boolean.TRUE.equals(Objects.nonNull(clientTenureResponse.getModemTenue()))) {
		productSpecificationList.add(fillProductSpecification(clientTenureResponse.getModemTenue()));
	    }
	    if (Boolean.TRUE.equals(Objects.nonNull(clientTenureResponse.getRepeaterTenue()))) {
		productSpecificationList.add(fillProductSpecification(clientTenureResponse.getRepeaterTenue()));
	    }
	}

	offeringResponse.setId(offering.getId());
	offeringResponse.setCode(offering.getCode());
	offeringResponse.setCatalogItemType(offering.getCatalogItemType());
	offeringResponse.setHref(offering.getHref());
	offeringResponse.setCorrelationId(offering.getCorrelationId());
	offeringResponse.setName(offering.getName());
	offeringResponse.setDescription(offering.getDescription());
	offeringResponse.setType(offering.getType());
	offeringResponse.setCurrentPlanRelationID(offering.getCurrentPlanRelationID());
	offeringResponse.setCategory(offering.getCategory());
	offeringResponse.setIsPromotion(offering.getIsPromotion());
	offeringResponse.setBillingMethod(offering.getBillingMethod());
	offeringResponse.setChannel(offering.getChannel());
	offeringResponse.setFrameworkAgreement(offering.getFrameworkAgreement());
	offeringResponse.setCustomerId(offering.getCustomerId());
	offeringResponse.setCompatibleProducts(offering.getCompatibleProducts());
	offeringResponse.setIsBundle(offering.getIsBundle());
	offeringResponse.setOfferingUrl(offering.getOfferingUrl());
	offeringResponse.setValidFor(offering.getValidFor());
	offeringResponse.setBundledProductOffering(offering.getBundledProductOffering());
	offeringResponse.setIsDowngrade(offering.getIsDowngrade());
	offeringResponse.setProductOfferingPrice(productOfferingPriceList);
	offeringResponse.setLifeCycleStatus(offering.getLifeCycleStatus());
	offeringResponse.setOfferingPenalties(offering.getOfferingPenalties());
	offeringResponse.setUpFront(offering.getUpFront());
	offeringResponse.setBenefits(offering.getBenefits());
	offeringResponse.setAdditionalData(offering.getAdditionalData());
	offeringResponse.setProductSpecification(productSpecificationList);

	return offeringResponse;

    }

    /**
     * El metodo llena los campos del objeto ComponentProdOfferPriceType
     * (productOfferingPrice)
     * 
     * @param: productOfferingPrice
     *             productOfferingPrice del response de ofertas elegibles MT
     * @param: clientTenureResponse
     *             Tenencias que el cliente debe mantener
     * 
     * @return ComponentProdOfferPriceType: devuelve el objeto poblado.
     */

    private ComponentProdOfferPriceType fillProductOfferingPrice(ComponentProdOfferPriceType productOfferingPrice,
	    OfferResponse offerResponse) {

	ClientTenureResponse clientTenureResponse = offerResponse.getClientTenureResponse();
	
	ComponentProdOfferPriceType productOfferingPriceResponse = new ComponentProdOfferPriceType();
	productOfferingPriceResponse.setId(productOfferingPrice.getId());
	productOfferingPriceResponse.setName(productOfferingPrice.getName());
	productOfferingPriceResponse.setDescription(productOfferingPrice.getDescription());
	productOfferingPriceResponse.setPriceType(productOfferingPrice.getPriceType());
	productOfferingPriceResponse.setRecurringChargePeriod(productOfferingPrice.getRecurringChargePeriod());
	if (Objects.isNull(clientTenureResponse)) {
	    productOfferingPriceResponse.setPrice(
		    fillMoneyType(productOfferingPrice.getPrice().getAmount(), productOfferingPrice.getPrice().getUnits(), Boolean.FALSE));
	    productOfferingPriceResponse.setPriceWithTax(
		    fillMoneyType(productOfferingPrice.getPrice().getAmount(), productOfferingPrice.getPrice().getUnits(), Boolean.TRUE));

	} else {
	    productOfferingPriceResponse.setPrice(
		    fillMoneyType(clientTenureResponse.getRecurringPrice(), productOfferingPrice.getPrice().getUnits(), Boolean.FALSE));
	    productOfferingPriceResponse.setPriceWithTax(
		    fillMoneyType(clientTenureResponse.getRecurringPrice(), productOfferingPrice.getPrice().getUnits(), Boolean.TRUE));

	}

	return productOfferingPriceResponse;

    }

    /**
     * El metodo llena los campos del objeto MoneyType
     * 
     * @param: amount
     *             monto
     * @param: units
     *             tipo de moneda
     * @param: igv
     *             Se enviara True si se desea el precio con IGV
     * 
     * @return MoneyType: Retorna el objeto poblado.
     */

    private MoneyType fillMoneyType(BigDecimal amount, String units, Boolean igv) {

	MoneyType moneyType = new MoneyType();

	if (Objects.nonNull(amount)) {
	    if (Boolean.TRUE.equals(igv)) {
		amount = Util.addIgv(amount.floatValue());
	    }

	    moneyType.setAmount(Util.roundValue(amount));
	    moneyType.setUnits(StringUtil.isNullOrEmpty(units) ? Constant.PERUVIAN_COIN : units);
	}

	return moneyType;
    }

    /**
     * El metodo llena los campos del objeto ComposingProductType
     * (productSpecification)
     * 
     * @param: clientTenure
     *             Tenencia por cada tecnologia que cliente debe mantener
     * 
     * @return ComposingProductType: Retorna el objeto poblado.
     */

    private ComposingProductType fillProductSpecification(ClientTenure clientTenure) {

	ComposingProductType productSpecification = new ComposingProductType();
	RefinedProductType refinedProduct = new RefinedProductType();

	List<ComposingProductType> subProductsList = new ArrayList<>();

	ComposingProductType subProducts = new ComposingProductType();

	subProducts.setId(clientTenure.getId());
	subProducts.setName(clientTenure.getName());
	subProducts.setProductType(clientTenure.getProductType());

	if (clientTenure.getProductCharacteristic() != null) {
	    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
	    RefinedProductType refinedProductSubProducts = new RefinedProductType();

	    StringWrapper productCharacteristics = new StringWrapper();
	    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	    productCharacteristics.setId(clientTenure.getProductCharacteristic().getId());
	    productCharacteristics.setName(clientTenure.getProductCharacteristic().getName());
	    productCharacteristics.setValueType(clientTenure.getProductCharacteristic().getValueType());
	    productSpecCharacteristicValue.setValue(clientTenure.getProductCharacteristic().getValue());

	    productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
	    productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);
	    productCharacteristicsList.add(productCharacteristics);

	    refinedProductSubProducts.setProductCharacteristics(productCharacteristicsList);

	    subProducts.setRefinedProduct(refinedProductSubProducts);
	}

	subProductsList.add(subProducts);
	refinedProduct.setSubProducts(subProductsList);
	productSpecification.setRefinedProduct(refinedProduct);

	return productSpecification;
    }
}
