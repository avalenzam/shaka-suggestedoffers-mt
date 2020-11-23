package com.telefonica.somt.pojo.request;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Septiembre 2020
 * @FileName: PaginationInfo.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase usada para un tipo de dato enviado en el request.
 */
@Data
public class PaginationInfo {
    
    private Integer size;
    private Integer pageCount;
    private Integer page;
    private Integer maxResultCount;

}
