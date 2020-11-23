package com.telefonica.somt.repository.rtdm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.PriceProperties;

@Repository
public interface PricePropertiesRepository extends JpaRepository<PriceProperties, String>{
    
   public PriceProperties findByBillingOfferCidAndRevenueTypeAndNamePropAbp(String billingOfferCid, String revenueType, String namePropAbp);

}
