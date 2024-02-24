package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.PattMst_NonWebland;


public interface Patt_Mst_NonWebLandRepo extends JpaRepository<PattMst_NonWebland, Integer> {
@Query(value="SELECT cr_farmeruid FROM ecrop2023.pattmast_nonwebland where cr_farmeruid=:aadharNo",nativeQuery=true)
	String findAadhar(@Param("aadharNo")String aadharNo);

@Modifying
@Query(value="UPDATE ecrop2023.pattmast_nonwebland SET part_key=:part_key WHERE cr_farmeruid = :oldAadhar", nativeQuery=true)
void update(@Param("part_key") String part_key, @Param("oldAadhar") String oldAadhar);

}
