package com.ecrops.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecrops.entity.VillageUpdation;

@Service
public interface VillageUpdationService {

public List<VillageUpdation> villageNormalAreasUpdation();

public List<VillageUpdation> villageNormalAreasUpdationHO();
	
}
