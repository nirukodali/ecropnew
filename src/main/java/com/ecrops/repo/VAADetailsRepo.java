package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.VAADetails;

public interface VAADetailsRepo extends JpaRepository<VAADetails, String> {
	@Query(value="SELECT userid,districtname,mandalname,villagename,name,mobile_phone,"
			+ "emailid,to_char(regdate,'dd-MM-yyyy') as regdate,status\r\n"
			+ "from user_registration_vs_v  where status='A' and cast(mcode as text)=:mcode "
			+ "and type_user='30' order by mandalname,villagename ",nativeQuery=true)
	List<VAADetails> getVaaDet(@Param("mcode") String mcode);

}
