package com.telefonica.somt.business.variables.ElegibleOfferMt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.entity.rtdm.CompoWithPropandvalidVal;
import com.telefonica.somt.entity.rtdm.Offeringquaddetail;
import com.telefonica.somt.entity.rtdm.RelationsMaster;
import com.telefonica.somt.generated.model.ComposingProductType.ProductTypeEnum;
import com.telefonica.somt.generated.model.ResponseType;
import com.telefonica.somt.generated.model.StringWrapper;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.repository.rtdm.CompoWithPropandvalidValRepository;
import com.telefonica.somt.repository.rtdm.InterPlnSpeedandtechRateRepository;
import com.telefonica.somt.repository.rtdm.OfferingquaddetailRepository;
import com.telefonica.somt.repository.rtdm.RelationsMasterRepository;

@Component
public class ElegibleOffersMtVariable {

    @Autowired
    private OfferingquaddetailRepository       offeringquaddetailRepository;
    @Autowired
    private RelationsMasterRepository	       relationsMasterRepository;
    @Autowired
    private CompoWithPropandvalidValRepository compoWithPropandvalidValRepository;
    @Autowired
    private InterPlnSpeedandtechRateRepository interPlnSpeedandtechRateRepository;

    public List<ElegibleOffersMt> getElegibleOffersMtVariable(SuggestedOffersMtRequestDto request, ResponseType elegibleOfferMtService) {

	String CodCatalogo_TecnologiaTV = "3196511";
	String CodProducto_TV = "3197521";

	List<ElegibleOffersMt> elegibleOffersMtList = new ArrayList<>();

	elegibleOfferMtService.getOfferings().forEach(offering -> {

	    ElegibleOffersMt elegibleOffersMt = new ElegibleOffersMt();

	    elegibleOffersMt.setCodOffer(offering.getId());

	    String description = offering.getDescription();
	    String[] str = description.split(" ");
	    elegibleOffersMt.setSpeed(str[str.length - 2]);

	    offering.getProductSpecification().forEach(productSpecification -> {
		ProductTypeEnum productType = productSpecification.getProductType();

		if (ProductTypeEnum.MOBILE.equals(productType)) {
		    elegibleOffersMt.setCodMobile(productSpecification.getId());
		} else {
		    elegibleOffersMt.setCodFija(productSpecification.getId());
		}

		productSpecification.getRefinedProduct().getSubProducts().forEach(subProduct -> {
		    ProductTypeEnum subproductType = subProduct.getProductType();

		    if (ProductTypeEnum.CABLETV.equals(subproductType)) {

			List<String> svaTypeTvDecoList = new ArrayList<>();
			List<String> codSvaTvBlockList = new ArrayList<>();

			subProduct.getRefinedProduct().getSubProducts().forEach(sp -> {

			    ProductTypeEnum spType = sp.getProductType();
			    if (ProductTypeEnum.SVA.equals(spType)) {
				elegibleOffersMt.setIdSvaTvBlock(sp.getId());

				sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> codSvaTvBlockList.add(productCharacteristic.getId()));

			    }
			    if (ProductTypeEnum.DEVICE.equals(spType)) {

				sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> {
				    StringWrapper stringWrapper = (StringWrapper) productCharacteristic;

				    stringWrapper.getProductSpecCharacteristicValue().forEach(productCharacteristicValue -> svaTypeTvDecoList.add(productCharacteristicValue.getValue().trim()));
				});
				// TODO EN EL RESPONSE NO LLEGA ESTE VALOR, POR LO QUE NO SE HA PROBADO BIEN

				if (sp.getName().contains("MODEM")) {

				    sp.getRefinedProduct().getProductCharacteristics().forEach(productCharacteristic -> {

					StringWrapper stringWrapper = (StringWrapper) productCharacteristic;

					stringWrapper.getProductSpecCharacteristicValue().forEach(productCharacteristicValue -> elegibleOffersMt.setSvaTypeEq(productCharacteristicValue.getValue().trim()));
				    });
				}
			    }
			});

			elegibleOffersMt.setCodSvaTvBlock(codSvaTvBlockList);
			elegibleOffersMt.setSvaTypeTvDeco(svaTypeTvDecoList);
			elegibleOffersMt.setNumSvatvDeco(svaTypeTvDecoList.size());

		    }

		    if (ProductTypeEnum.BROADBAND.equals(subproductType)) {

			subProduct.getRefinedProduct().getSubProducts().forEach(sp -> {

			    if (ProductTypeEnum.DEVICE.equals(sp.getProductType())) {
				elegibleOffersMt.setIdSvaBb(sp.getId());

			    }
			});

		    }

		});

	    });

	    offering.getProductOfferingPrice().forEach(productOfferingPrice -> elegibleOffersMt.setTotalPrice(productOfferingPrice.getPriceWithTax().getAmount()));

	    List<Offeringquaddetail> offeringquaddetailList = offeringquaddetailRepository.findByOfferingcid(elegibleOffersMt.getCodFija());

	    RelationsMaster relationsMaster = new RelationsMaster();

	    if (!StringUtil.isNullOrEmpty(offeringquaddetailList.get(0).getOfferingcid())) {

		relationsMaster = relationsMasterRepository.findByChildId(CodCatalogo_TecnologiaTV);

		String tvTechnology = null;

		if (!StringUtil.isNullOrEmpty(relationsMaster.getChildId())) {
		    List<CompoWithPropandvalidVal> compoWithPropandvalidVal = compoWithPropandvalidValRepository
			    .findByCompomentCid(relationsMaster.getChildId());

		    tvTechnology = compoWithPropandvalidVal.get(0).getDefaultValue();

		} else {

		    relationsMaster = relationsMasterRepository.findByRootCidAndChildId(CodProducto_TV, CodCatalogo_TecnologiaTV);

		    List<CompoWithPropandvalidVal> compoWithPropandvalidVal = compoWithPropandvalidValRepository
			    .findByCompomentCid(relationsMaster.getChildId());

		    tvTechnology = compoWithPropandvalidVal.get(0).getDefaultValue();

		}

		String internetTechnology = interPlnSpeedandtechRateRepository.findByquey(request.getNetworkTechnology(),
			request.getAction());

		elegibleOffersMt.setTvTechnology(tvTechnology);
		elegibleOffersMt.setInternetTechnology(internetTechnology);

	    }

	    elegibleOffersMtList.add(elegibleOffersMt);

	});

	return elegibleOffersMtList;

    }
}
