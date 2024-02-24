package com.ecrops.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MroRibbonController {
	
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
}
