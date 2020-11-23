package com.telefonica.somt.pojo.request;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Septiembre 2020
 * @FileName: Plan.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase usada para un tipo de dato enviado en el request.
 */
@Data
public class Plan {
    
    private String id;
    private String type;
    private String group;
    private String rankInitial;
    private String rank;
    private String commitmentDuration;

}
