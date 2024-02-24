package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.DeviceEntity;
import com.ecrops.projection.DeviceProjection;

public interface Devicesentryrepo extends JpaRepository<DeviceEntity, Integer> {
	@Query(value="select imei1 from devicedet where  vcode=:villagecode",nativeQuery = true)
	public List<DeviceProjection> getVcode(@Param("villagecode") Integer villagecode);
	
	@Query(value="select count(imei1) from devicedet where  vcode=:villagecode",nativeQuery = true)
	public int getByImei1(Integer villagecode); 
	

}
