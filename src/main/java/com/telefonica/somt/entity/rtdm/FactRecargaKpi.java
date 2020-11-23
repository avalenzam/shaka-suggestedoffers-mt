package com.telefonica.somt.entity.rtdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "FactRecargaKPI", schema = "RE_DATA")
public class FactRecargaKpi implements Serializable{

    private static final long serialVersionUID = -7734121051653219253L;
    @Id
    @Column(name = "ID_TAB_FACTRECARGAKPI")
    private String id;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "prommontorecargas")
    private Float prommontorecargas;    

}
