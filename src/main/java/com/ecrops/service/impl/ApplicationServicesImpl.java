package com.ecrops.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.projections.MasterProjections;
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

	@Override
	public List<MasterProjections> getWsrcdesc() {
		// TODO Auto-generated method stub
		return dropdownsRepo.getWsrcdesc();
	}

}
