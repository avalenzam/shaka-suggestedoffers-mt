package com.telefonica.somt.pojo.variables.productInventory;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Author: Jean Kevin Diaz Fuertes.
 * @Datecreation: 13 ago. 2020 01:15:33
 * @FileName: CustomerProduct.java
 * @AuthorCompany: Telefónica
 * @version: 0.1
 * @Description: Representa propiedades de producto del cliente
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProduct implements Serializable {

    private static final long	serialVersionUID = 1L;
    private FijaProduct	fijaProduct;
    private List<MobileProduct>	mobileProduct;
    private Integer		numMobileLine;

}
