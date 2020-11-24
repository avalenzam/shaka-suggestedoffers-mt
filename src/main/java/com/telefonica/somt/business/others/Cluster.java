package com.telefonica.somt.business.others;

import org.springframework.stereotype.Component;

import com.hazelcast.util.StringUtil;
import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.commons.Util;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.variables.productInventory.FijaProduct;
import com.telefonica.somt.pojo.variables.productInventory.MobileProduct;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: Cluster.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que define el cluster de la tenencia
 */
@Component
public class Cluster {
    /**
     * Metodo principal. Realiza la logica que define el cluster de cada tenencia
     * 
     * @param publicIdResponse:
     *            Objeto con los publicId de acuerdo al servicio
     * @param fijaProduct:
     *            Objeto con las variables de fija
     * @param mobileProduct:
     *            Objeto con las variables de mobil
     * @return List<OfferResponse> : Retorna lista de tenencias y codigo de oferta
     *         MT
     */
    public String getCluster(PublicIdResponse publicIdResponse, FijaProduct fijaProduct, MobileProduct mobileProduct) {

	String cluster = null;

	if (StringUtil.isNullOrEmpty(publicIdResponse.getServiceBbFija()) && StringUtil.isNullOrEmpty(publicIdResponse.getServiceTvFija())
		&& StringUtil.isNullOrEmpty(publicIdResponse.getFijaLine())) {

	    if (Constant.ONE.equalsIgnoreCase(mobileProduct.getMobilePlantType())) {

		if (Constant.ONE.equalsIgnoreCase(mobileProduct.getMobileLineType())) {
		    cluster = Constant.SOLO_MOVIL_CLUSTER;
		} else if (Constant.TWO.equalsIgnoreCase(mobileProduct.getMobileLineType())) {
		    cluster = Constant.SOLO_PREPAGO;
		}
	    }

	} else {

	    if (Constant.ONE.equalsIgnoreCase(fijaProduct.getFijaPlantType())) {

		if (Boolean.FALSE.equals(Util.isEmptyOrNullList(publicIdResponse.getMobileLine()))) {

		    if (Constant.NO.equalsIgnoreCase(fijaProduct.getPortabilityFijaIndicator())) {
			cluster = Constant.SOLOFIJA;
		    } else {
			cluster = Constant.SOLOFIJA_PORTA;
		    }

		} else {

		    if (Constant.NO.equalsIgnoreCase(fijaProduct.getPortabilityFijaIndicator())
			    && Constant.NO.equalsIgnoreCase(mobileProduct.getPortabilityMobileIndicator())) {
			cluster = Constant.TOTALIZADO;
		    } else {
			cluster = Constant.TOTALIZADO_PORTA;
		    }
		}

	    }
	}

	return cluster;
    }
}
