package com.telefonica.somt.business.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: Octubre 2020
 * @FileName: PublicId.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que divide los publicId de acuerdo al servicio
 */
@Component
public class PublicId {
    /**
     * Metodo principal. Realiza la logica que define el cluster de cada tenencia
     * 
     * @param publicIdRequest:
     *            publicId que viene en el request del frotn
     * @return PublicIdResponse :Retorna los publicId 
     */
    public PublicIdResponse getPublicId (String publicIdRequest) {
	
   	PublicIdResponse publicIdResponse = new PublicIdResponse();
   	
   	List<String> publicIdList = Arrays.asList(publicIdRequest.split(";"));
   	List<String> publicIdMobileList = new ArrayList<>();

   	for (String publicId : publicIdList) {

   	    List<String> publicIdSplit = new ArrayList<>();

   	    if (publicId.contains("WRSL")) {

   		publicIdSplit = Arrays.asList(publicId.split(","));
   		publicIdMobileList.add(publicIdSplit.get(0).trim());
   		publicIdResponse.setMobileLine(publicIdMobileList);

   	    } else {
   		
   		publicIdSplit = Arrays.asList(publicId.split(","));
   		
   		String cod = publicIdSplit.get(0).trim();
   		
   		publicIdResponse.setPublicdIdFija(cod);
   	
   		if (publicId.contains("BB")) {
   		   
   		    publicIdResponse.setServiceBbFija(cod);
   		    
   		}else if (publicId.contains("TV")) {
   		    publicIdResponse.setServiceTvFija(cod);
   		    
   		}else if (publicId.contains("VOICE")) {
   		    publicIdResponse.setFijaLine(cod);
   		    
   		}
   		
   	    }

   	}

   	return publicIdResponse;
   	
       }
     
}
