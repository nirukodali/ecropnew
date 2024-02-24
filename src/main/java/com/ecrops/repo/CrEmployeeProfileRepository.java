package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.CrEmpProfileEntity;
import com.ecrops.projection.EmployeeName;

public interface CrEmployeeProfileRepository extends JpaRepository<CrEmpProfileEntity, String> {
	
	@Query(value="select emp_code,emp_name from ecrop2023.cr_emp_profile where mcode=:mandal",nativeQuery=true)
	public List<EmployeeName> findEmpName(@Param("mandal") Integer mandal);
	
    @Query(value="select a.emp_code, emp_name from ecrop2023.cr_emp_profile a, ecrop2023.emp_rbk_map b where a.dcode=b.dcode and a.mcode=b.mcode and a.emp_code=b.empcode and b.rbkcode=:rbkcode and a.cr_dist_code=:wbdcode2 and a.cr_mand_code=:wbmcode2",nativeQuery=true)
	public List<EmployeeName> getEmpByRevenue(@Param("rbkcode") Integer rbkcode, @Param("wbdcode2") Integer wbdcode2, @Param("wbmcode2") Integer wbmcode2);

}