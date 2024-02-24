package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.UserRegEntity;

@Repository

public interface UserRegRepo extends JpaRepository<UserRegEntity, String> {

	@Query(value = "SELECT userid,type_user,blockortehsil,district,name,encpassword,village  from user_registration  WHERE Userid=:userId and webloginstatus='A'", nativeQuery = true)
	List<UserRegEntity> getUserDetails(@Param("userId") String userId);

	@Query(value = "select userid,encpassword, type_user from user_registration where userid=:userId", nativeQuery = true)
	public List<Object[]> find(@Param("userId") String userId);

	@Query(value = "select type_user from user_registration where userid = :userid", nativeQuery = true)
	public String getUserType(@Param("userid") String userid);

	@Query(value = "select ur.name, aadhaar_id, ur.type_user, mobile_phone, userid, encpassword, district, blockortehsil, village, COALESCE(wbmcode, 0) wbmcode, COALESCE(wbdcode, 0) wbdcode, COALESCE(wbvcode, 0) wbvcode, ut.name typename, ut.usertype from user_registration ur, usertypes ut where ur.type_user = ut.type_user and ur.userid = :userId ", nativeQuery = true)
	public UserRegEntity getSessionValues(@Param("userId") String userId);

}