package com.telefonica.somt.dto.productInventory;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDataPI {

    private String id;

    private String href;

    private List<Characteristic> characteristics;
    
    private ProductOffering productOffering;

    private List<ProductRelationship> productRelationship;
}
