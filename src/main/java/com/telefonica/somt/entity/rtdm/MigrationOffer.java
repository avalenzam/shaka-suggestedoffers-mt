package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "migration_offer", schema = "RE_DATA")
public class MigrationOffer implements Serializable {

    private static final long serialVersionUID = 3924385464253821950L;
    @Id
    @Column(name = "ID_TAB_MIGRATION_OFFER")
    private String	      idTabMigrationOffer;
    @Column(name = "PRIORITIZED_OFFER")
    private String	      prioritizedOffer;
    @Column(name = "CURRENT_PARRILLA")
    private String	      currentParrilla;
    @Column(name = "CURRENT_PLAN")
    private String	      currentPlan;
    @Column(name = "AFFILIATED_MOBILE_LINE")
    private Integer	      affiliatedMobileLine;
    @Column(name = "DESTINATION_PARRILLA")
    private String	      destinationParrilla;

}
