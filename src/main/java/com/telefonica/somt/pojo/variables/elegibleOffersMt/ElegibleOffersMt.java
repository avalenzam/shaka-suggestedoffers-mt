package com.telefonica.somt.pojo.variables.elegibleOffersMt;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ElegibleOffersMt {

    private String	      codOffer;
    private String	      codFija;
    private String	      codMobile;
    private BigDecimal	      totalPrice;
    private String	      idSvaTvBlock;
    private List<String>      codSvaTvBlock;
    private List<String>      svaTypeTvDeco;
    private Integer	      numSvatvDeco;
    private String	      idSvaBb;
    private String	      svaTypeEq;
    private String	      speed;
    private String	      internetTechnology;
    private String	      tvTechnology;

}
