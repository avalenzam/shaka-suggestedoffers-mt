package com.telefonica.somt.business.variables.CustomerProduct.mobileProduct;

import org.springframework.stereotype.Component;

import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.dto.productInventory.Characteristic;
import com.telefonica.somt.dto.productInventory.ProductInventoryResponseDto;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: MobileProductVariable.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene las variables relacionadas a la tenencia
 *               actual - movil del cliente
 */
@Component
public class MobileProductVariable {
    /**
     * Metodo principal. Obtiene variables de tenencia movil  del cliente.
     * 
     * @param product:
     *            Respuesta del productInventory
     * @param publicId:
     *            publicId del servicio
     * @return MobileProduct : Retorna objeto poblado.
     */
    public MobileProduct getMobileProduct(ProductInventoryResponseDto product, String publicId) {

  	MobileProduct mobileProduct = new MobileProduct();
  	Boolean amdocs = false;
  	
  	if (product.getPublicId().equals(publicId)) {
  	    
  	  mobileProduct.setMobileNumber(publicId);
  	    
  	    for (Characteristic characteristic : product.getCharacteristics()) {

  		if (Constant.ORIGINSYSTEM.equalsIgnoreCase(characteristic.getName())) {
  		    mobileProduct.setMobilePlantType(Constant.ZERO);
  		    if (characteristic.getValue().equals(Constant.ALDM)) {
  			mobileProduct.setMobilePlantType(Constant.ONE);
  			amdocs = true;
  		    }
  		}

  		if (Constant.INDICATOR_MT.equalsIgnoreCase(characteristic.getName())) {
  		    mobileProduct.setMobileMtClient(characteristic.getValue().toString());

  		}
  	    }

  	    if (Boolean.TRUE.equals(amdocs)) {

  		for (Characteristic characteristic : product.getCharacteristics()) {

  		    if (Constant.PORTING_IND.equalsIgnoreCase(characteristic.getName())) {
  			mobileProduct.setPortabilityMobileIndicator(characteristic.getValue().toString());
  		    }

  		}

  		mobileProduct.setMobileLineType(Constant.TWO);

  		if (Constant.POSTPAID.equalsIgnoreCase(product.getBillingAccounts().get(0).getBillingMethod())) {
  		    mobileProduct.setMobileLineType(Constant.ONE);
  		}

  		mobileProduct.setMobileOfferCodeOrigin(product.getProductOffering().getId());

  	    }
  	    mobileProduct.setRentMobile(product.getProductPrices().get(0).getPrice().getAmount());
  	}
  	return mobileProduct;

      }
    
}
