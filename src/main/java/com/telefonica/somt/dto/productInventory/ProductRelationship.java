package com.telefonica.somt.dto.productInventory;

import lombok.Data;

@Data
public class ProductRelationship {
    
    private String type;

    private ProductInventoryResponseDto product;
    
}
