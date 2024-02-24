package com.ecrops.repo;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;

	import com.ecrops.entity.DistrictEntity;
	import com.ecrops.projection.VillageName;
	
public interface DataReDownloadRepo extends JpaRepository<DistrictEntity, Integer> {

	
		@Query(value="select dname from district_2011_cs where dcode=:distCode",nativeQuery=true)
		public List<VillageName> getDistName(@Param("distCode") Integer distCode);
		
		@Query(value="select distinct on (a.cropyear,a.season) concat(a.season,'@',cropyear) as seasonvalue,concat(b.seasonname,' ',cropyear) as cropyear \r\n"
				+ "  from activeseason a,season b  where a.season=b.season and a.active='A' and current_season='C' order by a.cropyear,a.season",nativeQuery = true)
		
		
		public Activeseason getActiveseason();
		
		interface Activeseason{
			String getSeasonvalue();
			String getCropyear();
		}
		@Query(value="select code, cast(concat(code,'. ',reason) as character varying)as concat,group_reason from lock_unlock_reasons where group_reason='U' and active='A' order by code",nativeQuery=true)
		public List<Lock_unlock_reasons> unlockreasons();
		interface Lock_unlock_reasons {
			
			Integer getCode();
			String getConcat();
			String getGroup_reason();
		}

		@Query(value="select wbdcode from district_2011_cs where dcode::text=?",nativeQuery = true)
		 public List<Wbcode>getWbdcode();
		interface Wbcode{
			
			String getWbdcode();
		}
		
		
		
		
		
		
	}

	
	

