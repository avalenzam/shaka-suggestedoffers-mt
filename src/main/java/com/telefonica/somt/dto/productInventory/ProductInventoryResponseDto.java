package com.telefonica.somt.dto.productInventory;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductInventoryResponseDto {

    private String id;

    private String productType;

    private String href;

    private String publicId;

    private String description; 

    private String startDate;

    private String name;

    private ProductSpec productSpec;

    @JsonProperty(value = "characteristic")
    private List<Characteristic> characteristics = new ArrayList<>();

    private List<ProductRelationship> productRelationship = new ArrayList<>();

    private ProductOffering productOffering;

    @JsonProperty(value = "billingAccount")
    private List<BillingAccount> billingAccounts = new ArrayList<>();

    @JsonProperty(value = "productPrice")
    private List<ProductPrice> productPrices = new ArrayList<>();

}
