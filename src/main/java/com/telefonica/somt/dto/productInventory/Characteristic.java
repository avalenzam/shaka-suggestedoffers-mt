package com.telefonica.somt.dto.productInventory;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;

@Data
public class Characteristic {

    private String valueType;

    private String name;

    @JsonTypeInfo(use = Id.NAME, property = "valueType", include = As.EXTERNAL_PROPERTY)
    @JsonSubTypes(value = { 
            @JsonSubTypes.Type(value = String.class, name = "String"),
            @JsonSubTypes.Type(value = Object.class, name = "Object") 
    })

    private Object value;
}
