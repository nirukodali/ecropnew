package com.ecrops.repo;

	
import org.springframework.stereotype.Repository;
import com.ecrops.entity.VroRejectDropdownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Repository
public interface VroRejectDropdownRepo extends JpaRepository<VroRejectDropdownEntity, String> {
	
	@Query(value = "select reason, code from vro_rej_reasons where active = 'A'", nativeQuery = true)
	List<VroRejectDropdownEntity> findByCode();
	
}
