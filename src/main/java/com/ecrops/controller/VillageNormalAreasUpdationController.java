package com.ecrops.controller;

import java.math.BigDecimal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.VillageNormalAreasDTO;
import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.RegularExpressionclassMethod;
import com.ecrops.entity.UserRegEntity;
import com.ecrops.entity.VillageUpdation;
import com.ecrops.entity.WbMaster;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.repo.UpdationRepo;
import com.ecrops.repo.UpdationRepo.updateView;
import com.ecrops.repo.VillageUpdationRepo;
import com.ecrops.repo.VillageUpdationRepo.mandal_2011_cs;
import com.ecrops.service.ActiveSeasonService;
import com.ecrops.service.WbMasterService;
import com.ecrops.service.impl.UpdationServiceImpl;
import com.ecrops.service.impl.VillageUpdationServiceImpl;

@Controller
public class VillageNormalAreasUpdationController {

	@Autowired
	private VillageUpdationServiceImpl impl;

	@Autowired
	private ActiveSeasonService activeSeasonService;

	@Autowired
	private WbMasterService wbMasterService;

	@Autowired
	private UpdationRepo updationRepo;

	@Autowired
	private VillageUpdationRepo vrep;

	@Autowired
	private UpdationServiceImpl updationService;

	@GetMapping("/VillageNormalAreasUpdation")
	public String VillageNormalAreasUpdation(Model model, HttpSession httpSession) {
		int type = (int) httpSession.getAttribute("userType");
		if (type == 5) {
		
			List<VillageUpdation> crop = impl.villageNormalAreasUpdation();
			
			System.out.println(crop.get(0).getCropid());
			List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
			model.addAttribute("year", cropYearActiveSeasonList.get(0).getCropyear());
			model.addAttribute("season", cropYearActiveSeasonList.get(0).getSeason());

			model.addAttribute("cropYear", cropYearActiveSeasonList.get(0).getSeasonvalue());
			model.addAttribute("cropNames", crop);
		}
		if (type == 22) {
			int dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
			List<VillageUpdation> crop = impl.villageNormalAreasUpdationHO();
			System.out.println(crop.get(0).getCropid());
			List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
			List<mandal_2011_cs> mand = vrep.mandName(dcode);
			model.addAttribute("mand", mand);
			model.addAttribute("year", cropYearActiveSeasonList.get(0).getCropyear());
			model.addAttribute("season", cropYearActiveSeasonList.get(0).getSeason());
			model.addAttribute("cropYear", cropYearActiveSeasonList.get(0).getSeasonvalue());
			model.addAttribute("cropNames", crop);

		}
		return "VillageNormalAreasUpdation";
	}

	@PostMapping("/updation")
	public String updation(@RequestParam("selectedCrop") String selectedCrop, Model model, UserRegEntity userRegEntity,
			HttpSession httpSession, HttpServletRequest httpServletRequest) {
		Integer wbdcode = (Integer) httpSession.getAttribute("wbdcode");
		Integer wbmcode = (Integer) httpSession.getAttribute("wbmcode");
		Integer mcode = Integer.parseInt((String) httpSession.getAttribute("mcode"));
		Integer dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
		int type = (int) httpSession.getAttribute("userType");
		String selectedMand = "";
		WbMaster wbMaster = null;
		wbMaster = wbMasterService.getWbMasterDetailsForMandal(wbmcode, wbdcode);
		Integer year = (Integer) httpSession.getAttribute("ACTIVEYEAR");
		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();

		if (type == 22) {
			selectedMand = httpServletRequest.getParameter("selectedMand");
			try {
				String cropid= selectedCrop.split("-")[1];
				int cropNum= Integer.parseInt(cropid);
				List<updateView> update = updationRepo.getDetailsHo(cropYearActiveSeasonList.get(0).getCropyear(),
						dcode, selectedMand, cropYearActiveSeasonList.get(0).getSeason(), cropNum);
				if (update.size() == 0) {
					model.addAttribute("empty", "No Records Found");
				}
				if (update.size() > 0) {
					model.addAttribute("update", update);
					model.addAttribute("wbdname", wbMaster.getWbedname());
					model.addAttribute("wbmname", wbMaster.getWbemname());
				}
			} catch (Exception e) {
				model.addAttribute("empty", "No Records Found");

			}
			model.addAttribute("selectedMand", selectedMand);
		}
		if (type == 5) {
			httpSession.setAttribute("wbedname", wbMaster.getWbedname());
			httpSession.setAttribute("year", year);

			try {
				String cropid= selectedCrop.split("-")[1];
				int cropNum= Integer.parseInt(cropid);
				System.out.println(cropNum);
				List<updateView> update = updationRepo.getDetails(cropYearActiveSeasonList.get(0).getCropyear(), dcode,
						mcode, cropYearActiveSeasonList.get(0).getSeason(), cropNum);
				if (update.size() == 0) {
					model.addAttribute("empty", "No Records Found");
				}
				if (update.size() > 0) {
					model.addAttribute("update", update);
					model.addAttribute("wbdname", wbMaster.getWbedname());
					model.addAttribute("wbmname", wbMaster.getWbemname());
				}
			} catch (Exception e) {
				model.addAttribute("empty", "No Records Found");

			}
		}

		model.addAttribute("year", cropYearActiveSeasonList.get(0).getCropyear());
		model.addAttribute("season", cropYearActiveSeasonList.get(0).getSeason());
		model.addAttribute("cropYear", cropYearActiveSeasonList.get(0).getCropyear());
		httpSession.setAttribute("wbemname", wbMaster.getWbemname());
		httpSession.setAttribute("name", userRegEntity.getName());
		model.addAttribute("selectedCrop", selectedCrop);
		return "updation";
	}


	@PostMapping("/updateVillageNormalArea")
	public String update(@RequestBody List<VillageNormalAreasDTO> villageNormalAreasDTOList,HttpSession httpSession,HttpServletRequest httpServletRequest,RedirectAttributes attributes) {
		
		int type= (int) httpSession.getAttribute("userType");
		String user = (String) httpSession.getAttribute("userid");
		
		RegularExpressionclassMethod expressionclassMethod = new RegularExpressionclassMethod();
		
		String selectedCrop=villageNormalAreasDTOList.get(0).getSelectedCrop();
		Integer mcode= Integer.parseInt((String) httpSession.getAttribute("mcode")) ;
		Integer dcode= Integer.parseInt((String) httpSession.getAttribute("dcode"));
		String selectedMand="";
		String cropid= selectedCrop.split("-")[1];
		int cropNum= Integer.parseInt(cropid);
		if(type==22) {
		 selectedMand= httpServletRequest.getParameter("selected");
		}
		
		updationService.updateNormalAreas(villageNormalAreasDTOList,mcode,dcode,cropNum,user,type);
		return "redirect:/VillageNormalAreasUpdation";
	}

}
