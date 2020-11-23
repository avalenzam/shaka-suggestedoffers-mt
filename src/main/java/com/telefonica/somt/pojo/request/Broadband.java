package com.telefonica.somt.pojo.request;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Septiembre 2020
 * @FileName: Broadband.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase usada para un tipo de dato enviado en el request.
 */
@Data
public class Broadband {

    private Integer minDlDataRate;
    private Integer maxDlDataRate;
    private String connection;
}
