package com.telefonica.somt.business.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.generated.model.ResponseType;
import com.telefonica.somt.pojo.request.Broadband;
import com.telefonica.somt.pojo.request.Plan;
import com.telefonica.somt.pojo.request.Product;
import com.telefonica.somt.service.SuggestedoffersMtService;

@SpringBootTest
class SuggestedoffersMtServiceTest {

    @Autowired
    private SuggestedoffersMtService suggestedoffersMtService;

    private SuggestedOffersMtRequestDto request;

    @BeforeEach
    void Before() {
	request = new SuggestedOffersMtRequestDto();
	Broadband broadband = new Broadband();
	Product product = new Product();
	Plan plan = new Plan();

//	// MT
//	request.setNationalId("45234899");
//	request.setNationalIdType("DNI");
//	product.setPublicId("920952088,WRSL;217088,BB");

//	// DUOS
//	request.setNationalId("45234899");
//	request.setNationalIdType("DNI");
//	product.setPublicId("14319975,VOICE");
	
//	// TRIO
//	request.setNationalId("73180953");
//	request.setNationalIdType("DNI");
//	product.setPublicId("179668,BB");
	
	// MOVIL
	request.setNationalId("43485083");
	request.setNationalIdType("DNI");
	product.setPublicId("920958676,WRSL");

	
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
    void test() throws Exception {

	ResponseType responseType =suggestedoffersMtService.getSuggestedoffersMt(request);
	System.out.println(responseType);
    }

    @Test
    void test2() {

	List<Plan> planList = new ArrayList<>();
	Plan plan1 = new Plan();
	Plan plan2 = new Plan();
	Plan plan3 = new Plan();
	
	plan1.setId("1");
	plan2.setId("2");
	plan3.setId("3");
	
	planList.add(plan1);
	planList.add(plan3);
	planList.add(plan2);
	
	System.out.println(planList);
	
	List<Plan> planListSyso = planList.stream()
	        .sorted(Comparator.comparing(Plan::getId))
	                .collect(Collectors.toList());
	
	System.out.println(planListSyso);
	
    }
}
