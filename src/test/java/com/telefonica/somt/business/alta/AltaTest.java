package com.telefonica.somt.business.alta;


import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.somt.business.others.PublicId;
import com.telefonica.somt.business.variables.CustomerProduct.CustomerProductVariable;
import com.telefonica.somt.business.variables.ElegibleOfferMt.ElegibleOffersMtVariable;
import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.generated.model.ResponseType;
import com.telefonica.somt.pojo.business.OfferResponse;
import com.telefonica.somt.pojo.clientTenure.PublicIdResponse;
import com.telefonica.somt.pojo.request.Broadband;
import com.telefonica.somt.pojo.request.Plan;
import com.telefonica.somt.pojo.request.Product;
import com.telefonica.somt.pojo.variables.elegibleOffersMt.ElegibleOffersMt;
import com.telefonica.somt.pojo.variables.productInventory.CustomerProduct;
import com.telefonica.somt.proxy.elegibleOffersMt.ElegibleOffersMtConnection;

@SpringBootTest
class AltaTest {

    @Autowired
    private Alta alta;
    @Autowired
    private PublicId		     publicId;
    @Autowired
    private CustomerProductVariable customerProductVariable;
    @Autowired
    private ElegibleOffersMtConnection	       elegibleOffersMtConnection;
    @Autowired
    private ElegibleOffersMtVariable elegibleOffersMtVariable;
  
    
    private SuggestedOffersMtRequestDto request;
    
    @BeforeEach
    void Before() {
	request = new SuggestedOffersMtRequestDto();
	Broadband broadband = new Broadband();
	Product product = new Product();
	Plan plan = new Plan();

	// DUOS
	request.setNationalId("45234899");
	product.setPublicId("14319975,VOICE");
	
//	// MOVIL
//	request.setNationalId("43485083");
//	product.setPublicId("920958676,WRSL");

	request.setNationalIdType("DNI");
	request.setCategoryId("3195941");
	request.setChannelId("CEC");
	product.setType("MT");
	request.setProduct(product);
	request.setCreditScore(9990);
	request.setCreditLimit(BigDecimal.valueOf(999));
	request.setRegion("15");
	request.setStateOrProvince("1");
	request.setCustomerSegment("R");
	request.setIsPortability(false);
	request.setDealerId("91001");
	request.setIsRetention(true);
	request.setProductOfferingCatalogId("3");
	request.setAction("PR");
	request.setCommercialAreaId("1");
	request.setSiteId("91001001");
	plan.setId("4269648:34715111");
	request.setPlan(plan);
	request.setCurrentOffering("34423415");
	request.setNetworkTechnology("HFC");
	request.setServiceabilityMaxSpeed("300");
	request.setSubscriberGroupValue("POS1");
	request.setInstallationAddressDepartment("15");
	broadband.setConnection("HFC");
	request.setBroadband(broadband);

    }
    @Test
    void test() {
	
	PublicIdResponse publicIdResponse = publicId.getPublicId(request.getProduct().getPublicId());
	CustomerProduct customerProduct  =customerProductVariable.getCustomerProductVariable(request, publicIdResponse);
	ResponseType elegibleOfferMtService = elegibleOffersMtConnection.callRestService(request);
	List<ElegibleOffersMt> elegibleOffersMtList = elegibleOffersMtVariable.getElegibleOffersMtVariable(request, elegibleOfferMtService);
		
	List<OfferResponse> altaResponse = alta.getAlta(customerProduct, publicIdResponse, elegibleOffersMtList);
	System.out.println(altaResponse);
    }

}
