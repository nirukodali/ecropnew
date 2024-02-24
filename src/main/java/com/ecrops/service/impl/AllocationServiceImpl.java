package com.ecrops.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.WbVillageMastProjection;

import com.ecrops.repo.CrEmployeeProfileRepository;

import com.ecrops.repo.EmpRbkMapRepo;

import com.ecrops.repo.WbvillagesRepository;
import com.ecrops.service.AllocationService;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	
	
	@Autowired
	private WbvillagesRepository wbvillageRepository;
	
	@Autowired
	private EmpRbkMapRepo mapRepo;
	
	@Override
	public List<WbVillageMastProjection> getWebLandDetails(Integer dcode,Integer mcode) {
		return wbvillageRepository.getWebLandDetails(dcode, mcode);
	}

	@Override
	public List<RbkDetailsProjection> getRbkUserId(Integer rbkCode,Integer empCode) {
		
		return mapRepo.getRbkUserId(rbkCode, empCode);
	}
}