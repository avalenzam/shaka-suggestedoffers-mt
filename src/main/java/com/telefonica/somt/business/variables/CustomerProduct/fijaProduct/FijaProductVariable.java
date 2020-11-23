package com.telefonica.somt.business.variables.CustomerProduct.fijaProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.dto.productInventory.Characteristic;
import com.telefonica.somt.dto.productInventory.ProductInventoryResponseDto;
import com.telefonica.somt.dto.productInventory.ProductPrice;
import com.telefonica.somt.dto.productInventory.ProductRelationship;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: FijaProductVariable.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las variables relacionadas a la tenencia
 *               actual - fija del cliente
 */
@Component
public class FijaProductVariable {

    /**
     * Metodo principal. Obtiene variables de tenencia fija del cliente.
     * 
     * @param product:
     *            Respuesta del productInventory
     * @param publicId:
     *            publicId del servicio
     * @return FijaProduct : Retorna objeto poblado.
     */

    public FijaProduct getFijaProduct(ProductInventoryResponseDto product, String publicId) {

	FijaProduct fijaProduct = null;

	if (Boolean.TRUE.equals(isExistsPublicId(product.getProductRelationship(), publicId))) {

	    fijaProduct = new FijaProduct();

	    Boolean amdocs = Boolean.FALSE;

	    for (Characteristic characteristic : product.getCharacteristics()) {

		if (Constant.ORIGINSYSTEM.equalsIgnoreCase(characteristic.getName())) {
		    
		    amdocs = Boolean.TRUE;
		    fijaProduct.setFijaPlantType("1");

		    if (characteristic.getValue().equals(Constant.ATIS) || characteristic.getValue().equals(Constant.CMS)) {
			amdocs = Boolean.FALSE;
			fijaProduct.setFijaPlantType(Constant.ZERO);
		    }

		}

		if (Constant.BUNDLELOBS.equalsIgnoreCase(characteristic.getName())) {

		    String originPackage = characteristic.getValue().toString();
		    fijaProduct.setOriginPackage(originPackage);
		    fijaProduct.setOriginOfferType(getProductName(originPackage));
		}

		if (Constant.INDICATOR_MT.equalsIgnoreCase(characteristic.getName())) {
		    fijaProduct.setFijaMtClient(characteristic.getValue().toString());
		}
	    }

	    for (ProductRelationship productRelationship : product.getProductRelationship()) {

		String productType = productRelationship.getProduct().getProductType();
		List<Characteristic> charasteristicList = productRelationship.getProduct().getCharacteristics();

		if (Boolean.TRUE.equals(amdocs)) {

		    if (Constant.LANDLINE.equalsIgnoreCase(productType)) {
			for (Characteristic characteristic : charasteristicList) {
			    if (Constant.PORTING_IND.equalsIgnoreCase(characteristic.getName())) {
				fijaProduct.setPortabilityFijaIndicator(characteristic.getValue().toString());
			    }

			}
		    }
		}

		if (Constant.BROADBAND.equalsIgnoreCase(productType)) {

		    for (ProductRelationship productRelationshipChild : productRelationship.getProduct().getProductRelationship()) {

			List<Characteristic> charasteristicChildList = productRelationshipChild.getProduct().getCharacteristics();

			if (Constant.INTERNET_PLAN.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

			    for (Characteristic charasteristic : charasteristicChildList) {

				if (Constant.COMMERCIAL_DOWNLOAD_SPEED.equalsIgnoreCase(charasteristic.getName())) {
				    fijaProduct.setOriginSpeed(charasteristic.getValue().toString());
				}

			    }

			}

			if (Constant.ACCESS.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

			    for (Characteristic charasteristic : charasteristicChildList) {

				if (Constant.NETWORK_TECHNOLOGY.equalsIgnoreCase(charasteristic.getName())) {
				    fijaProduct.setInternetTechnology(charasteristic.getValue().toString());
				}

			    }

			}

			if (Constant.ULTRA_WIFI.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {
			    fijaProduct.setIdRepeaterOrigin(productRelationshipChild.getProduct().getProductSpec().getId());

			}

		    }

		}

		if (Constant.CABLEE_TV.equalsIgnoreCase(productType)) {
		    for (ProductRelationship productRelationshipChild : productRelationship.getProduct().getProductRelationship()) {

			List<Characteristic> charasteristicChildList = productRelationshipChild.getProduct().getCharacteristics();

			if (Constant.TV_PLAN.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

			    for (Characteristic charasteristic : charasteristicChildList) {
				if (Constant.FULFILLMENT_CODE.equalsIgnoreCase(charasteristic.getName())) {
				    fijaProduct.setTvType(Constant.NO);
				    if (charasteristic.getValue().toString().contains(Constant.ESTELAR)) {
					fijaProduct.setTvType(Constant.YES);
				    }

				}
			    }

			}

			if (Constant.TV_SERVICE_TECHNOLOGY.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

			    for (Characteristic charasteristic : charasteristicChildList) {
				if (Constant.TV_SERVICE_TECHNOLOGY.equalsIgnoreCase(charasteristic.getName())) {
				    fijaProduct.setTvTechnology(charasteristic.getValue().toString());
				}
			    }

			}

			if (Constant.SVA.equalsIgnoreCase(productRelationshipChild.getProduct().getProductType())) {

			    for (ProductRelationship pr : productRelationshipChild.getProduct().getProductRelationship()) {

				if (Constant.SVA.equalsIgnoreCase(pr.getProduct().getProductType())) {

				    if (Constant.CHANNELS_PACK.equalsIgnoreCase(pr.getProduct().getName())) {

					fijaProduct.setCodParentTvBlockOrigin(pr.getProduct().getProductSpec().getId());

					List<String> nameTvBlockOrigin = new ArrayList<>();
					List<String> codeTvBlockOrigin = new ArrayList<>();

					pr.getProduct().getCharacteristics().forEach(characteristic -> {

					    if (Constant.PACK_NAME.equalsIgnoreCase(characteristic.getName())) {
						nameTvBlockOrigin.add(characteristic.getValue().toString());
					    }

					    if (Constant.ITEM_IDENTIFIER.equalsIgnoreCase(characteristic.getName())) {
						codeTvBlockOrigin.add(characteristic.getValue().toString());
					    }

					});

					fijaProduct.setNameTvBlockOrigin(nameTvBlockOrigin);
					fijaProduct.setCodeTvBlockOrigin(codeTvBlockOrigin);
				    }
				}

			    }

			}

			if (Constant.STBS.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {
			    List<String> productTypeDecoOriginList = new ArrayList<>();
			    List<String> typeDecoOriginlist = new ArrayList<>();
			    Integer numDecoOrigin = 0;

			    for (ProductRelationship pr : productRelationshipChild.getProduct().getProductRelationship()) {
				if (Constant.STB.equalsIgnoreCase(pr.getProduct().getName())) {
				    productTypeDecoOriginList.add(pr.getProduct().getProductType().trim());
				}

				List<Characteristic> charasteristicPrList = pr.getProduct().getCharacteristics();
				for (Characteristic charasteristic : charasteristicPrList) {
				    if (Constant.STB_TYPE.equalsIgnoreCase(charasteristic.getName())) {
					typeDecoOriginlist.add(charasteristic.getValue().toString().trim());
					numDecoOrigin += 1;
				    }
				}

			    }
			    fijaProduct.setProductTypeDecoOrigin(productTypeDecoOriginList);
			    fijaProduct.setTypeDecoOrigin(typeDecoOriginlist);
			    fijaProduct.setNumDecoOrigin(numDecoOrigin);
			}

		    }

		    if (Constant.TV_MAIN.equalsIgnoreCase(productRelationship.getProduct().getName())) {

			for (ProductRelationship productRelationshipChild : productRelationship.getProduct().getProductRelationship()) {

			    if (Constant.TV_ADDIONAL_SERVICES.equalsIgnoreCase(productRelationshipChild.getProduct().getName())) {

				for (ProductRelationship pr : productRelationshipChild.getProduct().getProductRelationship()) {

				    if (Constant.CHANNELS_PACK.equalsIgnoreCase(pr.getProduct().getName())) {

					List<ProductPrice> productPricePrList = pr.getProduct().getProductPrices();

					for (ProductPrice productPrice : productPricePrList) {
					    if (Objects.nonNull(productPrice.getPrice().getAmount())) {
						fijaProduct.setRentTvBlockOrigin(productPrice.getPrice().getAmount());
					    }

					}

				    }
				}
			    }
			}

		    }

		}

		if (Constant.SHARED_EQUIPMENT_MAIN.equalsIgnoreCase(productRelationship.getProduct().getName())) {

		    for (ProductRelationship productRelationshipChild : productRelationship.getProduct().getProductRelationship()) {
			if (Constant.DEVICE.equalsIgnoreCase(productRelationshipChild.getProduct().getProductType())) {

			    for (ProductRelationship pr : productRelationshipChild.getProduct().getProductRelationship()) {

				if (Constant.DEVICE.equalsIgnoreCase(pr.getProduct().getProductType())) {
				    List<Characteristic> charasteristicPrList = pr.getProduct().getCharacteristics();
				    for (Characteristic charasteristic : charasteristicPrList) {
					if (Constant.EQUIPMENT_TYPE.equalsIgnoreCase(charasteristic.getName())) {
					    fijaProduct.setTypeModemOrigin(charasteristic.getValue().toString());
					}
					if (Constant.EQUIPMENT_SUB_TYPE.equalsIgnoreCase(charasteristic.getName())) {
					    fijaProduct.setSubTypeModemOrigin(charasteristic.getValue().toString());

					}
				    }
				}

			    }

			}

		    }
		}

	    }

	    for (ProductPrice productPrice : product.getProductPrices()) {

		if (Constant.TOTAL_PRICE.equalsIgnoreCase(productPrice.getName())) {
		    fijaProduct.setRentPackageOrigin(productPrice.getPrice().getAmount());
		}
	    }

	    fijaProduct.setOfferCodeOrigin(product.getProductOffering().getId());

	}

	return fijaProduct;

    }
    
    private Boolean isExistsPublicId(List<ProductRelationship> productRelationshipList, String publicId ) {
	
	Boolean isExists= Boolean.FALSE;
	
	for (ProductRelationship productRelationship : productRelationshipList ) {
	    String productPublicId = productRelationship.getProduct().getPublicId();
	    System.out.println(productPublicId.equalsIgnoreCase(publicId));
	    if (productPublicId.equalsIgnoreCase(publicId)) {
		isExists= Boolean.TRUE;
	    }
	}
	
	return isExists;
    }

    private String getProductName(String originPackage) {

	String name = null;
	if (Constant.VOICE_INTERNET_TV.equalsIgnoreCase(originPackage)) {
	    name = Constant.TRIO;
	} else if (Constant.VOICE_INTERNET.equalsIgnoreCase(originPackage)) {
	    name = Constant.DUO_BA;
	} else if (Constant.VOICE_TV.equalsIgnoreCase(originPackage)) {
	    name = Constant.DUO_TV;
	} else if (Constant.INTERNET_TV.equalsIgnoreCase(originPackage)) {
	    name = Constant.DUO_BA_TV;
	} else if (Constant.VOICE.equalsIgnoreCase(originPackage)) {
	    name = Constant.MONO_LINEA;
	} else if (Constant.TV.equalsIgnoreCase(originPackage)) {
	    name = Constant.MONO_TV;
	} else if (Constant.INTERNET.equalsIgnoreCase(originPackage)) {
	    name = Constant.MONO_BA;
	}
	return name;

    }
}
