package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VillSecListMaoIntf;

public interface VillSecListMaoIntfRepo extends JpaRepository<VillSecListMaoIntf, Integer> {
	@Query(value=" select vcode,vname from Vill_sec_det WHERE "
			+ "dcode=:dcode and mcode=:mcode order by vname ",nativeQuery=true)
	List<VillSecListMaoIntf> getVillsecList(@Param("dcode") Integer dcode,@Param("mcode")Integer mcode);
	

}
