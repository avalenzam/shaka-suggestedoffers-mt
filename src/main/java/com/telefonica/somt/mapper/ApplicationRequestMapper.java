package com.telefonica.somt.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.pojo.request.Broadband;
import com.telefonica.somt.pojo.request.PaginationInfo;
import com.telefonica.somt.pojo.request.Plan;
import com.telefonica.somt.pojo.request.Portability;
import com.telefonica.somt.pojo.request.Product;
import com.telefonica.somt.pojo.request.ProductOfferingPrice;

@Component
public class ApplicationRequestMapper {

	public SuggestedOffersMtRequestDto fromParamstoBody(String type, String correlationId, String name, Boolean isBundle,
			String lifeCycleStatus, String categoryId, String categoryName, String subcategoryId,
			String subcategoryName, String channelId, String channelName, String productSpecificationId,
			String productSpecificationName, String frameworkAgreeementId, String customerId, String accountId,
			String productType, String productId, String productPublicId, DateTime startDate,
			DateTime endDate, String limit, String offset, String productOfferingPricePriceUnits,
			DateTime productOfferingPriceCurrencyChangeDate, DateTime productOfferingPriceStartPriceDate,
			DateTime productOfferingPriceEndPriceDate, String productOfferingPricePriceConsumerEntityType,
			String productOfferingPricePriceConsumerId, String productOfferingPricePriceLocation,
			BigDecimal productOfferingPriceStartPriceAmout, BigDecimal productOfferingPriceEndPriceAmout, String fields,
			Integer creditScore, BigDecimal creditLimit, String siteId, String region, String stateOrProvince,
			String customerSegment, String customerSubsegment, Boolean isPortability, String portabilityCurrentPlanType,
			LocalDate portabilityCustomerSince, String portabilityCurrentCompany, String dealerId,
			Integer broadbandMinDlDataRate, Integer broadbandMaxDlDataRate, String broadbandConnection,
			Boolean isRetention, String productOfferingCatalogId, String currentOffering, Boolean isUpgrade,
			String action, String commercialAreaId, String productOrderId, String planId, String planType,
			String sourceType, String networkTechnology, String serviceabilityMaxSpeed, String serviceabilityId,
			String planGroup, String planRankInitial, String planRank, String planCommitmentDuration,
			String invoiceCompany, String orderSubType, String subscriberGroupValue, String excludeOffersId,
			String installationAddressDepartment, String nationalID, String nationalIDType,
			Integer paginationInfoSize, Integer paginationInfoPageCount, Integer paginationInfoPage,
			Integer paginationInfoMaxResultCount, String sortCriteriaName, Boolean sortCriteriaAscending) {

	    SuggestedOffersMtRequestDto offersBenefitsRequestDto = new SuggestedOffersMtRequestDto();
		Product product = new Product();
		ProductOfferingPrice pop = new ProductOfferingPrice();
		Portability portability = new Portability();
		Broadband broadband = new Broadband();
		Plan plan = new Plan();
		PaginationInfo paginationInfo = new PaginationInfo();

		offersBenefitsRequestDto.setType(type);
		offersBenefitsRequestDto.setCorrelationId(correlationId);
		offersBenefitsRequestDto.setName(name);
		offersBenefitsRequestDto.setIsBundle(isBundle);
		offersBenefitsRequestDto.setLifeCycleStatus(lifeCycleStatus);
		offersBenefitsRequestDto.setCategoryId(categoryId);
		offersBenefitsRequestDto.setCategoryName(categoryName);
		offersBenefitsRequestDto.setSubcategoryId(subcategoryId);
		offersBenefitsRequestDto.setSubcategoryName(subcategoryName);
		offersBenefitsRequestDto.setChannelId(channelId);
		offersBenefitsRequestDto.setChannelName(channelName);
		offersBenefitsRequestDto.setProductSpecificationId(productSpecificationId);
		offersBenefitsRequestDto.setProductSpecificationName(productSpecificationName);
		offersBenefitsRequestDto.setFrameworkAgreeementId(frameworkAgreeementId);
		offersBenefitsRequestDto.setCustomerId(customerId);
		offersBenefitsRequestDto.setAccountId(accountId);
		product.setType(productType);
		product.setId(productId);
		product.setPublicId(productPublicId);
		offersBenefitsRequestDto.setProduct(product);
		offersBenefitsRequestDto.setStartDate(startDate);
		offersBenefitsRequestDto.setEndDate(endDate);
		offersBenefitsRequestDto.setLimit(limit);
		offersBenefitsRequestDto.setOffset(offset);
		pop.setPriceUnits(productOfferingPricePriceUnits);
		pop.setCurrencyChangeDate(productOfferingPriceCurrencyChangeDate);
		pop.setStartPriceDate(productOfferingPriceStartPriceDate);
		pop.setEndPriceDate(productOfferingPriceEndPriceDate);
		pop.setPriceConsumerEntityType(productOfferingPricePriceConsumerEntityType);
		pop.setPriceConsumerId(productOfferingPricePriceConsumerId);
		pop.setPriceLocation(productOfferingPricePriceLocation);
		pop.setStartPriceAmout(productOfferingPriceStartPriceAmout);
		pop.setEndPriceAmout(productOfferingPriceEndPriceAmout);
		offersBenefitsRequestDto.setProductOfferingPrice(pop);
		offersBenefitsRequestDto.setFields(fields);
		offersBenefitsRequestDto.setCreditScore(creditScore);
		offersBenefitsRequestDto.setCreditLimit(creditLimit);
		offersBenefitsRequestDto.setSiteId(siteId);
		offersBenefitsRequestDto.setRegion(region);
		offersBenefitsRequestDto.setStateOrProvince(stateOrProvince);
		offersBenefitsRequestDto.setCustomerSegment(customerSegment);
		offersBenefitsRequestDto.setCustomerSubsegment(customerSubsegment);
		offersBenefitsRequestDto.setIsPortability(isPortability);
		portability.setCurrentPlanType(portabilityCurrentPlanType);
		portability.setCustomerSince(portabilityCustomerSince);
		portability.setCurrentCompany(portabilityCurrentCompany);
		offersBenefitsRequestDto.setPortability(portability);
		offersBenefitsRequestDto.setDealerId(dealerId);
		broadband.setMinDlDataRate(broadbandMinDlDataRate);
		broadband.setMaxDlDataRate(broadbandMaxDlDataRate);
		broadband.setConnection(broadbandConnection);
		offersBenefitsRequestDto.setBroadband(broadband);
		offersBenefitsRequestDto.setIsRetention(isRetention);
		offersBenefitsRequestDto.setProductOfferingCatalogId(productOfferingCatalogId);
		offersBenefitsRequestDto.setCurrentOffering(currentOffering);
		offersBenefitsRequestDto.setIsUpgrade(isUpgrade);
		offersBenefitsRequestDto.setAction(action);
		offersBenefitsRequestDto.setCommercialAreaId(commercialAreaId);
		offersBenefitsRequestDto.setProductOrderId(productOrderId);
		plan.setId(planId);
		plan.setGroup(planGroup);
		plan.setRankInitial(planRankInitial);
		plan.setRank(planRank);
		plan.setCommitmentDuration(planCommitmentDuration);
		offersBenefitsRequestDto.setPlan(plan);
		offersBenefitsRequestDto.setProductPlanType(planType);
		offersBenefitsRequestDto.setSourceType(sourceType);
		offersBenefitsRequestDto.setNetworkTechnology(networkTechnology);
		offersBenefitsRequestDto.setServiceabilityMaxSpeed(serviceabilityMaxSpeed);
		offersBenefitsRequestDto.setServiceabilityId(serviceabilityId);
		offersBenefitsRequestDto.setInvoiceCompany(invoiceCompany);
		offersBenefitsRequestDto.setOrderSubType(orderSubType);
		offersBenefitsRequestDto.setSubscriberGroupValue(subscriberGroupValue);
		offersBenefitsRequestDto.setExcludeOffersId(excludeOffersId);
		offersBenefitsRequestDto.setInstallationAddressDepartment(installationAddressDepartment);
		offersBenefitsRequestDto.setNationalId(nationalID);
		offersBenefitsRequestDto.setNationalIdType(nationalIDType);
		paginationInfo.setSize(paginationInfoSize);
		paginationInfo.setPageCount(paginationInfoPageCount);
		paginationInfo.setPage(paginationInfoPage);
		paginationInfo.setMaxResultCount(paginationInfoMaxResultCount);
		offersBenefitsRequestDto.setPaginationInfo(paginationInfo);
		offersBenefitsRequestDto.setSortCriteriaName(sortCriteriaName);
		offersBenefitsRequestDto.setSortCriteriaAscending(sortCriteriaAscending);

		return offersBenefitsRequestDto;
	}

}
