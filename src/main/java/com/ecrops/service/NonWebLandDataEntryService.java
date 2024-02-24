package com.ecrops.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.dto.NonWebData;
import com.ecrops.entity.Cultivator;
import com.ecrops.entity.NonWebLandData;
import com.ecrops.repo.NonWebLandRepo;

@Service
public class NonWebLandDataEntryService {
    
    @Autowired
    private NonWebLandRepo nonWebLandRepo; 
    
   
	
	public NonWebLandData saveNonWebLandData(NonWebLandData nonWebLandData) {

		return nonWebLandRepo.save(nonWebLandData);
	}

	

    }



