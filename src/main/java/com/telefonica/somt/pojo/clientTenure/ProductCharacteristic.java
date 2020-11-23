package com.telefonica.somt.pojo.clientTenure;

import com.telefonica.somt.generated.model.ProductSpecCharacteristicType.ValueTypeEnum;

import lombok.Data;

@Data
public class ProductCharacteristic {
    
    private String id;
    private String name;
    private ValueTypeEnum  valueType;
    private String value;

}
