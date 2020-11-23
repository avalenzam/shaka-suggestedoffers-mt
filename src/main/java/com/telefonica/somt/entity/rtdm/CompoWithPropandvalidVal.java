package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "COMPO_WITH_PROPANDVALID_VAL", schema = "RE_DATA")
public class CompoWithPropandvalidVal implements Serializable{

    private static final long serialVersionUID = 3265270575883741190L;
    @Id
    @Column(name = "ID_TAB_COMPO_PROPVALID")
    private String	      idTabCompoPropvalid;
    @Column(name = "COMPONENT_CID")
    private String	      compomentCid;
    @Column(name = "DEFAULT_VALUE")
    private String	      defaultValue;
    
    
    

}
