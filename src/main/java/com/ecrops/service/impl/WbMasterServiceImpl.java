package com.ecrops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.WbMaster;
import com.ecrops.repo.WbMasterRepo;
import com.ecrops.service.WbMasterService;

@Service
public class WbMasterServiceImpl implements WbMasterService {

	@Autowired
	WbMasterRepo wbMasterRepo;

	@Override
	public WbMaster getWbMasterDetailsForVillage(Integer wbvcode, Integer wbMcode, Integer wbDcode) {
		return wbMasterRepo.getWbMasterDetailsForVillage(wbvcode, wbMcode, wbDcode);
	}

	@Override
	public WbMaster getWbMasterDetailsForMandal(Integer wbMcode, Integer wbDcode) {
		return wbMasterRepo.getWbMasterDetailsForMandal(wbMcode, wbDcode);
	}
		@Override
		public List<WbMaster> findWebVcodeAndVname(Integer dcode, Integer mcode) {
			return wbMasterRepo.findWebVcodeAndVname(dcode,  mcode);
		}
		
		@Override
		public List<WbMaster> findVillageName(Integer dcode, Integer mcode, Integer vcode){
			return wbMasterRepo.findVillageName( dcode,  mcode,  vcode);
	}
		
		
		@Override
		public List<WbMaster> findUnsurveyedVilageList(Integer dcode, Integer mcode) {
			return wbMasterRepo.findUnsurveyedVilageList(dcode, mcode);
		}


}
