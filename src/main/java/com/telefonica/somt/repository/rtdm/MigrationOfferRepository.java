package com.telefonica.somt.repository.rtdm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.MigrationOffer;

@Repository
public interface MigrationOfferRepository extends JpaRepository<MigrationOffer, String>{
    
    public MigrationOffer findByCurrentPlanAndAffiliatedMobileLineAndDestinationParrillaIgnoreCase (String currentPlan, Integer affiliatedMobileLine, String destinationParrilla);
    public MigrationOffer  findByPrioritizedOfferAndDestinationParrillaIgnoreCase (String prioritizedOffer, String destinationParrilla);
    
}
