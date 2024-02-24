package com.ecrops.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.SuperCheckRecordsAlloted;
import com.ecrops.projections.MasterProjections;



public interface DropdownsRepo extends JpaRepository<SuperCheckRecordsAlloted, String> {
	
	@Query(value="select distinct on (a.cropyear,a.season) concat(a.season,'@',cropyear) as col1,concat(b.seasonname,' ',cropyear) as col2 \r\n" + 
			" from activeseason a,season b  where   a.season=b.season and a.active='A' order by a.cropyear,a.season",nativeQuery = true)
	public List<MasterProjections> getAllSeason();
	
	
	@Query(value="select mcode as col1,mname as col2 from mandal_2011_cs where dcode=:dcode ",nativeQuery=true)
	public List<MasterProjections> getAllMandals(@Param("dcode") Integer dcode);
	
	@Query(value="select distinct(wbvcode) as col1,wbvname as col2 from wbvillage_mst "
			+ "where dcode=:dcode and mcode=:mcode order by wbvname",nativeQuery=true)
	public List<MasterProjections> getAllVillages(@Param("dcode") Integer dcode ,@Param("mcode") Integer mcode);
	
	@Query(value=" select cropgrpid as col1,grpname as col2 from cropgroups where active='A' ",nativeQuery=true)
	public List<MasterProjections> getAllCropGrp();
	
	@Query(value="select cropid  as col1,cropname as col2 from cropnames  "
			+ "where grpcode=:grpcode order by cropname ",nativeQuery=true)
	public List<MasterProjections> getAllCrpGrpid(@Param("grpcode") Integer grpcode);
	
	@Query(value="select cropid as col1,cropname as col2 from cropnames  where active='A' order by cropname",nativeQuery = true)
	public List<MasterProjections> getAllCrops();
}
