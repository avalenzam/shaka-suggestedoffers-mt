package com.telefonica.somt.repository.rtdm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.somt.entity.rtdm.RelationsMaster;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: RelationsMasterRepo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Repositorio para consultas del entity RelationsMaster. 
* 
*/
@Repository
public interface RelationsMasterRepository extends JpaRepository<RelationsMaster, Integer> {

    public RelationsMaster findByRootCidAndParentId(String rootCid, String parentId);
    public RelationsMaster findByChildId(String childId);
    public RelationsMaster findByRootCidAndChildId(String rootCid, String childId);
    public RelationsMaster findByRootCidAndChildIdAndParentId(String rootCid, String childId, String parentId);
    
}
