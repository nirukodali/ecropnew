package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {

	AppUser findByUserid(String userid);

}
