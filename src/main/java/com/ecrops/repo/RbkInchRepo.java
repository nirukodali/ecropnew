package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.RbkInchEntity;
import com.ecrops.projection.InchargeRbkProjection;

public interface RbkInchRepo extends JpaRepository<RbkInchEntity, Integer> {

	@Query(value = "select aadhaar_id,mobile,emp_name as empname,vsdname,vsmname,vname,a.rbkcode,empcode,rbkuserid,"
			+ "inchargests from ecrop2023.emp_rbk_map_incharges a,vill_sec_det c,"
			+ "ecrop2023.cr_emp_profile b where a.dcode=c.dcode  and a.mcode=c.mcode and a.rbkcode=c.vcode\r\n"
			+ "and a.empcode=b.emp_code and a.dcode=:distcode and a.mcode=:mandalcode order by vname", nativeQuery = true)
	public List<InchargeRbkProjection> getDMcode(@Param("distcode") Integer distCode,
			@Param("mandalcode") Integer mandalcode);

//	ADA APP REJ
	@Query(value = "select  b.rbkcode,'XXXXXXXX'||right(aadhaar_id,4) as uid,vname,rbkuserid,emp_name as empname,a.emp_code as empcode,inchargests,mobile,"
			+ "email,designation from ecrop2023.cr_emp_profile a,ecrop2023.emp_rbk_map_incharges b,vill_sec_det c where a.emp_code=b.empcode "
			+ "and b.dcode=c.dcode and b.mcode=c.mcode and b.rbkcode=c.vcode and b.ada_appr is null and"
			+ " b.dcode=:district and b.mcode=:mandal order by vname", nativeQuery = true)
	public List<InchargeRbkProjection> getadaDMcode(@Param("district") Integer district,
			@Param("mandal") Integer mandal);

	// DAO APP REJ
	@Query(value = "select  b.rbkcode,'XXXXXXXX'||right(aadhaar_id,4) as uid,vname,rbkuserid,emp_name as empname,a.emp_code as empcode,inchargests,"
			+ "mobile,email,designation from ecrop2023.cr_emp_profile a,ecrop2023.emp_rbk_map_incharges b,vill_sec_det c where"
			+ " a.emp_code=b.empcode and b.dcode=c.dcode and b.mcode=c.mcode and b.rbkcode=c.vcode and b.ada_appr='A' and "
			+ "b.dao_appr is null and b.dcode=:district and b.mcode=:mandal order by vname", nativeQuery = true)
	public List<InchargeRbkProjection> getdaoDMcode(@Param("district") Integer distCode,
			@Param("mandal") Integer mandalcode);

	@Query(value="select  aadhaar_id,email,mobile,emp_code,emp_name,a.dcode,a.mcode,b.rbkcode from ecrop2023.cr_emp_profile a,"
			+ " ecrop2023.emp_rbk_map_incharges b where a.dcode=b.dcode and a.mcode=b.mcode and a.emp_code=b.empcode  and b.rbkcode=:rbkcode and emp_code=:empcode",nativeQuery = true)
	public List<InchargeRbkProjection>getInc(@Param("rbkcode")Integer rbkcode,@Param("empcode")Integer empcode);
	
	@Query(value="select * from ecrop2023.emp_rbk_map where rbkcode=:rbkcode and rbkuserid =:rbkuserid",nativeQuery = true)
	public List<InchargeRbkProjection>getInclogic(@Param("rbkcode")Integer rbkcode,@Param("rbkuserid")String rbkuserid);
	
	@Query(value="select * from ecrop2023.emp_rbk_map_logs where rbkcode =:rbkcode and rbkuserid =:rbkuserid",nativeQuery = true)
	public List<InchargeRbkProjection>getcheckrbklogs(@Param("rbkcode")Integer rbkcode,@Param("rbkuserid")String rbkuserid);
	
	@Query(value="select * from ecrop2023.emp_rbk_map_logs where  rbkcode=:rbkcode",nativeQuery = true)
	public List<InchargeRbkProjection>getpincharge(@Param("rbkcode") Integer rbkcode);
	
}
