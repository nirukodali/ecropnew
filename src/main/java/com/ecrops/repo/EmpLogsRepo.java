package com.ecrops.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Emplogsentity;

public interface EmpLogsRepo extends JpaRepository<Emplogsentity, Integer> {
	
	@Query(value="INSERT INTO ecrop2023.emp_rbk_map_logs(dcode, empcode, mcode, rbkcode, rbkuserid, vcode, wbdcode, wbmcode) VALUES (:dcode, :emp_code,  :mcode, :rbkcode2, :rbkuserid, :vcode,:wbdcode,:wbmcode)",nativeQuery=true)
	public Optional<Emplogsentity> saveEmplogs(@Param("dcode") Integer dcode,  @Param("emp_code") Integer emp_code, @Param("mcode") Integer mcode, @Param("rbkcode2") Integer rbkcode2, @Param("rbkuserid") String rbkuserid, @Param("vcode") Integer vcode, @Param("wbdcode") Integer wbdcode, @Param("wbmcode") Integer wbmcode);

}
