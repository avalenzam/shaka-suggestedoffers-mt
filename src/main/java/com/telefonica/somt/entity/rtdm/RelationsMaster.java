package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: RelationsMaster.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla RELATIONS_MASTER. 
* 
*/
@Data
@Entity
@Table(name = "RELATIONS_MASTER", schema = "RE_DATA")
public class RelationsMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TAB_RELATIONS_MASTER")
    private Integer idTabRelationsMaster;

    @Column(name = "RELATION_ID")
    private String relationId;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "IS_MANDATORY")
    private String isMandatory; 
    
    @Column(name = "NAME_PARENT")
    private String nameParent;  

    @Column(name = "CHILD_ID")
    private String childId;

    @Column(name = "ROOT_CID")
    private String rootCid;
}
