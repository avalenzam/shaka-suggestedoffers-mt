package com.telefonica.somt.repository.rtdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.CompoWithPropandvalidVal;

@Repository
public interface CompoWithPropandvalidValRepository extends JpaRepository<CompoWithPropandvalidVal, String>{

    public List<CompoWithPropandvalidVal> findByCompomentCid(String compomentCid);
    
}
