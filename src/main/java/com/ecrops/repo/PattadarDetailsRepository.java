package com.ecrops.repo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecrops.util.ECropUtility;

@Component
public class PattadarDetailsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<Object[]> getPattadarDetails(String wbdcode, String season, String cropyear, String recList) {

		String activeYear = cropyear;
		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}
		String tbname1 = "pattadarmast_wb_partition_" + season + wbdcode + cropyear;
		String crbookingNwb = "cr_booking_nwb";

		if (activeYear.equals(cropyear)) {
			tbname1 = "ecrop" + activeYear + "." + tbname1;
			crbookingNwb = "ecrop" + activeYear + "." + crbookingNwb;
		}
		String insertQry = null;

		insertQry = "select dcode,mcode,cr_vcode,cropyear,season,"
				+ " kh_no,cr_sno,tot_extent,occup_extent,cr_wsno,farmername,fathername,occupname,occupfname,rec_id,"
				+ "cast(cr_dist_code as integer), cast(cr_mand_code as integer),cultivable_land, uncultivable_land, regno, sjointoccupant,cr_farmeruid, mobileno "
				+ " from " + tbname1 + " where  rec_id=?";

		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, Integer.parseInt(recList));
//		sql.setParameter(2, Integer.parseInt(cropyear));
//		sql.setParameter(3, season);
		List<Object[]> executeUpdate = sql.getResultList();

		return executeUpdate;

	}

	@Transactional
	public int savePattadarDetails(String partkey, Integer dcode, Integer mcode, Integer vcode, Integer cropyear,
			String season, BigDecimal khathano, String surveyno, BigDecimal totalExtent, BigDecimal occupExtent,
			String updatedBy, Integer rbkcode, Integer empCode, BigInteger wsno, String rbkuserid, String datsrc,
			String recordId, String farmerName, String fatherName, String occupName, String occupFname, Integer wbdcode,
			Integer wdmcode, BigDecimal cultiland, BigDecimal uncultiland, Integer regno, Integer sjoint,
			String farmerUid, BigDecimal mobileNo) {
		
		String wbdcode1 =wbdcode.toString();
		if (wbdcode < 9) {
			wbdcode1 = "0" + wbdcode;
		}
		String tbname1 = "ecrop2023.rbk_surveyno_mapping_" + season + wbdcode1 + cropyear;
		
		String insertQry = "insert into "+tbname1+"(partkey,dcode,mcode,vcode,cr_year,"
				+ "cr_season,kh_no,cr_sno,tot_extent,occup_extent,updatedby,updateon,rbkcode,"
				+ "emp_code,cr_wsno,rbkuserid,data_src,rec_id,oc_name,oc_fname,occupname,occupfname,wbdcode, wbmcode, cultivable_land,uncultivable_land,regno, "
				+ "sjointoccupant,cr_farmeruid,mobile)  "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, partkey);
		sql.setParameter(2, dcode);
		sql.setParameter(3, mcode);
		sql.setParameter(4, vcode);
		sql.setParameter(5, cropyear);
		sql.setParameter(6, season);
		sql.setParameter(7, khathano);
		sql.setParameter(8, surveyno);
		sql.setParameter(9, totalExtent);
		sql.setParameter(10, occupExtent);
		sql.setParameter(11, updatedBy);
		sql.setParameter(12, rbkcode);
		sql.setParameter(13, empCode);
		sql.setParameter(14, wsno);
		sql.setParameter(15, rbkuserid);
		sql.setParameter(16, datsrc);
		sql.setParameter(17, Integer.parseInt(recordId));
		sql.setParameter(18, farmerName);
		sql.setParameter(19, fatherName);
		sql.setParameter(20, occupName);
		sql.setParameter(21, occupFname);
		sql.setParameter(22, wbdcode);
		sql.setParameter(23, wdmcode);
		sql.setParameter(24, cultiland);
		sql.setParameter(25, uncultiland);
		sql.setParameter(26, regno);
		sql.setParameter(27, sjoint);
		sql.setParameter(28, farmerUid);
	    sql.setParameter(29, mobileNo);System.out.println("before excuete--->"+insertQry);
		int executeUpdate = sql.executeUpdate();System.out.println("after excuete--->"+insertQry);
		return executeUpdate;

	}

	@Transactional
	public List<Object[]> crBookingNwb(String wbdcode, String season, String cropyear, String bkIdList) {
		// String activeYear = ECropUtility.getActiveYear().toString();
		String activeYear = cropyear;
		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}
		String crbookingNwb = "cr_booking_nwb";

		if (activeYear.equals(cropyear)) {
			crbookingNwb = "ecrop" + activeYear + "." + crbookingNwb;
		}
		String insertQry = null;

		insertQry = "select dcode,mcode,cr_vcode,cr_year,cr_season,kh_no,cr_sno, tot_extent ,"
				+ "occupant_extent, cr_wsno, oc_name,oc_fname,occupname,occupfname,rec_id, cast(cr_dist_code as integer), cast(cr_mand_code as integer), 0.0 as cultibleland, "
				+ "				0.0 as uncultibleland,0 as regno, sjointoccupant,cr_farmeruid, coalesce(mobileno, 0) as mobileno from "
				+ crbookingNwb + " where rec_id=?";
		System.out.println("bkIdList" + bkIdList);

		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, Integer.parseInt(bkIdList));
		List<Object[]> executeUpdate = sql.getResultList();
		System.out.println("executeUpdat" + executeUpdate.size());

		return executeUpdate;

	}

	@Transactional
	public int updateCrBookingNwd(Integer vcode, String bkdId) {
		String insertQry = null;

		insertQry = "update ecrop2023.cr_booking_nwb set vs_sel='Y' where cr_vcode=? and rec_id=?";

		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, vcode);
		sql.setParameter(2, Integer.parseInt(bkdId));
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;

	}

	@Transactional
	public int updatePattadarStatus(Integer recId, String wbdcode, String season, String cropyear) {
		String insertQry = null;

		String activeYear = cropyear;
		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}
		String tbname1 = "pattadarmast_wb_partition_" + season + wbdcode + cropyear;
		if (activeYear.equals(cropyear)) {
			tbname1 = "ecrop" + activeYear + "." + tbname1;
		}

		insertQry = "update " + tbname1 + " set status='D' where status='Y' and  rec_id=?";

		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, recId);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;

	}

}
