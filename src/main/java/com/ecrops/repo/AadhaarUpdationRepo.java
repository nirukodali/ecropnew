package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.AadhaarUpdation;

@Repository
public interface AadhaarUpdationRepo extends JpaRepository<AadhaarUpdation, Integer>{

	@Query(value = "SELECT distinct wbvname,vscode,dcode,mcode  from ecrop2023.villsec_rev_v  WHERE vscode=:vscode ", nativeQuery = true)
	List<AadhaarUpdation> getVillage(@Param("vscode") int vscode);
	
	@Query(value="select vscode,dcode,mcode,wbvname,wbvcode from wbvillage_mst  WHERE mcode =:mcode",nativeQuery = true)
	List<AadhaarUpdation> getVillageNames(@Param("mcode") int mcode);
	
	
	 

	
}