package com.telefonica.somt.pojo.clientTenure;

import java.util.List;

import lombok.Data;

@Data
public class PublicIdResponse {
    
    String publicdIdFija;
    List<String> mobileLine;
    String serviceBbFija;
    String serviceTvFija;
    String fijaLine;
    

}
