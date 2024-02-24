package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Village;
import com.ecrops.projection.VillageName;

public interface VillRepo extends JpaRepository<Village, Integer>
{
	@Query(value="select vcode,vname,userid from vill_sec_det a,user_registration b where a.vcode =cast(b.village as int) and type_user='25' and a.vcode =cast(b.village as int)  and status='A' and  regular_sts in ('R','I') and district=:district and blockortehsil=:mandal  order by vname", nativeQuery=true)
	public List<VillageName> findVillName(@Param("district") String district,@Param("mandal") String mandal);

	@Query(value="select vname from vill_sec_det where vcode=:villCode",nativeQuery=true)
	public List<VillageName> getVillName(@Param("villCode") Integer villCode);

}
