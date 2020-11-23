package com.telefonica.somt.proxy.elegibleOffersMt;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telefonica.somt.commons.Constant;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.generated.model.ResponseType;

@Component
public class ElegibleOffersMtConnection {
    public ResponseType callRestService(SuggestedOffersMtRequestDto request ) {

	RestTemplate restTemplate = new RestTemplate();

	URI url = UriComponentsBuilder.fromUriString(Constant.ELEGIBLE_OFFERS_MT_URL)
		.queryParam("channelId", request.getChannelId() )
	        .queryParam("productType", request.getProduct().getType() )
	        .queryParam("creditScore", request.getCreditScore() )
	        .queryParam("creditLimit", request.getCreditLimit() )
	        .queryParam("region", request.getRegion() )
	        .queryParam("stateOrProvince", request.getStateOrProvince() )
	        .queryParam("customerSegment", request.getCustomerSegment() )
	        .queryParam("isPortability", request.getIsPortability() )
	        .queryParam("dealerId", request.getDealerId() )
	        .queryParam("isRetention", request.getIsRetention() )
	        .queryParam("productOfferingCatalogId", request.getProductOfferingCatalogId() )
		.queryParam("action", request.getAction() )
	        .queryParam("commercialAreaId", request.getCommercialAreaId() )
	        .queryParam("planId", request.getPlan().getId() )
	        .queryParam("siteId", request.getSiteId())
	        .queryParam("currentOffering", request.getCurrentOffering() )
	        .queryParam("networkTechnology", request.getNetworkTechnology() )
	        .queryParam("serviceabilityMaxSpeed", request.getServiceabilityMaxSpeed() )
	        .queryParam("subscriberGroupValue", request.getSubscriberGroupValue() )
	        .queryParam("installationAddressDepartment", request.getInstallationAddressDepartment() )
	        .queryParam("broadbandConnection", request.getBroadband().getConnection() )
		.build()
		.encode()                                        
		.toUri(); 

	ResponseEntity<ResponseType> response =
	        restTemplate.exchange(url,
	                    HttpMethod.GET, null, new ParameterizedTypeReference<ResponseType>() {
			    } );

	return response.getBody() ;
	 
    }
}
