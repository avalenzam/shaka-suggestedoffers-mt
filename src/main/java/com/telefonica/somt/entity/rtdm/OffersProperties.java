package com.telefonica.somt.entity.rtdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: OffersProperties.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla OFFERS_PROPERTIES. 
* 
*/
@Data
@Entity
@Table(name = "OFFERS_PROPERTIES", schema = "RE_DATA")
public class OffersProperties {
    
    @Id
    @Column(name = "ID_TAB_OFFERS_PROPERTIES")
    private String id;
    
    @Column(name = "OFFER_CID")
    private String offerCid;
    
    @Column(name = "OFFER_CAPTION")
    private String offerCaption;
    
    @Column(name = "OFFER_LAST_VERSION")
    private String offerLastVersion;
    
    @Column(name = "NAME_OF_PROPERTY")
    private String nameOfProperty;
    
    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;

}
