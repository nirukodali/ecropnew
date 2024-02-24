package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecrops.entity.NonWebReasonsEntity;

public interface NonWebReasonsRepo extends JpaRepository<NonWebReasonsEntity, Integer> {
	
	@Query(value="select code,reason from nonweb_reasons where active='A' order by code",nativeQuery=true)
	
	List<NonWebReasonsEntity> findReason();

}
