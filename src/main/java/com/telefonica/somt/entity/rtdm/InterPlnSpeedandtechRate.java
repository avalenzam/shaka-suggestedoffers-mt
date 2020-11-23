package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "INTER_PLN_SPEEDANDTECH_RATE", schema = "RE_DATA")
public class InterPlnSpeedandtechRate implements Serializable{
     
    private static final long serialVersionUID = -5910512328077540439L;
    @Id
    @Column(name = "ID_TAB_INTERPLN_SPEED")
    private String	      idTabInterplnSpeed;
    @Column(name = "PO_CODE")
    private String	      poCode;
    @Column(name = "NETWORK_TECHNOLOGY")
    private String	      networkTechnology;
    @Column(name = "OA_TYPE")
    private String	      oaType;
    @Column(name = "EFFECTIVE_DATE")
    private Date	      efectiveDate;
    @Column(name = "EXPIRATION_DATE")
    private Date	      expirationDate;

}