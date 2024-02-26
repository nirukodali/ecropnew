package com.ecrops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.repo.DropdownsRepo;
import com.ecrops.repo.DropdownsRepo.ReportTimeProj;
import com.ecrops.service.ApplicationServices;
@Service
public class ApplicationServicesImpl implements ApplicationServices{
	
	@Autowired private DropdownsRepo dropdownsRepo;

	@Override
	public ReportTimeProj getReportTime() {
		// TODO Auto-generated method stub
		return dropdownsRepo.getReportTime();
	}

}
