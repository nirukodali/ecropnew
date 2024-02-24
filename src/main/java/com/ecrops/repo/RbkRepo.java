package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Employeename;
import com.ecrops.projection.RbkDetailsProjection;

public interface RbkRepo extends JpaRepository<Employeename, String> {

	@Query(value = "select emp_code, emp_name, mobile, email, aadhaar_id from ecrop2023.cr_emp_profile a where a.dcode=:district and a.mcode=:mandal  and a.emp_code=:empCode", nativeQuery = true)
	public List<RbkDetailsProjection> getEmployeeDetails(@Param("district") Integer district, @Param("mandal") Integer mandal,
			@Param("empCode") Integer empCode);
}
