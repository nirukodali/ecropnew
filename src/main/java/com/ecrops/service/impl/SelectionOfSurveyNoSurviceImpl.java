package com.ecrops.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.dto.SelectionOfSurvyPojo;
import com.ecrops.repo.DistrictCsRepository;
import com.ecrops.repo.SelectionOfSurveyRepo;
import com.ecrops.repo.WbvillagesRepository;
import com.ecrops.service.SelectionOfSurveyNoSurvice;
import com.ecrops.util.ECropUtility;

@Service("SelectionOfSurveyNoSurvice")
public class SelectionOfSurveyNoSurviceImpl implements SelectionOfSurveyNoSurvice {

	@Autowired
	private SelectionOfSurveyRepo repo;

	@Autowired
	private WbvillagesRepository wbvillageRepo;

	@Autowired
	private DistrictCsRepository districtCsRepo;

	@Override
	public List<SelectionOfSurvyPojo> getData(HttpServletRequest request, HttpSession session) {
		String sesdcode = session.getAttribute("dcode").toString();
		String sesmcode = session.getAttribute("mcode").toString();
		String user = session.getAttribute("userid").toString();
		String sesvcode = ECropUtility.sessionData(session).getVsCode();
		// String season = (String) session.getAttribute("season");

		String data = "", cropyear = "", season = "", searchParam = "1", surveyNo = "", aadharNo = "", khataNo = "";
		String qry = "", vcode = "", wbdcode = "", prejcode = "";

		String activeYear = "2023";
		String crpses = request.getParameter("crYear");
		cropyear = crpses.split("@")[1];
		season = crpses.split("@")[0];
		String tseason = "", fromKhata = "", toKhata = "";
		String dist = session.getAttribute("dcode").toString();
		wbdcode = districtCsRepo.findByDcode(Integer.parseInt(sesdcode.trim())).getWbdcode();

		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}

		vcode = request.getParameter("vcode");
		searchParam = request.getParameter("searchParam");

		fromKhata = request.getParameter("fromKhno");
		toKhata = (request.getParameter("toKhno") != null && request.getParameter("toKhno") != "")
				? request.getParameter("toKhno")
				: "" + fromKhata + "";

		String fromWsrno = request.getParameter("surveyno") != null ? request.getParameter("surveyno") : "";
		String toWsrno = (request.getParameter("tosurveyno") != null && request.getParameter("tosurveyno") != "")
				? request.getParameter("tosurveyno")
				: "" + fromWsrno + "";

		String crbookingnwbTab = "cr_booking_nwb";
		String pattadartable = "pattadarmast_wb_partition_" + season + wbdcode + cropyear;
		String crbookingTab = "cr_booking_partition_" + season + wbdcode + cropyear;
		String rbkSrnoMappingTab = "rbk_surveyno_mapping_" + season + wbdcode + cropyear;
		String tab2 = "cr_booking_nwb";
		String efish_data = "cr_details_efish";

		if (activeYear.equals(cropyear) && season.equals("R")) {
			pattadartable = "ecrop" + activeYear + ".pattadarmast_wb_partition_" + season + wbdcode + cropyear;
			crbookingTab = "ecrop" + activeYear + "." + crbookingTab;
			rbkSrnoMappingTab = "ecrop" + activeYear + "." + rbkSrnoMappingTab;
			tab2 = "ecrop" + activeYear + "." + tab2;
			crbookingnwbTab = "ecrop" + activeYear + "." + crbookingnwbTab;
			efish_data = "ecrop" + activeYear + "." + efish_data;

		}

		String extAlreadyAlloted = "", wsnoAlready = "";

		tseason = season;

//         qry = " (select 'W' as data_src,rec_id,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,farmername,fathername,"
//         		+ "occupname,occupfname,kh_no,cr_sno,tot_extent,occup_extent,regno,"
//                 + " sjointoccupant,cultivable_land,uncultivable_land,dcode,mcode,mobileno,part_key,cr_wsno  "
//                 + " from " + pattadartable + " where status='Y' and cr_vcode=? and  ";
//
//         if (searchParam.equals("1")) {
//             qry += " cr_wsno between " + fromWsrno + " and " + toWsrno + "";
//         } else if (searchParam.equals("2")) {
//             qry += " kh_no between " + fromKhata + " and " + toKhata + "";
//         }
//
//         qry += " and  kh_no not in (select code from obj_unobj where trim(crb_remarks) in ('No')) "
//                 + " and (cr_vcode,cr_sno,kh_no,occupname,occupfname,farmername,fathername,occup_extent,tot_extent,regno,sjointoccupant) "
//                 + " not in (select cr_vcode,cr_sno,kh_no,occupname,occupfname,oc_name,oc_fname,occupant_extent,tot_extent,regno,sjointoccupant from " + crbookingTab + " where  vs_sel='Y' and cr_vcode=?) and "
//                 + "  cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from  " + efish_data + " ) and"
//                 + "  ((cr_vcode,cr_sno) in(select vcode,cr_sno from ecrop2023.rbk_surveyno_mapping where rbkuserid=? and dcode=? and mcode=? and cr_year=? and cr_season=? ))"
//                 + " order by cr_wsno ) "
//                 + " UNION  "
//                 + " Select data_src,rec_id,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,oc_name,oc_fname,occupname,occupfname,kh_no,cr_sno,tot_extent,occupant_extent,0 as regno,"
//                 + " 0 as sjointoccupant,0 as cultivable_land,0 as uncultivable_land,dcode,mcode,mobileno,part_key,cr_wsno from " + crbookingnwbTab + " where  " ;
//               
//                   if (searchParam.equals("1")) {
//             qry += " cr_wsno between " + fromWsrno + " and " + toWsrno + "";
//         } else if (searchParam.equals("2")) {
//             qry += " kh_no between " + fromKhata + " and " + toKhata + "";
//         }
//                 
//              qry+= "  and (cr_vcode,cr_sno,kh_no,occupname,occupfname ,oc_name,oc_fname,occupant_extent,tot_extent,regno,sjointoccupant,rec_id ) not in "
//                 + "(select cr_vcode,cr_sno,kh_no,occupname,occupfname,oc_name,oc_fname,occupant_extent,tot_extent,regno,sjointoccupant,rec_id "
//                 + " from " + crbookingTab + " where  vs_sel='Y' and cr_vcode=?) and "
//                 + "  cast(cr_vcode as text)||cast(kh_no as text)||cr_sno not in (select cast(cr_vcode as text)||cast(kh_no as text)||cr_sno from " + efish_data + " ) "
//                 + " and  cr_vcode=?  and vs_sel='Y' order by cr_wsno ";

//		(select 'W' as data_src,a.rec_id,cr_dist_code,cr_mand_code,cr_vcode,b.cr_farmeruid,b.farmername,b.fathername,b.occupname,b. occupfname,
//				a.kh_no,a.cr_sno,b.tot_extent,b.occup_extent,b.regno,    sjointoccupant,cultivable_land,uncultivable_land,a.dcode,a.mcode,mobileno,part_key,a.cr_wsno   
//				from ecrop2023.rbk_surveyno_mapping_R202023 a, ecrop2023.pattadarmast_wb_partition_R202023 b  where  vcode=2002006 and cr_year=2023 and cr_season='R'
//				and rbkuserid='RBK_10690748'  and a.rec_id=b.rec_id and   b.kh_no between 5 and 10 and vs_sel is null  order by a.cr_wsno)
		/*qry = " (select 'W' as data_src,a.rec_id,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,b.farmername,b.fathername,b.occupname,b.occupfname,a.kh_no,a.cr_sno,b.tot_extent,b.occup_extent,b.regno,  "
				+ "  a.sjointoccupant,a.cultivable_land,a.uncultivable_land,a.dcode,a.mcode,mobileno,part_key,a.cr_wsno   from "
				+ rbkSrnoMappingTab + " a, " + pattadartable + " b "
				+ " where  vcode=? and cr_year=? and cr_season=? and rbkuserid=?  and a.rec_id=b.rec_id and  ";
		*/
		
		qry = " (select  data_src,a.rec_id,wbdcode as cr_dist_code,wbmcode as cr_mand_code,vcode as cr_vcode,cr_farmeruid,oc_name as farmername ,oc_fname as fathername,occupname,occupfname,kh_no,cr_sno,tot_extent,occup_extent,regno,  "
				+ "  sjointoccupant,cultivable_land,uncultivable_land,dcode,mcode,mobile as mobileno,partkey as part_key,cr_wsno   from "
				+ rbkSrnoMappingTab + " a  "
				+ " where  vcode=? and cr_year=? and cr_season=? and rbkuserid=?   and  ";
		
		if (searchParam.equals("1")) {
			qry += " cr_wsno between " + fromWsrno + " and " + toWsrno + "";
		} else if (searchParam.equals("2")) {
			qry += " kh_no between " + fromKhata + " and " + toKhata + "";
		}
		qry += " and vs_sel is null  order by cr_wsno,kh_no,cr_sno)";
		
		/*qry+=" UNION  "+
				" Select data_src,rec_id,cr_dist_code,cr_mand_code,cr_vcode,cr_farmeruid,oc_name,oc_fname,occupname,occupfname,kh_no,cr_sno,tot_extent,occupant_extent,0 as regno,\r\n" + 
				" 0 as sjointoccupant,0 as cultivable_land,0 as uncultivable_land,dcode,mcode,mobileno,part_key,cr_wsno from ecrop2023.cr_booking_nwb where  \r\n" + 
				"  cr_vcode=? " ;
		
		if (searchParam.equals("1")) {
					qry += " and cr_wsno between " + fromWsrno + " and " + toWsrno + "";
				} else if (searchParam.equals("2")) {
					qry += " and kh_no between " + fromKhata + " and " + toKhata + "";
				}
		
		qry+=" and vs_sel is null order by cr_wsno ";*/
		
		String villageName = wbvillageRepo.findByWbvcode(Integer.parseInt(vcode)).getWbvname();
		List<Object[]> dataList = repo.saveEmployeeLogDetails(qry, vcode, user, sesdcode, sesmcode, cropyear, tseason);
		List<SelectionOfSurvyPojo> pojoList = new ArrayList<>();
		for (Object[] row : dataList) {
			Object[] datas = row; 
			SelectionOfSurvyPojo pojo = new SelectionOfSurvyPojo();

			pojo.setVillage(villageName);
			pojo.setDsrc(datas[0].toString());
			pojo.setRecId(datas[1].toString());
			pojo.setCrDcode(datas[2].toString());
			pojo.setCrMcode(datas[3].toString());
			pojo.setCrVcode(datas[4].toString());

			pojo.setUid(datas[5].toString());
			pojo.setpName(datas[6].toString());
			pojo.setPfName(datas[7].toString());
			pojo.setOcName(datas[8].toString());
			pojo.setOcfName(datas[9].toString());
			pojo.setKhNo(datas[10].toString());
			pojo.setSno(datas[11].toString());
			pojo.setTotExtent(datas[12].toString());
			pojo.setOcExtent(datas[13].toString());
			pojo.setRegno(datas[14].toString());
			if(datas[15].toString()!=null) {
				pojo.setSjoint(datas[15].toString());
			}
			else {
				pojo.setSjoint("");
			}
			
			pojo.setCultivableLand(datas[16].toString());
			pojo.setUncultvableLand(datas[17].toString());
			pojo.setDcode(datas[18].toString());
			pojo.setMcode(datas[19].toString());
			pojo.setMbno(datas[20].toString());
			pojo.setPartKey(datas[21].toString());
			pojo.setWsno(datas[22].toString());

			pojoList.add(pojo);

		}

		return pojoList;
	}

	@Override
	public List<String> getDataForAllotedArea(HttpServletRequest request, HttpSession session) {

		List<String> data = new ArrayList<>();
		String sesdcode = session.getAttribute("dcode").toString();
		String sesmcode = session.getAttribute("mcode").toString();
		String user = session.getAttribute("userid").toString();
		String crpses = request.getParameter("crYear");
		String cropyear = crpses.split("@")[1];
		String season = crpses.split("@")[0];
		String wbdcode = districtCsRepo.findByDcode(Integer.parseInt(sesdcode.trim())).getWbdcode();
		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}
		String crbookingTab = "cr_booking_partition_" + season + wbdcode + cropyear;
		String activeYear = "2023";

		if (activeYear.equals(cropyear) && season.equals("K")) {

			crbookingTab = "ecrop" + activeYear + "." + crbookingTab;

		}
		String cntqry = "select count(cr_wsno) as srnocnt,sum(occupant_extent) as extent from " + crbookingTab
				+ " where dcode=" + sesdcode + " and mcode=" + sesmcode + " and srno_userid='" + user + "' ";
		List<Object[]> obj = repo.getCountOfLand(cntqry);
		for (Object[] list : obj) {
			Object[] value = list;
			data.add((String) value[0]);
			data.add((String) value[1]);
		}
		return data;
	}

}
