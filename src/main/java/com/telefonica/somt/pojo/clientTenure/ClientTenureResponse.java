package com.telefonica.somt.pojo.clientTenure;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ClientTenureResponse {

    private ClientTenure       repeaterTenue;
    private ClientTenure       modemTenue;
    private List<ClientTenure> decoTenue;
    private ClientTenure       blockTenue;
    private Boolean	       avalibleOffer;
    private BigDecimal	       recurringPrice;

}
