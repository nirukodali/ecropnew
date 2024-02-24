package com.ecrops.repo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ecrops.dto.PattadharPojo;

import java.util.List;

@Repository
public class DatabaseRepo {

	@PersistenceContext
	EntityManager entityManager;

	public List<PattadharPojo> methods(String wbdcode, String cropyear, String season, String vcode) {
		List<PattadharPojo> l = new ArrayList<>();
		String qry = null;
		String crbooknwb = "cr_booking_nwb";
		String efishTab = "cr_details_efish";
		String partitionName = "pattadarmast_wb_partition_";
		String rbksrnoMapTab = "rbk_surveyno_mapping_";
		String partKey = "";
		String activeYear = "2023";

		if (Integer.parseInt(wbdcode) <= 9) {
			partitionName = partitionName + season + "0" + wbdcode + cropyear;
			rbksrnoMapTab = rbksrnoMapTab + season + "0" + wbdcode + cropyear;
			partKey = season + "0" + wbdcode + cropyear;

		} else {
			partitionName = partitionName + season + wbdcode + cropyear;
			rbksrnoMapTab = rbksrnoMapTab + season + wbdcode + cropyear;
			partKey = season + wbdcode + cropyear;
		}

		if (activeYear.equals(cropyear)) {
			partitionName = "ecrop" + cropyear + "." + partitionName;
			rbksrnoMapTab = "ecrop" + cropyear + "." + rbksrnoMapTab;
			efishTab = "ecrop" + cropyear + "." + efishTab;
			crbooknwb = "ecrop" + cropyear + "." + crbooknwb;
		} else {
			partitionName = partitionName;
		}
		qry = "(select rec_id as bookingid,'W',cr_wsno,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,"
				+ "farmername,fathername,mobileno,kh_no,cr_sno,tot_extent, occupname,occupfname,"
				+ "occup_extent  from " + partitionName + " where status='Y' and cr_vcode=" + vcode + " "
				+ "and  kh_no not in (select code from obj_unobj where trim(crb_remarks) in ('No'))  "
				+ " and (cr_sno,kh_no,cr_vcode) " + "not in (select cr_sno,kh_no,vcode from   " + rbksrnoMapTab
				+ " where vcode=" + vcode + " ) " + " order by cr_wsno,kh_no) " + "UNION "
				+ "select rec_id as bookingid,data_src, cr_wsno,cr_dist_code,cr_mand_code,cr_vcode, "
				+ "cr_farmeruid,oc_name,oc_fname,mobileno,kh_no,cr_sno,tot_extent, occupname,occupfname,"
				+ "occupant_extent from " + crbooknwb + " where cr_vcode=" + vcode + " and vs_sel is null"
				+ " order by cr_wsno,kh_no limit 5";
		// List<PattadharPojo> pojo = method(qry);

		return l;
	}

	public List<PattadharPojo> pattadharDetails(String var, String partitionName, String vcode, String efishTab,
			String rbksrnoMapTab, String crbooknwb) {

		var = "(select rec_id as bookingid,'W',cr_wsno,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,"
				+ "farmername,fathername,mobileno,kh_no,cr_sno,tot_extent, occupname,occupfname,"
				+ "occup_extent  from " + partitionName + " where status='Y' and cr_wsno is not null and cr_vcode="
				+ vcode + " " + " and  kh_no not in (select code from obj_unobj where trim(crb_remarks) in ('No')) "
				+ "and cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in "
				+ "(select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from " + efishTab + "  "
				+ "where cr_vcode=" + vcode + ") and (cr_sno,kh_no,cr_vcode,'W') not in "
				+ "(select cr_sno,kh_no,vcode,data_src from   " + rbksrnoMapTab + " where vcode=" + vcode + " ) "
				+ " order by cr_wsno,kh_no) " + "UNION "
				+ "select rec_id as bookingid,data_src, cr_wsno,cr_dist_code,cr_mand_code,cr_vcode, "
				+ "cr_farmeruid,oc_name,oc_fname,mobileno,kh_no,cr_sno,tot_extent, occupname,occupfname,"
				+ "occupant_extent from " + crbooknwb + " where cr_vcode=" + vcode
				+ " and vs_sel is null and cr_wsno is not null" + " order by cr_wsno,kh_no limit 500";

		List<PattadharPojo> pojo = new ArrayList<>();

		Query query = entityManager.createNativeQuery(var);
		List<Object> objects = query.getResultList();

		if (objects != null && objects.size() > 0) {

			for (Object patta : objects) {

				Object[] row = (Object[]) patta;

				PattadharPojo pojos = new PattadharPojo();
				pojos.setDatasrc(row[1].toString());

				pojos.setSurveyno(row[11].toString());

				if (row[2] != null) {
					pojos.setWholesurveyno(row[2].toString());
				}

				pojos.setKhathano(row[10].toString());
				pojos.setTotalextent(row[12].toString());

				pojos.setBkid(Integer.parseInt(row[0].toString()));
				pojos.setOccupextent(row[15].toString());

				pojo.add(pojos);
			}
		}

		return pojo;

	}

	public String getWbdCode(String dcode) {
		String query = "select wbdcode from ecrop2023.district_2011_cs where dcode=" + dcode + "";
		Query result = entityManager.createNativeQuery(query);
		Object object = result.getSingleResult();
		// System.out.println(object.toString());
		return object.toString();
	}

	public int executeInsertQuery(String partKey, String dcode, String mcode, String crVcode, int crYear,
			String crSeason, String khNo, String crSno, double totExtent, double occupExtent, String updatedBy,
			String rbkCode, String empCode, String crWsno, String rbkUserId, String dataSource, long recId,
			String tbname1) {
		String query = "INSERT INTO ecrop2023.rbk_surveyno_mapping(partkey,dcode,mcode,vcode,cr_year,cr_season,kh_no,cr_sno,"
				+ "tot_extent,occup_extent,updatedby,updateon,rbkcode,emp_code,cr_wsno,rbkuserid,data_src,rec_id) "
				+ "SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?, ? " + "FROM " + tbname1
				+ " WHERE rec_id = ?)";

		entityManager.createNativeQuery(query).setParameter(1, partKey).setParameter(2, dcode).setParameter(3, mcode)
				.setParameter(4, crVcode).setParameter(5, crYear).setParameter(6, crSeason).setParameter(7, khNo)
				.setParameter(8, crSno).setParameter(9, totExtent).setParameter(10, occupExtent)
				.setParameter(11, updatedBy).setParameter(12, Integer.parseInt(rbkCode))
				.setParameter(13, Integer.parseInt(empCode)).setParameter(14, crWsno).setParameter(15, rbkUserId)
				.setParameter(16, dataSource).setParameter(17, recId).executeUpdate();
		return 10;
	}

	public String getRbkUserid(String qry1) {
		Query query = entityManager.createNativeQuery(qry1);
		Object obj = query.getSingleResult();
		return obj.toString();
	}

	public List<Object> getPattadharResult(String query) {

		Query result = entityManager.createNativeQuery(query);
		return result.getResultList();
	}

	@Transactional
	public int insertCrbkFromPattadar(String dataSrcs[], String recIds[], String activeYear, String pcropyear,
			String pseason, String pwbdcode, String pwbmcode, String[] vcodes, String[] regNos, String[] sjoints,
			String khno[], String ipaddress, String userid, String[] WholesrArr, String[] surveyNo, String[] totExtents,
			String[] occExtents) throws Exception {
		System.out.println(Arrays.toString(recIds));

		Query q21 = null, ps4 = null, ps5 = null, ps8 = null;
		Object rs8 = null;
		int status = 0, downdetIns = 0;
		try {
			String cropyear = pcropyear;
			String season = pseason, villageCode = "";
			System.out.println("season" + season);
			int khNo = 0;

			Double mixuNmix = 0.0;
			boolean newVcode = false;
			int crbIns = 0, existingCnt = 0, crbUpd = 0;
			String survNo = "", cropName = "", varietyName = "", peri_status = "", occupName = "", occupFname = "",
					peri_occup_Name = "", peri_occup_Fname = "";
			String geoRefSts = "N";

			String wbdist = "", wbmcode = "";
			int crwexists = 0;

			String empCode = "", emprbkmap = "";
			emprbkmap = "emp_rbk_map";

			if (activeYear.equals(cropyear) && season.equals("R")) {
				emprbkmap = "ecrop" + activeYear + "." + emprbkmap;
			}

			String empqry = "select empcode from " + emprbkmap + " where rbkuserid='" + userid + "' ";
			Query query = entityManager.createNativeQuery(empqry);

			if (query.getSingleResult() != null) {
				empCode = query.getSingleResult().toString();
			}

			wbdist = pwbdcode;
			wbmcode = pwbmcode;
			if (wbdist.length() == 1) {
				wbdist = "0" + wbdist;
			}

			String pattadar_tab = "pattadarmast_wb_partition_" + season + wbdist + cropyear;
			String crbooking_tab = "cr_booking_partition_" + season + wbdist + cropyear;
			String downsuryTab = "downloaded_surveyno";
			String efish_tab = "cr_details_efish";
			String crbnwb = "cr_booking_nwb";
			String rbksrnoMappTab = "rbk_surveyno_mapping";

			if (activeYear.equals(cropyear) && season.equals("R")) {
				pattadar_tab = "ecrop" + activeYear + ".pattadarmast_wb_partition_" + season + wbdist + cropyear;
				crbooking_tab = "ecrop" + activeYear + ".cr_booking_partition_" + season + wbdist + cropyear;
				downsuryTab = "ecrop" + activeYear + ".downloaded_surveyno";
				efish_tab = "ecrop" + activeYear + "." + efish_tab;
				crbnwb = "ecrop" + activeYear + "." + crbnwb;
				rbksrnoMappTab = "ecrop" + activeYear + "." + rbksrnoMappTab + "_" + season + wbdist + cropyear;
			}
			
			String qry = " INSERT INTO " + crbooking_tab
					+ "(cr_dist_code, cr_mand_code, cr_vcode, cr_year, cr_season,  cr_farmeruid, oc_name, oc_fname,  mobileno, kh_no, cr_sno, tot_extent ,"
					+ " occupname,occupfname , occupant_extent,sjointoccupant,cr_tr_i_ext,cr_tr_d_ext,anubhavadar_name,anubhavadar_extent,owner_tenant,data_src, "
					+ " dcode,mcode,part_key,regno,digitally_signed,vs_sel,cr_wsno,rec_id) "
					+ " select cr_dist_code, cr_mand_code, cr_vcode, cropyear,season, cr_farmeruid, farmername,  fathername, mobileno, kh_no, cr_sno, tot_extent, occupname,  occupfname, occup_extent,"
					+ " sjointoccupant,cultivable_land,uncultivable_land,occupname,occup_extent,'O','W',dcode,mcode,part_key,"
					+ " regno,digitally_signed,'Y',cr_wsno,rec_id from " + pattadar_tab + " where  "
					+ "  cropyear=? and season=? and cr_vcode=? and regno=? and sjointoccupant=? and  cr_sno=? and kh_no=?  and status='D' and rec_id=? "
					+ "   and cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from "
					+ efish_tab + " where cr_vcode=?)"
					+ " and ((rec_id) not in "
					+ " (select rec_id from "
					+ crbooking_tab + " where cr_vcode=? and data_src='W')) " + " UNION " + " Select cr_dist_code,cr_mand_code,cr_vcode,"
					+ cropyear + " as cropyear,'" + season
					+ "' as season,cr_farmeruid,oc_name,oc_fname,mobileno,kh_no,cr_sno,tot_extent,"
					+ " occupname,occupfname, occupant_extent, 0 as sjointoccupant  ,0 as cultivable_land,0 as uncultivable_land ,occupname,occupant_extent,owner_tenant,data_src,"
					+ " dcode,mcode,part_key,0 as regno, 'N','Y',cr_wsno,rec_id   " + " from " + crbnwb + "  "
					+ " where ((rec_id,data_src) not in (select rec_id,data_src " + " 	 from  " + crbooking_tab
					+ "  where  vs_sel='Y' and cr_vcode=?)) and "
					+ " ((cast(cr_vcode as text)||cast(kh_no as text)||cr_sno) not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from  "
					+ efish_tab + " where cr_vcode=?)) " + " and  cr_vcode=?  and vs_sel='Y' and cr_sno=? and kh_no=? and rec_id=? ";

//			String qry = " INSERT INTO " + crbooking_tab
//					+ "(cr_dist_code, cr_mand_code, cr_vcode, cr_year, cr_season,  cr_farmeruid, oc_name, oc_fname,  mobileno, kh_no, cr_sno, tot_extent ,"
//					+ " occupname,occupfname , occupant_extent,sjointoccupant,cr_tr_i_ext,cr_tr_d_ext,anubhavadar_name,anubhavadar_extent,owner_tenant,data_src, "
//					+ " dcode,mcode,part_key,regno,digitally_signed,vs_sel,cr_wsno,rec_id) "
//					+ " select cr_dist_code, cr_mand_code, cr_vcode, cropyear,season, cr_farmeruid, farmername,  fathername, mobileno, kh_no, cr_sno, tot_extent, occupname,  occupfname, occup_extent,"
//					+ " sjointoccupant,cultivable_land,uncultivable_land,occupname,occup_extent,'O','W',dcode,mcode,part_key,"
//					+ " regno,digitally_signed,'Y',cr_wsno,rec_id from " + pattadar_tab + " where  "
//					+ "  cropyear=? and season=? and cr_vcode=? and regno=? and sjointoccupant=? and  cr_sno=? and kh_no=?  and status='D' and rec_id=? "
//					+ "   and cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from "
//					+ efish_tab + ")"
//					+ " and (cr_vcode,cr_sno,kh_no,regno,sjointoccupant,occupname,occup_extent,rec_id,'W') not in "
//					+ " (select cr_vcode,cr_sno,kh_no,regno,sjointoccupant,occupname,occupant_extent,rec_id,data_src from "
//					+ crbooking_tab + " where cr_vcode=?) " + " UNION " + " Select cr_dist_code,cr_mand_code,cr_vcode,"
//					+ cropyear + " as cropyear,'" + season
//					+ "' as season,cr_farmeruid,oc_name,oc_fname,mobileno,kh_no,cr_sno,tot_extent,"
//					+ " occupname,occupfname, occupant_extent, 0 as sjointoccupant  ,0 as cultivable_land,0 as uncultivable_land ,occupname,occupant_extent,owner_tenant,data_src,"
//					+ " dcode,mcode,part_key,0 as regno, 'N','Y',cr_wsno,rec_id   " + " from " + crbnwb + "  "
//					+ " where (cr_vcode,cr_sno,kh_no,occupname,occupfname,rec_id,data_src) not in (select cr_vcode,cr_sno,kh_no,occupname,"
//					+ " occupfname,rec_id,data_src " + " 	 from  " + crbooking_tab
//					+ "  where  vs_sel='Y' and cr_vcode=?) and "
//					+ " cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from  "
//					+ efish_tab + ") " + " and  cr_vcode=?  and vs_sel='Y' and cr_sno=? and kh_no=? and rec_id=? ";

			String rbkSelqry = "update " + rbksrnoMappTab
					+ "  set vs_sel='Y' where vcode=?  and rec_id =? and data_src=? ";

			int rbkupd = 0;

			for (int i = 0; i < vcodes.length; i++) {
				geoRefSts = "N";
				if (i == 0) {
					villageCode = vcodes[i];
				}
				if (WholesrArr[i] != null && !"null".equals(WholesrArr[i])) {

					crwexists = wholeSureveyNoCount(wbdist + "@" + vcodes[i] + "@" + WholesrArr[i]);
				} else {
					crwexists = 0;
				}
				if (crwexists > 0) {
					geoRefSts = "Y";
				}
				Query q2 = entityManager.createNativeQuery(qry);
				q2.setParameter(1, Integer.parseInt(cropyear));
				q2.setParameter(2, season);
				q2.setParameter(3, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(4, Long.parseLong(regNos[i].trim()));
				q2.setParameter(5, Long.parseLong(sjoints[i].trim()));
				q2.setParameter(6, surveyNo[i].trim());
				q2.setParameter(7, Long.parseLong(khno[i].trim()));
				q2.setParameter(8, Long.parseLong(recIds[i]));
				q2.setParameter(9, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(10, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(11, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(12, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(13, Integer.parseInt(vcodes[i].trim()));
				q2.setParameter(14, surveyNo[i].trim());// new String(sr_no[i].getBytes("8859_1"), "UTF-8")
				q2.setParameter(15, Long.parseLong(khno[i].trim()));
				q2.setParameter(16, Long.parseLong(recIds[i]));
				crbIns += q2.executeUpdate();
				
				if (crbIns > 0) {

					Query q3 = entityManager.createNativeQuery(rbkSelqry);
					q3.setParameter(1, Integer.parseInt(vcodes[i].trim()));
					q3.setParameter(2, Long.parseLong(recIds[i].trim()));// new String(sr_no[i].getBytes("8859_1"), //
																			// "UTF-8")
					q3.setParameter(3, dataSrcs[i]);
					rbkupd += q3.executeUpdate();
//					if (dataSrcs[i].toString().equals("C")) {
//						String crbfarmerUid = "", crb_bookingId = "";
//
//						String qrycrb = "select cr_farmeruid,bookingid from  " + crbooking_tab
//								+ "  where data_src='C' and cr_vcode=? and cr_sno=? and kh_no=? ";
//						Query q7 = entityManager.createNativeQuery(qrycrb);
//						q7.setParameter(1, Integer.parseInt(vcodes[i]));
//						q7.setParameter(2, new String(surveyNo[i].getBytes("8859_1"), "UTF-8"));
//						q7.setParameter(3, Long.parseLong(khno[i]));
//
//						Object object = q7.getSingleResult();
//
//						if (object != null) {
//							Object[] obj = (Object[]) object;
//							crbfarmerUid = obj[0].toString();
//							crb_bookingId = obj[1].toString();
//						}
//
//						String qry4 = "select cropname,varietyname,cr_sno,kh_no,occupname,occupfname,cr_mix_unmix_ext from ecrop2023.peri_k2022 where cr_vcode=? and cr_sno=? and kh_no=? and cr_farmeruid=?";
//						Query q4 = entityManager.createNativeQuery(qry4);
//						q4.setParameter(1, Integer.parseInt(vcodes[i]));
//						q4.setParameter(2, new String(surveyNo[i].getBytes("8859_1"), "UTF-8"));
//						q4.setParameter(3, Long.parseLong(khno[i]));
//						q4.setParameter(4, crbfarmerUid);
//						Object obj = q4.getSingleResult();
//
//						if (q4.getSingleResult() != null) {
//							Object[] data = (Object[]) obj;
//							cropName = data[0].toString();
//							varietyName = data[1].toString();
//							survNo = data[2].toString();
//							khNo = Integer.parseInt(data[3].toString());
//							peri_occup_Name = data[4].toString();
//							peri_occup_Fname = data[5].toString();
//							mixuNmix = Double.parseDouble(data[6].toString());
//
//							peri_status = "crop " + cropName + "," + "variety " + varietyName + "  booked in K-22 "
//									+ " Sy No " + survNo + " khata no " + khNo + " name " + peri_occup_Name
//									+ " father name " + peri_occup_Fname + " in " + mixuNmix + " (acres) ";
//
//							String qry5 = "update ecrop2023.peri_k2022 set forwarded='Y', pbookingid=?  where cr_vcode=? and cr_sno=? and kh_no=? and cr_farmeruid=?";
//							ps4 = entityManager.createNativeQuery(qry5);
//							ps4.setParameter(1, Long.parseLong(crb_bookingId));
//							ps4.setParameter(2, Integer.parseInt(vcodes[i]));
//							ps4.setParameter(3, new String(surveyNo[i].getBytes("8859_1"), "UTF-8"));
//							ps4.setParameter(4, Long.parseLong(khno[i]));
//							ps4.setParameter(5, crbfarmerUid);
//							ps4.executeUpdate();
//						}
//
//						String qry6 = "select cropname,varietyname,cr_sno,kh_no,occupname,occupfname,cr_mix_unmix_ext from ecrop2023.peri_r2022 where cr_vcode=? and cr_sno=? and kh_no=? and cr_farmeruid=?";
//						ps8 = entityManager.createNativeQuery(qry6);
//						ps8.setParameter(1, Integer.parseInt(vcodes[i]));
//						ps8.setParameter(2, survNo);
//						ps8.setParameter(3, Long.parseLong(khno[i]));
//						ps8.setParameter(4, crbfarmerUid);
//						Object datas = ps8.getSingleResult();
//
//						if (datas != null) {
//							Object[] data = (Object[]) datas;
//							cropName = data[0].toString();
//							varietyName = data[1].toString();
//							survNo = data[2].toString();
//							khNo = Integer.parseInt(data[3].toString());
//							peri_occup_Name = data[4].toString();
//							peri_occup_Fname = data[5].toString();
//							mixuNmix = Double.parseDouble(data[6].toString());
//							if (peri_status == null || peri_status.equals("")) {
//								peri_status = "crop " + cropName + "," + "variety " + varietyName + "  booked in R-22 "
//										+ " Sy No " + survNo + " khata no " + khNo + " name " + peri_occup_Name
//										+ " father name " + peri_occup_Fname + " in " + mixuNmix + " (acres) ";
//							} else {
//								peri_status = peri_status + "," + "crop " + cropName + "," + "variety " + varietyName
//										+ "  booked in R-22 " + " Sy No " + survNo + " khata no " + khNo + " name "
//										+ peri_occup_Name + " father name " + peri_occup_Fname + " in " + mixuNmix
//										+ " (acres) ";
//							}
//							String qry5 = "update ecrop2023.peri_r2022 set forwarded='Y', pbookingid=?  where cr_vcode=? and cr_sno=? and kh_no=? and cr_farmeruid=?";
//							ps5 = entityManager.createNativeQuery(qry5);
//							ps5.setParameter(1, Long.parseLong(crb_bookingId));
//							ps5.setParameter(2, Integer.parseInt(vcodes[i]));
//							ps5.setParameter(3, new String(surveyNo[i].getBytes("8859_1"), "UTF-8"));
//							ps5.setParameter(4, Long.parseLong(khno[i]));
//							ps5.setParameter(5, crbfarmerUid);
//							ps5.executeUpdate();
//						}
//
//						String qry2 = "UPDATE " + crbooking_tab
//								+ " set cultivator_type='C',cult_updateon=now(),cult_updatedby=?,geo_reffered=?,"
//								+ " srno_userid=?,emp_code=? ,peri_status=? where  cr_year=? and cr_season=? and cr_vcode=? and regno=? and sjointoccupant=? and kh_no=? "
//								+ " and rec_id=? and data_src=?";
//
//						q2 = entityManager.createNativeQuery(qry2);
//
//						q2.setParameter(1, userid);
//						q2.setParameter(2, geoRefSts);
//						q2.setParameter(3, userid);
//						q2.setParameter(4, Integer.parseInt(empCode));
//						if (peri_status != null && peri_status != "") {
//							q2.setParameter(5, peri_status);
//						} else {
//							q2.setParameter(5, "N");
//
//						}
//						q2.setParameter(6, Integer.parseInt(cropyear));
//						q2.setParameter(7, season);
//						q2.setParameter(8, Integer.parseInt(vcodes[i]));
//						q2.setParameter(9, Long.parseLong(regNos[i]));
//						q2.setParameter(10, Long.parseLong(sjoints[i]));
//						q2.setParameter(11, Long.parseLong(khno[i]));
//						q2.setParameter(12, Long.parseLong(recIds[i]));
//						q2.setParameter(13, dataSrcs[i]);
//						crbUpd += q2.executeUpdate();
//					}
//					else {
					String qry2 = "UPDATE " + crbooking_tab
							+ " set geo_reffered=?,srno_userid=?,emp_code=? where  cr_year=? and cr_season=? and cr_vcode=? and regno=? and sjointoccupant=? and kh_no=?  and rec_id=? and data_src=?";

					Query qu = entityManager.createNativeQuery(qry2);
					qu.setParameter(1, geoRefSts);
					qu.setParameter(2, userid);
					qu.setParameter(3, Integer.parseInt(empCode));
					qu.setParameter(4, Integer.parseInt(cropyear));
					qu.setParameter(5, season);
					qu.setParameter(6, Integer.parseInt(vcodes[i]));
					qu.setParameter(7, Long.parseLong(regNos[i]));
					qu.setParameter(8, Long.parseLong(sjoints[i]));
					qu.setParameter(9, Long.parseLong(khno[i]));
					qu.setParameter(10, Long.parseLong(recIds[i]));
					qu.setParameter(11, dataSrcs[i]);

					crbUpd += qu.executeUpdate();
//					}

				}
			}

			String qry6 = "SELECT COALESCE(	\r\n" + "	(select\r\n" + "        (no_of_records)\r\n" + "    from "
					+ downsuryTab + " \r\n"

					+ "    where vcode=? and cropyear=? and season=?)	,0)  as prevCnt ";

//				String qry6 = "select colleselect no_of_records as prevCnt from " + downsuryTab
//						+ " where vcode=? and cropyear=? and season=? ";
			Query q6 = entityManager.createNativeQuery(qry6);
			q6.setParameter(1, Integer.parseInt(villageCode));
			q6.setParameter(2, Integer.parseInt(cropyear));
			q6.setParameter(3, season);
			System.out.println(villageCode + " " + cropyear + " " + season);
			try {
				Object result = q6.getSingleResult();
				System.out.println("result" + result.toString());

				if (Integer.parseInt(result.toString()) > 0) {
					existingCnt = Integer.parseInt(result.toString());
				} else {
					newVcode = true;
					}

				if (newVcode) {
					Query q3 = entityManager.createNativeQuery("INSERT INTO " + downsuryTab
							+ "(vcode, userid, no_of_records,  ipaddress,cropyear,season,ccrc_status,downloadtime)  "
							+ "  VALUES (?, ?, ?, ?, ?, ?,'W', now())");

					q3.setParameter(1, Integer.parseInt(villageCode));
					q3.setParameter(2, userid);
					q3.setParameter(3, crbIns);
					q3.setParameter(4, ipaddress);
					q3.setParameter(5, Integer.parseInt(cropyear));
					q3.setParameter(6, season);
					downdetIns = q3.executeUpdate();

				} else {
					Query q3 = entityManager.createNativeQuery(" update " + downsuryTab
							+ " set ccrc_status='W', no_of_records=? ,ipaddress=? where vcode=? and userid=?    and cropyear=? and season=?");

					q3.setParameter(1, existingCnt + crbIns);
					q3.setParameter(2, ipaddress);
					q3.setParameter(3, Integer.parseInt(villageCode));
					q3.setParameter(4, userid);
					q3.setParameter(5, Integer.parseInt(cropyear));
					q3.setParameter(6, season);
					downdetIns = q3.executeUpdate();
				}

				status = crbIns;

				if (rbkupd > 0 && crbIns >= 0 && crbUpd > 0 && downdetIns >= 0) {
					status = crbIns;
				} else {
					status = -1;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		}
		return status;
	}

	public int wholeSureveyNoCount(String value) {
		String query = "Select count(*) from masters.vill_coords_p" + value.split("@")[0]
				+ " where cr_vcode=? and cr_wsno=? ";
		Query pstmt = entityManager.createNativeQuery(query);
		pstmt.setParameter(1, (Integer.parseInt(value.split("@")[1])));
		pstmt.setParameter(2, (Integer.parseInt(value.split("@")[2])));
		int crwexists = 0;
		if (pstmt.getSingleResult() != null) {
			crwexists = Integer.parseInt(pstmt.getSingleResult().toString());
		}
		return crwexists;
	}

}
