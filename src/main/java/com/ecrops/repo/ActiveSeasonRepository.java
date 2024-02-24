package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.projection.ActiveSeasonProjection;

@Repository
public interface ActiveSeasonRepository extends JpaRepository<ActiveSeason, String> {

	@Query(value = "select distinct on (a.cropyear, a.season)concat(a.season,'@',cropyear) as seasonvalue, a.*, b.* from activeseason a, season b where a.season=b.season and a.active='A' and a.current_season='C' order by a.cropyear, a.season", nativeQuery = true)
	List<ActiveSeason> findByActiveAndCurrentSeason();


	
	@Query(value = "select distinct on (a.cropyear, a.season) concat(a.season,'@',cropyear) as seasonvalue, concat(b.seasonname,'',cropyear) as cropyear from activeseason a, season b where a.season=b.season and a.active='A' and a.current_season='C' order by a.cropyear, a.season", nativeQuery = true)
	public List<ActiveSeasonProjection> getActiveSeason();
}
