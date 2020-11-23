package com.telefonica.somt.repository.rtdm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.FactRecargaKpi;

@Repository
public interface FactRecargaKpiRepository extends JpaRepository<FactRecargaKpi, String>{

    public FactRecargaKpi findByTelefono(String telefono);
    
}
