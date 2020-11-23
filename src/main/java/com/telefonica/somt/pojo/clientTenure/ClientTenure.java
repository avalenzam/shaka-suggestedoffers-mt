package com.telefonica.somt.pojo.clientTenure;

import com.telefonica.somt.generated.model.ComposingProductType.ProductTypeEnum;

import lombok.Data;

@Data
public class ClientTenure {

    private String id;
    private String name;
    private ProductTypeEnum productType;
    private ProductCharacteristic productCharacteristic;
    
}
