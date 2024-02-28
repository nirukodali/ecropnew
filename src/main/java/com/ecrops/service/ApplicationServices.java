package com.ecrops.service;

import java.util.List;

import com.ecrops.projections.MasterProjections;
import com.ecrops.repo.DropdownsRepo.ReportTimeProj;

public interface ApplicationServices {
	public ReportTimeProj getReportTime();
	public List<MasterProjections> getWsrcdesc();
}
