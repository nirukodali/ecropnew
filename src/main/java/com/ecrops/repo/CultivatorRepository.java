package com.ecrops.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.Cultivator;
import com.ecrops.projection.PattadarProjection;

@Repository
public interface CultivatorRepository extends JpaRepository<Cultivator, Integer> {

	@Query(value="select a.*,\n" + 
			"a.anubhavadar_extent-bookedext as available_extent from  ecrop2023.cr_booking_partition_r202023  a,\n" + 
			"(\n" + 
			"select cr_vcode,cr_sno,kh_no,sum(occupant_extent) as bookedext\n" + 
			"from ecrop2023.cr_booking_partition_r202023 where\n" + 
			"cr_vcode=:crVcode and kh_no=:fromKhno and cultivator_type is not null and cr_year=:cryear and cr_season=:crseason\n" + 
			"group by cr_vcode,cr_sno,kh_no ) b where a.cr_vcode=b.cr_vcode and \n" + 
			"a.cr_sno=b.cr_sno and a.kh_no=b.kh_no and a.cultivator_type is not null",nativeQuery = true)
	List<Cultivator> getCultivatorDataByKathaNo(@Param("fromKhno") Integer fromKhno,
			@Param("crVcode") Integer crVcode,@Param("cryear") Integer crYear, @Param("crseason") String crSeason);
	
	
	
	@Query(value="select * from (select a.*,\n" + 
			"coalesce((a.anubhavadar_extent-bookedext), a.anubhavadar_extent) as available_extent from  ecrop2023.cr_booking_partition_r202023  a left join " + 
			"(\n" + 
			"select cr_vcode,cr_sno,kh_no,coalesce(sum(occupant_extent),0) as bookedext\n" + 
			"from ecrop2023.cr_booking_partition_r202023 where\n" + 
			"cr_vcode=:crVcode and kh_no=:fromKhno and cultivator_type is not null and cr_year=:cryear and cr_season=:crseason\n" + 
			"group by cr_vcode,cr_sno,kh_no ) b on a.cr_vcode=b.cr_vcode and \n" + 
			"a.cr_sno=b.cr_sno and a.kh_no=b.kh_no) x where cr_vcode=:crVcode and kh_no=:fromKhno and data_src='W' ",nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("fromKhno") Integer fromKhno,
			@Param("crVcode") Integer crVcode,@Param("cryear") Integer crYear, @Param("crseason") String crSeason);
	
	
	@Query(value = "select * from (select a.*,  \n" + 
			"coalesce((a.anubhavadar_extent-bookedext), a.anubhavadar_extent) as available_extent from  ecrop2023.cr_booking_partition_r202023  a left join " + 
			"		( \n" + 
			"		select cr_vcode,cr_sno,kh_no,coalesce(sum(occupant_extent),0) as bookedext \n" + 
			"			from ecrop2023.cr_booking_partition_r202023 where \n" + 
			"			cr_vcode=:crVcode and kh_no=:fromKhno and cultivator_type is not null and cr_year=:cryear and cr_season=:crseason \n" + 
			"		group by cr_vcode,cr_sno,kh_no ) b on a.cr_vcode=b.cr_vcode and \n" + 
			"			a.cr_sno=b.cr_sno and a.kh_no=b.kh_no) x where cr_vcode=:crVcode and kh_no=:fromKhno and data_src='C' ", nativeQuery = true)
	List<Cultivator> getCcrcDetailsByKathaNo(@Param("fromKhno") Integer fromKhno,
			@Param("crVcode") Integer crVcode,@Param("cryear") Integer crYear, @Param("crseason") String crSeason);
	
	

	@Query(value = "SELECT SUM(tot_extent) tot_extent FROM ecrop2023.CR_BOOKING WHERE kh_no = :khNo and cr_farmeruid = :cr_farmeruid AND owner_tenant = :owner_tenant GROUP BY kh_no, cr_farmeruid", nativeQuery = true)
	List<Cultivator> getCultivatorDetailsByKathaNo(@Param("khNo") Integer khNo,
			@Param("owner_tenant") String owner_tenant, @Param("cr_farmeruid") String cr_farmeruid);

	@Query(value = "SELECT sum(occupant_extent) FROM ecrop2023.cr_booking WHERE part_key = :part_key and kh_no = :kh_no and cr_vcode= :cr_vcode and cultivator_type IS NOT NULL and cr_sno = :cr_sno", nativeQuery = true)
	public Float getTotalOccupantExtent(@Param("part_key") String part_key, @Param("kh_no") Integer kh_no,
			@Param("cr_vcode") Integer cr_vcode, @Param("cr_sno") String cr_sno);

	@Query(value = "SELECT anubhavadar_extent FROM ecrop2023.cr_booking WHERE part_key = :part_key and kh_no = :kh_no and cr_vcode= :cr_vcode  and owner_tenant in( 'O','T')  and cr_sno = :cr_sno ", nativeQuery = true)
	public Float getAnubhavadarExtent(@Param("part_key") String part_key, @Param("kh_no") Integer kh_no,
			@Param("cr_vcode") Integer cr_vcode, @Param("cr_sno") String cr_sno);
	
	
	@Query(value = "select  cr_vcode,cr_sno,kh_no,occupname,occupfname,sum(occup_extent) as occup_extent from \n" + 
			"ecrop2023.pattadarmast_wb \n" + 
			" where cr_vcode=:cr_vcode and   kh_no=:kh_no group by cr_vcode,cr_sno,kh_no,occupname,occupfname  ", nativeQuery = true)
	public List<PattadarProjection> getOriginalExtent(@Param("kh_no") BigDecimal kh_no,@Param("cr_vcode") Integer cr_vcode);
	
	

	
}
