package com.telefonica.somt.pojo.request;

import java.time.LocalDate;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Septiembre 2020
 * @FileName: Portability.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase usada para un tipo de dato enviado en el request.
 */
@Data
public class Portability {

    private String currentPlanType;
    private LocalDate customerSince;
    private String currentCompany;
}
