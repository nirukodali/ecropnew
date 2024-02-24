package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Districts;
import com.ecrops.projection.VillageName;

public interface DistrictRepo  extends JpaRepository<Districts, Integer>{
	
	@Query(value="select wbdcode ,wbmcode,type_user from user_registration   where  userid=:userId",nativeQuery=true)
	String getDistByDcodeAndUserId(String userId);
	
	@Query(value="select dname from district_2011_cs where dcode=:distCode",nativeQuery=true)
	public List<VillageName> getDistName(@Param("distCode") Integer distCode);

}


