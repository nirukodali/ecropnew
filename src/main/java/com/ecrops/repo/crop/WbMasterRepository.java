package com.ecrops.repo.crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.WbMaster;

@Repository
public interface WbMasterRepository extends JpaRepository<WbMaster, Integer> {

    @Query("SELECT wbv.wbvname FROM WbMaster wbv WHERE wbv.wbvcode = :wbvcode")
    String findVillageNameByWbvcode(@Param("wbvcode") Integer wbvcode);
}