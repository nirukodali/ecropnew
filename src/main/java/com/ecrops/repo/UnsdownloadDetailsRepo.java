package com.ecrops.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.UnsDownloadDetails;
@Repository
public interface UnsdownloadDetailsRepo extends JpaRepository<UnsDownloadDetails, String> {
	//String unsTab="unsdownloaddetails";

@Query(value="SELECT no_of_records as existingcnt from  ecrop2023.unsdownloaddetails where vcode=:vcode and cropyear=:cropyear and season=:season",nativeQuery=true)
public Integer getNoOfRecords(@Param("vcode") Integer vcode,@Param("cropyear") Integer cropyear,@Param("season") String season);
}
