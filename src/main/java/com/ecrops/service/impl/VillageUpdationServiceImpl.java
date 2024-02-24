package com.ecrops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.VillageUpdation;
import com.ecrops.repo.VillageUpdationRepo;
import com.ecrops.service.VillageUpdationService;

@Service
public class VillageUpdationServiceImpl implements VillageUpdationService{
	
	@Autowired
	private VillageUpdationRepo repo;

	@Override
	public List<VillageUpdation> villageNormalAreasUpdation() {
		return repo.VillageNormalAreasUpdation();
	}
	
	@Override
	public List<VillageUpdation> villageNormalAreasUpdationHO() {
		return repo.VillageNormalAreasUpdationHO();
	}

//	public List<VillageUpdation> mandName(int dcode) {
//		// TODO Auto-generated method stub
//		return repo.mandName(dcode);
//	}

}
