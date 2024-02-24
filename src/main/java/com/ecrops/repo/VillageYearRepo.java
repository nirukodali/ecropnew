package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecrops.entity.VillageEntity;

public interface VillageYearRepo extends JpaRepository<VillageEntity, Integer> {

	
	VillageEntity findByVcode(int vcode);
}
