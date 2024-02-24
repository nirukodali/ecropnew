package com.ecrops.service;

import java.util.List;

import com.ecrops.entity.WbMaster;

public interface WbMasterService {

	WbMaster getWbMasterDetailsForVillage(Integer wbvcode, Integer wbmcode, Integer wbdcode);

	WbMaster getWbMasterDetailsForMandal(Integer wbMcode, Integer wbDcode);
	
	List<WbMaster> findWebVcodeAndVname(Integer dcode, Integer mcode);
	
	List<WbMaster> findVillageName(Integer dcode, Integer mcode, Integer vcode);
	
	List<WbMaster> findUnsurveyedVilageList(Integer dcode, Integer mcode);


}
