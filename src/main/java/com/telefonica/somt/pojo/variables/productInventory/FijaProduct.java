package com.telefonica.somt.pojo.variables.productInventory;

import java.util.List;

import com.telefonica.somt.commons.Constant;

import lombok.Data;

@Data
public class FijaProduct {

    private String	 fijaPlantType;
    private String	 portabilityFijaIndicator;
    private String	 fijaMtClient = Constant.NO;
    private String	 originPackage;
    private String	 originOfferType;
    private Float	 rentPackageOrigin = 0f;
    private String	 offerCodeOrigin;
    private String	 originSpeed;
    private String	 tvType;
    private String	 codParentTvBlockOrigin;
    private List<String> codeTvBlockOrigin;
    private List<String> nameTvBlockOrigin;
    private Float	 rentTvBlockOrigin= 0f;
    private String	 tvTechnology;
    private String	 internetTechnology;
    private List<String> typeDecoOrigin;
    private Integer	 numDecoOrigin;
    private List<String> productTypeDecoOrigin;
    private String	 idRepeaterOrigin;
    private String	 typeModemOrigin;
    private String	 subTypeModemOrigin;

}
