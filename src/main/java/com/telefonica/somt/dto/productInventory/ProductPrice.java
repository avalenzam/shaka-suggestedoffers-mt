package com.telefonica.somt.dto.productInventory;

import lombok.Data;

@Data
public class ProductPrice {
    
    private String id;

    private String name; 

    private String priceType;  

    private Price price;
}
