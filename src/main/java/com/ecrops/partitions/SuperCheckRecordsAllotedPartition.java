package com.ecrops.partitions;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.ecrops.entity.SuperCheckRecordsAlloted;

@Repository
@Transactional
public class SuperCheckRecordsAllotedPartition {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<SuperCheckRecordsAlloted> getSupchkRds( String wbdcode,String wbmcode,String userid,String cropyear) {
		
		
		String[] season = cropyear.split("@");
		System.out.println("season========="+season);
		String cseason = season[0];
		System.out.println("cseason========="+cseason);
		Integer Year = Integer.parseInt(season[1]);
		System.out.println("Year========="+Year);
	
		

		String part_key = "",part_key1="";
		if (Integer.parseInt(wbdcode) > 9) {
			part_key = cseason + wbdcode + Year;	
			part_key1 = cseason  + Year;	
			System.out.println("part_key==========>"+part_key);
			System.out.println("part_key1==========>"+part_key1);
		} else {
			part_key = cseason + "0" + wbdcode + Year; 
			part_key1 = cseason  + Year;
			System.out.println("part_key==========>"+part_key);
			System.out.println("part_key1==========>"+part_key1);
		}
	       
        String   tableName ="ecrop" + Year + "." +"cr_crop_det_new_v_" + part_key;
       String  tableName2 =  "ecrop" + Year + "." +"supercheck_exceptions_" + part_key1;
		System.out.println("tableName---------------->" + tableName);

		String Sql = "select a.mname as mname,a.vname ,cast(bookingid as character varying) as  bookingid, cast (kh_no as character varying) as kh_no, a.cr_no,oc_name as occupname,ekycfarmername,\r\n"
				+ " oc_fname as occupfname, cast(occupant_extent  as character varying) as occupant_extent,cropname, varietyname,"
				+ "CAST(cr_sow_date AS character varying) as cr_sow_date,  cast(cr_mix_unmix_ext as  character varying)\r\n"
				+ " as  cr_mix_unmix_ext,watersource as wsrcdesc, se.exception_type,cast(a.cr_dist_code as character varying)as cr_dist_code ,\r\n"
				+ " cast(a.cr_mand_code as character varying ) as cr_mand_code,oc_name,oc_fname, variety, cast(mobileno as  character varying) as mobileno,\r\n"
				+ " a.dname as dname,part_key, a.bookingid as bkid,cast(a.cr_dist_code as character varying) as WBDCODE , cast(a.cr_mand_code as character varying ) as WBMCODE,\r\n"
				+ " a.cr_vcode,a.dcode,a.mcode,cr_sno,a.cr_crop,  cast (cr_w_draw as character varying) as cr_w_draw from "+tableName+" a left join  \r\n"
				+ " "+tableName2+" se on a.exception_catg= se.exception_catg  where a.cr_dist_code=? and a.cr_mand_code=? \r\n"
				+ " and supercheck_userid =?  order by dname,mname,vname,cr_sno,kh_no ";

		Query insertQuery = (Query) entityManager.createNativeQuery(Sql);
		
		insertQuery.setParameter(1, Integer.parseInt(wbdcode));
		insertQuery.setParameter(2, Integer.parseInt(wbmcode));
		insertQuery.setParameter(3, userid);
		
	
		List<Object[]> detailsEntities1 = insertQuery.getResultList();
		//System.out.println("detailsEntities1=>"+detailsEntities1.size());
		//System.out.println("detailsEntities1=>"+detailsEntities1.toString());
		List<SuperCheckRecordsAlloted> detailsEntities = new ArrayList<SuperCheckRecordsAlloted>();
		

		for (Object[] row : detailsEntities1) {

			SuperCheckRecordsAlloted entity = new SuperCheckRecordsAlloted();
			
			entity.setMname((String) row[0]);
			entity.setVname((String) row[1]);
			entity.setBookingid((String) row[2]);
			entity.setKh_no((String) row[3]);
			entity.setCr_no((String) row[4]);
			entity.setOccupname((String) row[5]);
			entity.setEkycfarmername((String) row[6]);
			entity.setOccupfname((String) row[7]);
			entity.setOccupant_extent((String) row[8]);
			entity.setCropname((String) row[9]);
			entity.setVarietyname((String) row[10]);
			entity.setCr_sow_date((String) row[11]);
			entity.setCr_mix_unmix_ext((String) row[12]);
			entity.setWsrcdesc((String) row[13]);
			entity.setException_type((String) row[14]);
			detailsEntities.add(entity);
	
		}
		
		return detailsEntities;

	}
	

}
