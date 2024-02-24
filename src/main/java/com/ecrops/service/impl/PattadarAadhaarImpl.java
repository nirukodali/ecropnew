package com.ecrops.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.dto.PattadarAadhaarDto;
import com.ecrops.repo.PattadarAadhaarRepo;

@Service
public class PattadarAadhaarImpl {

	@Autowired
	PattadarAadhaarRepo aadhaarRepo;

	@Transactional
	public void update(List<PattadarAadhaarDto> aadhaarDtos,String partitionName ) {
		
		for(PattadarAadhaarDto dto : aadhaarDtos ) {
			try {
				aadhaarRepo.updateAadhaar(partitionName, dto.getAadhaar() ,Integer.parseInt(dto.getRegno()),Integer.parseInt( dto.getSjointoccupant()), Integer.parseInt(dto.getCr_vcode()), Integer.parseInt(dto.getCr_year()), dto.getCr_season(),dto.getData_src() );
			}
			catch(Exception e){
	                e.printStackTrace();
			}
		}
	}
	
}
