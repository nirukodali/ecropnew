package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VillageSecDetEntity;
import com.ecrops.projection.VillageName;

public interface VillageSecDetRepository extends JpaRepository<VillageSecDetEntity, Integer>
{
	@Query(value="select vcode, vname from vill_sec_det where mcode=:mandal",nativeQuery=true)
	public List<VillageName> findVillName(@Param("mandal") Integer mandal);

}
