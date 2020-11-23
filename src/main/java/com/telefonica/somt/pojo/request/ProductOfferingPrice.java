package com.telefonica.somt.pojo.request;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Septiembre 2020
 * @FileName: ProductOfferingPrice.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase usada para un tipo de dato enviado en el request.
 */
@Data
public class ProductOfferingPrice {

    private String priceUnits;
    private DateTime currencyChangeDate;
    private DateTime startPriceDate;
    private DateTime endPriceDate;
    private String priceConsumerEntityType;
    private String priceConsumerId;
    private String priceLocation;
    private BigDecimal startPriceAmout;
    private BigDecimal endPriceAmout;
}
