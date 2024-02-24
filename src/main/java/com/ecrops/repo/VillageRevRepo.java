

package com.ecrops.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VillageSec;
import com.ecrops.projection.ActiveSeasonProjection;

public interface VillageRevRepo extends JpaRepository<VillageSec, Integer> {

	//villages list based on village secretariate/rbk 

	@Query(value = "select dcode,mcode,wbdcode,wbmcode,vscode,vcode,wbdname,wbmname,wbvname from ecrop2023.villsec_rev_v where vscode=:vscode", nativeQuery = true)
	public List<ActiveSeasonProjection> getVillageListByRbk(@Param("vscode") Integer vscode);
	
	
 


}
