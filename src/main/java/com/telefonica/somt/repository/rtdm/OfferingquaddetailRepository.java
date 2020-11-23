package com.telefonica.somt.repository.rtdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.Offeringquaddetail;

@Repository
public interface OfferingquaddetailRepository extends JpaRepository<Offeringquaddetail, String>{
    
    public List<Offeringquaddetail> findByOfferingcid(String offeringcid);
    


}
