package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecrops.entity.MandalCsEntity;

public interface MandalCsRepository extends JpaRepository<MandalCsEntity, Integer> {
  MandalCsEntity findByMcode(int mcode);
}
