package com.ecrops.repo;

import java.util.List;
import com.ecrops.projection.EmployeeName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.RbkEntity;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;

public interface InchargeRbkRepo extends JpaRepository<RbkEntity, String> {
	
	@Query(value = "Select incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getInchargeStatus(@Param("rbkCode") Integer rbkCode);
	

	@Query(value = "Select dcode, mcode, vcode, rbkcode, empcode, ts, rbkuserid, ipaddress, wbdcode, wbmcode, incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getRbkDetailsToSave(@Param("rbkCode") Integer rbkCode);
	
	@Query(value = "update  ecrop2023.emp_rbk_map set incharge_sts=:incStatus, empcode=:empCode where rbkcode=:rbkCode", nativeQuery = true)
	public List<RbkDetailsProjection> updateInchargeStatus(@Param("incStatus") String incStatus, @Param("empCode") Integer empCode,@Param("rbkCode") Integer rbkCode);
	
	@Query(value="select incharge_sts,'RBK_'||b.vcode as rbkuserid,b.vname,emp_name,COALESCE(emp_code,0) AS emp_code,'xxxxxxxx'||right(aadhaar_id,4) as aadhaar_id, email,mobile \r\n"
			+ "  from ecrop2023.cr_emp_profile a,vill_sec_det b,ecrop2023.emp_rbk_map e where  cast(a.dcode as int)=b.dcode and cast(a.mcode as int)=b.mcode  and a.emp_code=e.empcode and  \r\n"
			+ " a.dcode=:distcode and a.mcode=:mandalcode and emp_code is not null  and a.dcode=e.dcode and a.mcode=e.mcode and b.vcode=e.rbkcode",nativeQuery = true)
	public List<RbkDetailsProjection> getRegDMcode(@Param("distcode") Integer distCode,@Param("mandalcode") Integer mandalcode);
	
//	rbkmapping
	@Query(value = "Select dcode,mcode,rbkcode,empcode,rbkuserid,incharge_sts from ecrop2023.emp_rbk_map where mcode=:mandal and empcode=:empcode ", nativeQuery = true)
	public List<InchargeRbkProjection> getmandempcode(@Param("mandal") Integer mandal,@Param("empcode") Integer empcode);
	
	@Query(value = "Select * from ecrop2023.emp_rbk_map where mcode=:mcode and empcode=:empcode and rbkcode=:rbkcode", nativeQuery = true)
	public List<InchargeRbkProjection> getEmprbkmcode(@Param("mcode") Integer mcode,@Param("empcode") Integer empcode, @Param("rbkcode") Integer rbkcode);


	@Query(value = "Select * from ecrop2023.emp_rbk_map where mcode=:mcode and rbkcode=:rbkcode ", nativeQuery = true)
	public List<InchargeRbkProjection> rbkstatus(@Param("mcode") Integer mcode, @Param("rbkcode") Integer rbkcode);

}
