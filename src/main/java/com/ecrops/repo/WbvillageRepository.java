package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.WbVillageEntity;
import com.ecrops.projection.WbVillageRepository;

public interface WbvillageRepository extends JpaRepository<WbVillageEntity, Integer> {
	
	@Query(value="select wbdcode, wbmcode from wbvillage_mst where dcode=:district and mcode=:mandal",nativeQuery=true)
	public List<WbVillageRepository> getWebLandDetails(@Param("district") Integer district, @Param("mandal") Integer mandal);


	@Query(value="select wbvcode, wbvname from wbvillage_mst where wbvcode in(select vcode from villsec_rev_v where vscode=:rbkcode)",nativeQuery=true)
	public List<WbVillageRepository> getWebLandDet(@Param("rbkcode") Integer rbkCode);

}
