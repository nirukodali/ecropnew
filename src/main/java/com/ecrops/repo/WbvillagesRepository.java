package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.WbVillageMastEntity;
import com.ecrops.projection.WbVillageMastProjection;

public interface WbvillagesRepository extends JpaRepository<WbVillageMastEntity, Integer> {
	
	@Query(value="select wbdcode, wbmcode from wbvillage_mst where dcode=:district and mcode=:mandal",nativeQuery=true)
	public List<WbVillageMastProjection> getWebLandDetails(@Param("district") Integer district, @Param("mandal") Integer mandal);


	@Query(value="select wbvcode, wbvname from wbvillage_mst where wbvcode in(select vcode from ecrop2023.villsec_rev_v where vscode=:rbkcode)",nativeQuery=true)
	public List<WbVillageMastProjection> getWebLandDet(@Param("rbkcode") Integer rbkCode);
	
	@Query(value="select wbvcode, wbvname from wbvillage_mst where mcode=:mcode and ecrop_dwn='Y' and wbvcode not in (select vcode from ecrop2023.downloaddetails where cropyear=:cropyear and season=:season)",nativeQuery=true)
	public List<WbVillageMastProjection> getVillageData(@Param("mcode") Integer mcode,@Param("cropyear") Integer cropyear,@Param("season") String season);
  
	
	WbVillageMastEntity findByWbvcode(Integer vcode);
}
