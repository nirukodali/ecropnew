package com.ecrops.partitions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.SuperCheckRecordsAlloted;
import com.ecrops.entity.SuperChkReport;

@Repository
@Transactional
public class SuperChkReportPartition {

	@PersistenceContext
	private EntityManager entityManager;

	public List<SuperChkReport> getSupchkRep(String wbdcode, String wbmcode, String userid, String cropyear,
			String activeyear) {

		String[] season = cropyear.split("@");
		System.out.println("season=========" + season);
		String cseason = season[0];
		System.out.println("cseason=========" + cseason);
		Integer Year = Integer.parseInt(season[1]);
		System.out.println("Year=========" + Year);
		String tableName = "";

		String part_key = "", part_key1 = "";
		
		if (Integer.parseInt(wbdcode) > 9) {
			part_key = cseason + wbdcode + Year;

			
		} else {
			part_key = cseason + "0" + wbdcode + Year;

			System.out.println("part_key==========>" + part_key);
		
		}
		
		if(String.valueOf(Year).equalsIgnoreCase(activeyear)) {
			tableName = "ecrop" + activeyear + "." + "cr_details_" + part_key;
		}else {
			tableName = "cr_details_" + part_key;
		}
		
		
		System.out.println("tableName---------------->" + tableName);

		String Sql = " select wbdname,wbmname,wbvname, cast(bookingid as character varying) as bookingid, occupname as occup_name,occupfname as occup_fname,\r\n"
				+ " cropname,varietyname,cast(cr_sow_date as character varying)as cr_sow_dt,cast(kh_no as character varying) as kh_no,cr_sno,\r\n"
				+ "reason, superchk_remarks as oremarks,cr_no, case when superchk_remarks='A'\r\n"
				+ " then 'Entry Found Correct' when  superchk_remarks='R' then 'Entry Found Incorrect'  end as remarks  \r\n"
				+ " from " + tableName
				+ " a,wbvillage_mst b ,cropnames c ,  cr_variety_master v,authority_verify_reasons ar \r\n"
				+ "  where a.cr_dist_code=b.wbdcode and a.cr_mand_code=b.wbmcode and a.cr_vcode=b.wbvcode and a.cr_crop=c.cropid and a.variety=v.varietycode \r\n"
				+ "  and superchk_remarks='R' and a.suprejreason =cast(ar.code as text )and cr_dist_code=? and cr_mand_code=?\r\n"
				+ "  and a.supercheck_userid=?  order by wbmname,wbvname ";

		Query insertQuery = (Query) entityManager.createNativeQuery(Sql);

		insertQuery.setParameter(1, Integer.parseInt(wbdcode));
		insertQuery.setParameter(2, Integer.parseInt(wbmcode));
		insertQuery.setParameter(3, userid);

		List<Object[]> detailsEntities1 = insertQuery.getResultList();
		// System.out.println("detailsEntities1=>"+detailsEntities1.size());
		// System.out.println("detailsEntities1=>"+detailsEntities1.toString());
		List<SuperChkReport> detailsEntities = new ArrayList<SuperChkReport>();

		for (Object[] row : detailsEntities1) {

			SuperChkReport entity = new SuperChkReport();

			entity.setWbdname((String) row[0]);
			entity.setWbmname((String) row[1]);
			entity.setWbvname((String) row[2]);
			entity.setBookingid((String) row[3]);
			entity.setOccup_name((String) row[4]);
			entity.setOccup_fname((String) row[5]);
			entity.setCropname((String) row[6]);
			entity.setVarietyname((String) row[7]);
			entity.setCr_sow_dt((String) row[8]);
			entity.setKh_no((String) row[9]);
			entity.setCr_sno((String) row[10]);
			entity.setReason((String) row[11]);

			detailsEntities.add(entity);

		}

		return detailsEntities;

	}

}
