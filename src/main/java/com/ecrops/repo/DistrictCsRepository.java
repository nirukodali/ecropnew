package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.DistrictCsEntity;

@Repository
public interface DistrictCsRepository extends JpaRepository<DistrictCsEntity, Integer>{
   DistrictCsEntity findByDcode(int dcode);
}
