package com.telefonica.somt.repository.daas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.daas.PrincipalcomponentFAldm;

@Repository
public interface PrincipalcomponentFAldmRepository extends JpaRepository<PrincipalcomponentFAldm, String>{

    @Query("select distinct pfa.productKey from PrincipalcomponentFAldm pfa where pfa.idProductOffer = ?1")
    public String  findProductkeyByIdProductOffer(String idProductOffer);

    
}
