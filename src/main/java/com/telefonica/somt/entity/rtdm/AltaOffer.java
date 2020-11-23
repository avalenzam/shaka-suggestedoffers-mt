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
@Table(name = "alta_offer", schema = "RE_DATA")
public class AltaOffer  implements Serializable{

    private static final long serialVersionUID = -7085511619278983068L;
    @Id
    @Column(name = "ID_TAB_ALTA_OFFER")
    private String id;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "BLOQUE_ESTELAR")
    private String bloqueEstelar;   
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;    
    @Column(name = "ARPA_MIN")
    private Float arpaMin;    
    @Column(name = "ARPA_MAX")
    private Float arpaMax; 
    @Column(name = "PRIORITIZED_OFFER")
    private String prioritizedOffer; 
    @Column(name = "GAP_ARPA")
    private BigDecimal gapArpa; 
    @Column(name = "GAP_SPEED")
    private BigDecimal gapSpeed; 
    

}
