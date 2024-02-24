package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecrops.entity.RedownloadReasons;

public interface Reasons extends JpaRepository<RedownloadReasons, Integer> {
	
	@Query(value="select * from redownload_reasons",nativeQuery=true)
	List<RedownloadReasons> getreasons();
	

}
