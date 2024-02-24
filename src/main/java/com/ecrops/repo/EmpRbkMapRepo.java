package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.EmpRbkMapEntity;
import com.ecrops.projection.RbkDetailsProjection;

public interface EmpRbkMapRepo extends JpaRepository<EmpRbkMapEntity, String> {
	
	@Query(value="select rbkuserid from ecrop2023.emp_rbk_map where rbkcode=:rbkCode and empcode=:empCode",nativeQuery=true)
	public List<RbkDetailsProjection> getRbkUserId(@Param("rbkCode") Integer rbkCode, @Param("empCode") Integer empCode );
	

}
