package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PRICE_PROPERTIES", schema = "RE_DATA")
public class PriceProperties implements Serializable {
    
    private static final long serialVersionUID = -3939588316401216365L;
    @Id
    @Column(name = "ID_TAB_PRICE_PROPERTIES")
    private String idTabPriceProperties; 
    @Column(name = "VALUE_ABP")
    private BigDecimal valueAbp; 
    @Column(name = "BILLING_OFFER_CID")
    private String billingOfferCid;
    @Column(name = "REVENUE_TYPE")
    private String revenueType;
    @Column(name = "NAME_PROP_ABP")
    private String namePropAbp;

}
