package com.telefonica.somt.repository.rtdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.Offeringquad;

@Repository
public interface OfferingquadRepository  extends JpaRepository<Offeringquad, String>{

    public List<Offeringquad> findByOfferingquadIdIn(List<String> id);
    public Offeringquad findByOfferingquadId(String offeringquadId);
    public Offeringquad findByTipoParrillaAndAmountwithtax(String tipoParrilla, String amountwithtax);
    public Offeringquad findByOfferingquadIdAndTipoParrilla(String offeringquadId, String tipoParrilla);


}
