package com.telefonica.somt.repository.rtdm;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.AltaOffer;

@Repository
public interface AltaOfferRepository extends JpaRepository<AltaOffer, String> {

    @Query("select ao.prioritizedOffer from AltaOffer ao" + " where TRIM(ao.product) = ?1" + " and ao.bloqueEstelar = ?2"
	    + " and  ao.customerType like %?3%" + " and ao.arpaMin <= ?4" + " and ao.arpaMax > ?4 ")
    public String findByArpa(String product, String bloqueEstelar, String customerType, Float arpa);

    @Query("select id from AltaOffer where TRIM(product) = ?1" + " and gapArpa < ?2" + " and gapSpeed < ?3" + " and customerType like %?4% ")
    public String findByGapArpaAndSpeed(String product, BigDecimal gapArpa, BigDecimal gapSpeed, String customerType);
    
    @Query("select id from AltaOffer where TRIM(product) = ?1" + " and gapArpa < ?2" + " and customerType like %?3% ")
    public String findByGapArpa(String product, BigDecimal gapArpa,  String customerType);

    @Query("select ao.id from AltaOffer ao where ao.product = ?1" 
	    + " and ao.gapArpa <= ?2" 
	    + " AND TO_NUMBER(ao.gapSpeed, '9999.99') < ?3" 
	    + " and ao.customerType like %?4% ")
    public String findByGapArpaDuoBa(String product, BigDecimal gapArpa, BigDecimal gapSpeed, String customerType);
    
}
