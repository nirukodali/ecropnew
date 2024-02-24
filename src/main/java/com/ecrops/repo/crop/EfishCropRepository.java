package com.ecrops.repo.crop;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.dto.crop.response.CropYearCcrcEfish;
import com.ecrops.dto.crop.response.VillageDataCcrc;
import com.ecrops.entity.WbVillageMastEntity;

public interface EfishCropRepository extends JpaRepository<WbVillageMastEntity, Integer> {

    @Query(value = "select distinct on (a.cropyear, a.season) concat(a.season, '@', cropyear) as seasonvalue, " +
            "concat(b.seasonname, ' ', cropyear) as cropyear \n" +
            "from activeseason a, season b  where a.season = b.season and a.active = 'A' and current_season = 'C' \n" +
            "order by a.cropyear, a.season", nativeQuery = true)
    List<CropYearCcrcEfish> getCropYear();
 
    
    @Query(value = "select wbvcode, wbvname from wbvillage_mst " +
            "where ecrop_dwn = 'Y' and  mcode = :mcode and wbvcode not in " +
            "(select cr_vcode from ecrop2023.verify_datadownload where cr_year = :cr_year and cr_season = :cr_season)", nativeQuery = true)
    List<VillageDataCcrc> getVillages(@Param("mcode") int mCode, @Param("cr_year") int cr_year, @Param("cr_season") String cr_season);

}
