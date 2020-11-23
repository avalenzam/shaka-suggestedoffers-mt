package com.telefonica.somt.entity.daas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PRINCIPALCOMPONENT_F_ALDM", schema = "p_daas_data")
public class PrincipalcomponentFAldm implements Serializable {

    private static final long serialVersionUID = 8462352863844501009L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "ID_PRODUCT_OFFER")
    private String idProductOffer;
    @Column(name = "PRODUCT_KEY")
    private String productKey;

}
