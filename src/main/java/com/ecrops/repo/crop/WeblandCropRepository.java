package com.ecrops.repo.crop;

import com.ecrops.dto.crop.response.CropYear;
import com.ecrops.dto.crop.response.VillageData;
import com.ecrops.entity.crop.PattadarmastWbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeblandCropRepository extends JpaRepository<PattadarmastWbEntity, Integer> {


    @Query(value = "select distinct on (a.cropyear,a.season) concat(a.season,'@',cropyear) as seasonvalue,concat(b.seasonname,' ',cropyear) as cropyear \n" +
            "from activeseason a,season b  where a.season=b.season and a.active='A' and current_season='C' \n" +
            "order by a.cropyear,a.season", nativeQuery = true)
    List<CropYear> getCropYear();

    @Query(value = "select wbvcode,wbvname from wbvillage_mst \n" +
            "where mcode=:mcode and ecrop_dwn='Y' and wbvcode  \n" +
            "in(select cr_vcode from ecrop2023.verify_datadownload where cr_year=:cropyear and cr_season=:season and wb_cnt is null and efish='Y')",
            nativeQuery = true)
    List<VillageData> getVillages(@Param("mcode") int mCode, @Param("cropyear") int cropYear,
                                  @Param("season") String season);
    
   
}
