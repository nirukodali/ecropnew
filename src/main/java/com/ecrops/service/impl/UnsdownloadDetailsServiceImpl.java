package com.ecrops.service.impl;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.NonWebLandData;
import com.ecrops.entity.UnsDownloadDetails;
import com.ecrops.entity.UnsdownloadDetailsEntity;
import com.ecrops.entity.Unsurveyed_UnsettledDdetEntity;
import com.ecrops.repo.NonWebLandRepo;
import com.ecrops.repo.UnsdownloadDetailsRepo;
import com.ecrops.repo.Unsurveyed_UnsettledDdetRepo;
import com.ecrops.service.UnsdownloadDetailsService;

@Service
public class UnsdownloadDetailsServiceImpl implements UnsdownloadDetailsService {
	@Autowired
	private UnsdownloadDetailsRepo unsdownloadDetailsRepo;

	@Autowired

	private Unsurveyed_UnsettledDdetRepo unsurveyed_UnsettledDdetRepo;

	@Autowired

	private NonWebLandRepo nonWebLandRepo;

	public void saveUnsurveyed_UnsettledDdet(Unsurveyed_UnsettledDdetEntity unsurveyed_UnsettledDdetEntity, int dcode,
			int mcode, Long mobileNo, Integer wbdcode, Integer wbmcode, Integer cropyear, String cr_season,
			String farmerUid, String cultfarmerName, String cultfatherName, String surveyNo, Double totext,
			Double cultext, String objGender, Integer wbvcode, String objcat) {
		unsurveyed_UnsettledDdetEntity.setDcode(dcode);
		unsurveyed_UnsettledDdetEntity.setMcode(mcode);
		unsurveyed_UnsettledDdetEntity.setMobileno(mobileNo);
		unsurveyed_UnsettledDdetEntity.setCr_dist_code(wbdcode);
		unsurveyed_UnsettledDdetEntity.setCr_mand_code(wbmcode);
		unsurveyed_UnsettledDdetEntity.setCr_year(cropyear);
		unsurveyed_UnsettledDdetEntity.setCr_season(cr_season);
		unsurveyed_UnsettledDdetEntity.setCr_farmeruid(farmerUid);
		unsurveyed_UnsettledDdetEntity.setOccupname(cultfarmerName);
		unsurveyed_UnsettledDdetEntity.setOc_fname(cultfatherName);
		unsurveyed_UnsettledDdetEntity.setCr_sno(surveyNo);
		unsurveyed_UnsettledDdetEntity.setTot_extent(totext);
		unsurveyed_UnsettledDdetEntity.setOccupant_extent(cultext);
		unsurveyed_UnsettledDdetEntity.setGender(objGender);
		unsurveyed_UnsettledDdetEntity.setCr_vcode(wbvcode);
		unsurveyed_UnsettledDdetEntity.setCat_code(objcat);

		unsurveyed_UnsettledDdetRepo.save(unsurveyed_UnsettledDdetEntity);
	}

	public void saveCr_booking_nwb(NonWebLandData cr_booking_nwb, Integer wbdcode, Integer wbvcode, Integer wbmcode,
			String partKey, String surveyNo, String farmerUid, String cr_season, String objGender, Double totext,
			Long mobileNo, String cultfarmerName, String cultfatherName, Double cultext, Integer cropyear) {

		cr_booking_nwb.setCr_dist_code(wbdcode);
		cr_booking_nwb.setCr_vcode(wbvcode);
		cr_booking_nwb.setCr_mand_code(wbmcode);
		cr_booking_nwb.setPart_key(partKey);
		cr_booking_nwb.setCr_sno(surveyNo);
		cr_booking_nwb.setCr_farmeruid(farmerUid);
		cr_booking_nwb.setCr_season(cr_season);
		cr_booking_nwb.setGender(objGender);
		cr_booking_nwb.setTot_extent(totext);
		cr_booking_nwb.setMobileno(mobileNo);
		cr_booking_nwb.setOccupname(cultfarmerName);
		cr_booking_nwb.setOccupfname(cultfatherName);
		cr_booking_nwb.setOccupant_extent(cultext);
		cr_booking_nwb.setCr_year(cropyear);
		
		nonWebLandRepo.save(cr_booking_nwb);
	}

	public void saveUnsDownloadDetails(UnsDownloadDetails unsDownloadDetails, Integer cropyear, String ipaddress,
			int mcode, String partKey, int mcode2, String cr_season, Integer wbvcode) {
		
		Integer count = unsdownloadDetailsRepo.getNoOfRecords(wbvcode, cropyear, cr_season);
		if(count==null)
		{
			count =0;
		}
		count= count+1;
		unsDownloadDetails.setNo_of_records(count);
		System.out.println("No of records"+count);
		unsDownloadDetails.setCropYear(cropyear);
		unsDownloadDetails.setDownloadtime(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		unsDownloadDetails.setIpaddress(ipaddress);
		unsDownloadDetails.setVcode(wbvcode);
		unsDownloadDetails.setUserid(partKey);
		unsDownloadDetails.setNo_of_records(count);
		unsDownloadDetails.setSeason(cr_season);
		unsDownloadDetails.setDatedownload(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		unsdownloadDetailsRepo.save(unsDownloadDetails);
		
	}

}
