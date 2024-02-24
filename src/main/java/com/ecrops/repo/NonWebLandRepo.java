package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.NonWebLandData;

@Repository
public interface NonWebLandRepo extends JpaRepository<NonWebLandData, Integer> {

}
