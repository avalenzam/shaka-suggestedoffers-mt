package com.telefonica.somt.pojo.variables.productInventory;

import com.telefonica.somt.commons.Constant;

import lombok.Data;

@Data
public class MobileProduct {

    private String mobilePlantType;
    private String mobileLineType;
    private String portabilityMobileIndicator;
    private String mobileMtClient = Constant.NO;
    private String mobileOfferCodeOrigin;
    private Float  rentMobile= 0f;
    private String mobileNumber;
    private String originOfferType;

}
