package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.entity.CropwiseExtBookedMaoIntf;
import com.ecrops.partitions.CropwiseExtVillPartition;
import com.ecrops.repo.DropdownsRepo.ReportTimeProj;
import com.ecrops.service.ApplicationServices;
import com.ecrops.util.MasterFunctions;
@Controller
public class MroRibbonController {
	
	@Autowired private ApplicationServices applicationServices;
	@Autowired private MasterFunctions masterFunctions;
	
	@GetMapping("/villseclist")
	public String getVillSecList(HttpSession httpSession, Model model) {
		return "Rep_VillSecListMaoIntf";
	}
	

	@GetMapping("/vaadet")
	public String getVaaList(Model model) {
		return "Rep_VAADetails";
	}
	@GetMapping("/supchkra")
	public String getSupChkRecrdAlloted(Model model) {
		return "SuperCheckRecordsAlloted";
	}
	@GetMapping("/supchk")
	public String getSupChR(Model model , HttpServletRequest httpServletRequest,HttpSession session) {
		String activeyear = httpServletRequest.getParameter("activeyear");
		System.out.println("activeyear=====>"+activeyear);
		return "SpuperCheck";

	}
	
	@GetMapping("/crpwiseextent")
	public String getCropExt(Model model  ) {
		return "Rep_cropwiseExtBookedMaoIntf";

	}
	
	@Autowired
	CropwiseExtVillPartition cropwiseExtVillPartition;
	@PostMapping("/crpwiseextent1")
	public String getCropExt1(
			@RequestParam("mcode") String mcode,
			@RequestParam("cropid") String cropid,
			@RequestParam("crpgrpId") String crpgrpId,
			@RequestParam("cropyear") String cropyear,
			@RequestParam("wbvname") String wbvname,
			@RequestParam("totext") String totext,
			Model model) {
		
		
		ReportTimeProj reportTime = applicationServices.getReportTime();
		
		model.addAttribute("reportTime", reportTime.getReporttime());
		
		String groupName = masterFunctions.masterFunction(crpgrpId, "cropgrp");
		//System.out.println("groupName="+groupName);
		model.addAttribute("groupName", groupName);
		
		model.addAttribute("cropname", masterFunctions.masterFunction(cropid, "cropname"));
		
		String[] season = cropyear.split("@");
		String cseason = season[0];
		System.out.println("cseason========="+cseason);
		Integer Year = Integer.parseInt(season[1]);
		System.out.println("Year========="+Year);
		model.addAttribute("cropyear", Year);
		
		if(cseason.equalsIgnoreCase("K")) { model.addAttribute("cseason", "Kharif"); }
		if(cseason.equalsIgnoreCase("R")) { model.addAttribute("cseason", "Rabi"); }
		if(cseason.equalsIgnoreCase("S")) { model.addAttribute("cseason", "Summer"); }
		List<CropwiseExtBookedMaoIntf> crpExt1 = cropwiseExtVillPartition.getCrpExt1(mcode, mcode, cropid, cropyear, crpgrpId);
		
		model.addAttribute("crpExt1", crpExt1);
		return "Rep_cropwiseExtVill";

	}
	
	@GetMapping("/statewisecrop")
	public String getStatewsrc(Model model) {
		System.out.println("statewsrc");
		//String village = masterFunctions.masterFunction(cr_vcode, "wbvillage");
		model.addAttribute("irrigationsList", applicationServices.getWsrcdesc());
 
		return "Rep_StateWiseCropIrriAbsIntf";
		
	}
	
}
