package com.ecrops.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VillageSecRevEntity;
import com.ecrops.projection.ActiveSeasonProjection;


public interface VillageSecRevRepository extends JpaRepository<VillageSecRevEntity, Integer> {
	

	@Query(value = "select  vcode, wbvname from ecrop2023.villsec_rev_v where vscode=:vscode", nativeQuery = true)
	public List<ActiveSeasonProjection> getVillageListByRbk(@Param("vscode") Integer vscode);
	
	
	


}
