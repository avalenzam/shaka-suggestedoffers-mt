package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Offeringquaddetail implements Serializable {

    private static final long serialVersionUID = -5477424733613115237L;
    @Id
    @Column(name = "ID_TAB_OFFERINGQUADDETAIL")
    private String	      idTabOfferingquaddetail;
    @Column(name = "OFFERINGID")
    private String	      offeringid;
    @Column(name = "OFFERINGCID")
    private String	      offeringcid;
    @Column(name = "DOWNLOADSPEED")
    private String	      downloadspeed;

}
