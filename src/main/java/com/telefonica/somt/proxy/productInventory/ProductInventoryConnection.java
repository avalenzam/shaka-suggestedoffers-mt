package com.telefonica.somt.proxy.productInventory;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.dto.productInventory.ProductInventoryResponseDto;




/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: ParqueUnificadoConnection.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa la conexion con el servicio productInventory
 */


@Component
public class ProductInventoryConnection {

    public List<ProductInventoryResponseDto> callRestService(String nationalId , String nationalIdType ) {

	RestTemplate restTemplate = new RestTemplate();

	URI url = UriComponentsBuilder.fromUriString(Constant.PARQUE_UNIFICADO_URL)
		.queryParam("nationalId", nationalId )
	        .queryParam("nationalIdType", nationalIdType )
		.build()
		.encode()                                        
		.toUri(); 

	ResponseEntity<List<ProductInventoryResponseDto>> response =
	        restTemplate.exchange(url,
	                    HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductInventoryResponseDto>>() {
			    } );

	return response.getBody() ;
	 
    }

}
