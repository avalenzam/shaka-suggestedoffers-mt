package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Offeringquad implements Serializable{

    private static final long serialVersionUID = 7360040996831927836L;
    @Id
    @Column(name ="ID_TAB_OFFERINGQUAD")
    private String idTabOfferingquad;
    @Column(name ="ID")
    private String offeringquadId;
    @Column(name ="AMOUNTWITHTAX")
    private String amountwithtax;
    @Column(name ="TIPO_PARRILLA")
    private String tipoParrilla;
    
}
