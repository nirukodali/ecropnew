package com.ecrops.service;

import org.springframework.stereotype.Service;

import com.ecrops.entity.NonWebLandData;
import com.ecrops.entity.UnsDownloadDetails;
import com.ecrops.entity.UnsdownloadDetailsEntity;
import com.ecrops.entity.Unsurveyed_UnsettledDdetEntity;

@Service
public interface UnsdownloadDetailsService {
	//public void save(UnsdownloadDetailsEntity unsdownloadDetailsEntity);
	public void saveUnsDownloadDetails(UnsDownloadDetails unsDownloadDetails, Integer cropyear, String ipaddress, int mcode, String partKey, int mcode2, String cr_season, Integer wbvcode) ;
	
	public void saveCr_booking_nwb(NonWebLandData cr_booking_nwb, Integer wbdcode, Integer wbvcode, Integer wbmcode, String partKey, String surveyNo, String farmerUid, String cr_season, String objGender, Double totext, Long mobileNo, String cultfarmerName, String cultfatherName,Double cultext,Integer cropyear);
	
	public void saveUnsurveyed_UnsettledDdet(Unsurveyed_UnsettledDdetEntity unsurveyed_UnsettledDdetEntity, int dcode, 
			int mcode, Long mobileNo, Integer wbdcode, Integer wbmcode, Integer cropyear,
			String cr_season, String farmerUid, String cultfarmerName, String cultfatherName, 
			String surveyNo, Double totext, Double cultext, String objGender, Integer wbvcode, String objcat);
}
