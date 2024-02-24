package com.ecrops.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.repo.DataReDownloadRepo;
import com.ecrops.repo.DataReDownloadRepo.Activeseason;
import com.ecrops.service.EmployeeService;
import com.ecrops.repo.GetDownloadStatus;
import com.ecrops.util.MasterFunctions;

@Controller
public class DataDownloadController {
	
	@Autowired
	private DataReDownloadRepo dataReDownloadRepo;
	
	@Autowired
	GetDownloadStatus downloadStatus;
	
	@Autowired
	private EmployeeService employeeService;
		
	@GetMapping("/datadownload")
	public String Datadownload(HttpSession httpSession, Model model, HttpServletRequest httpServletRequest) {
		System.out.println("datta-->>>");
		Activeseason activeSeason = dataReDownloadRepo.getActiveseason();
		model.addAttribute("activeSeason", activeSeason);
		return "datadownload";
	}

	@PostMapping("/saveDatadownload")
	public String saveDatadownload(HttpSession httpSession, Model model, HttpServletRequest httpServletRequest,
			RedirectAttributes redirectAttributes) throws SQLException {
		String tbname1 = "", tseason = "", wbdcode = "";

		Activeseason activeSeason = dataReDownloadRepo.getActiveseason();
		model.addAttribute("activeSeason", activeSeason);

		String season = activeSeason.getSeasonvalue();
		String dcode = (String) httpSession.getAttribute("dcode");
		String userid = (String) httpSession.getAttribute("userid");
		String sescrpyear = httpServletRequest.getParameter("cropyear");

		season = sescrpyear.split("@")[0];
		if (season == null || season.isEmpty()) {
			redirectAttributes.addFlashAttribute("msg", " Please Select Crop Year ");
			return "redirect:/datadownload";
		}
		String activeyear = "2023";
		String vcode = httpServletRequest.getParameter("vcode");
		if (vcode == null || vcode.isEmpty()) {
			redirectAttributes.addFlashAttribute("msg", " Please Select vcode ");
			return "redirect:/datadownload";
		}
		String preasonId = httpServletRequest.getParameter("reasonId");
		if (preasonId == null || preasonId.isEmpty()) {
			redirectAttributes.addFlashAttribute("msg", " Please Select Reasons  ");
			return "redirect:/datadownload";
		}
		String deviceId = httpServletRequest.getParameter("deviceId");
		if (deviceId == null || deviceId.isEmpty()) {
			redirectAttributes.addFlashAttribute("msg", " Please Select Device Id  ");
			return "redirect:/datadownload";
		}
		String remoteaddr = httpServletRequest.getRemoteAddr();
		String cropyear = sescrpyear.split("@")[1];
		tseason = season.toLowerCase();
		wbdcode = MasterFunctions.masterFunction(dcode, "wbdcode");
		if (wbdcode.length() == 1) {
			wbdcode = "0" + wbdcode;
		}
		tbname1 = "cr_booking_partition_" + tseason + wbdcode + cropyear;
		if (activeyear.equals(cropyear)) {
			tbname1 = "ecrop" + activeyear + "." + tbname1;
		}
		Character downloadedStatus = downloadStatus.getDownloadStatus(wbdcode, vcode, cropyear, tseason);
		if (downloadedStatus != null && !downloadedStatus.equals(" ")) {
			if (downloadedStatus == 'Y') {
				int updatedownload = employeeService.savedownload(tbname1, Integer.parseInt(vcode));
				int insertiondownload = employeeService.insertdownload(activeyear, Integer.parseInt(vcode), userid,
						remoteaddr, Integer.parseInt(preasonId), Integer.parseInt(cropyear), season);
					redirectAttributes.addFlashAttribute("msg", "Successfully Downloaded Records For Your Village.");
					return "redirect:/datadownload";
				} else {
					redirectAttributes.addFlashAttribute("msg", "Updation Failed due to Some Technical  Issue.");
					return "redirect:/datadownload";
				}
		} else {
			model.addAttribute("noResults", true);
		}
		return "redirect:/datadownload";
	}
}
