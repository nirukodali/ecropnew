package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecrops.entity.VillageCsEntity;

public interface VillagesCsRepository extends JpaRepository<VillageCsEntity, Integer> {

	
	VillageCsEntity findByVcode(int vcode);
}
