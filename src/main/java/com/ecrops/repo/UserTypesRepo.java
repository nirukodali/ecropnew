package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.UserTypes;
import com.ecrops.projection.ActiveSeasonProjection;

public interface UserTypesRepo extends JpaRepository<UserTypes, Integer>{

	@Query(value = "select name from usertypes where usertype=:usertype", nativeQuery = true)
	public List<ActiveSeasonProjection> getUserType(@Param("usertype") Integer usertype);
}
