package com.telefonica.somt.repository.rtdm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.InterPlnSpeedandtechRate;

@Repository
public interface InterPlnSpeedandtechRateRepository extends JpaRepository<InterPlnSpeedandtechRate, String>{

     @Query("SELECT Distinct ipsr.networkTechnology FROM InterPlnSpeedandtechRate ipsr" +
     " join  OffersProperties op on op.offerCaption = ipsr.poCode" +
     " where ipsr.networkTechnology= ?1 " +
     " and ipsr.oaType in ( ?2 , '*')" +
     " and ipsr.efectiveDate <= current_date" +
     " and ipsr.expirationDate >= current_date")
     public String findByquey( String networkTechnology, String aoType);
     
}
