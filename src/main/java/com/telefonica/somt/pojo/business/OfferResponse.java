package com.telefonica.somt.pojo.business;

import java.math.BigDecimal;

import com.telefonica.somt.pojo.clientTenure.ClientTenureResponse;

import lombok.Data;

@Data
public class OfferResponse {

    private String codOffer;
    private ClientTenureResponse clientTenureResponse;
    private BigDecimal recurringPrice;
}
