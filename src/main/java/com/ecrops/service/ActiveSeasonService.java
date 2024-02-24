package com.ecrops.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.projection.ActiveSeasonProjection;

@Service
public interface ActiveSeasonService {

	public List<ActiveSeason> listAll();
	
	public List<ActiveSeasonProjection> getActiveSeason();
	
//	public List<ActiveSeasonProjection> findByActiveAndCurrentSeason();
}
