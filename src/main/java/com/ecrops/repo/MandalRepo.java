package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.MandalEntity;
import com.ecrops.projection.VillageName;

public interface MandalRepo extends JpaRepository<MandalEntity, Integer> {
	@Query(value="select mname from mandal_2011_cs where mcode=:mandalCode",nativeQuery=true)
	public List<VillageName> getmandalName(@Param("mandalCode") Integer mandalCode);
	
	@Query(value="select mcode, mname from mandal_2011_cs where dcode=:distCode",nativeQuery=true)
	public List<VillageName> getmname(@Param("distCode") Integer distCode);
}
