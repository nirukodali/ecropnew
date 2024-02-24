package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.VillageUpdation;

@Repository
public interface VillageUpdationRepo extends JpaRepository<VillageUpdation, String>{
	
	@Query(value="select cropid,cropname from public.cropnames where active='A' and cropnature='A'",nativeQuery = true)
	public List<VillageUpdation> VillageNormalAreasUpdation();
	
	@Query(value="select cropid,cropname from cropnames  where cropnature='H' and active='A' order by cropname",nativeQuery = true)
	public List<VillageUpdation> VillageNormalAreasUpdationHO();

	
	@Query(value="select mcode,mname from mandal_2011_cs where dcode=:dcode  order by mname",nativeQuery = true)
	public List<mandal_2011_cs> mandName(int dcode);
	
	interface mandal_2011_cs{
		int getMcode();
		String getMname();
	}

}
