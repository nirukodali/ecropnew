package com.ecrops.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.Unsetteled_UnsurveyedDto;
import com.ecrops.dto.UnsurveydDataDto;
import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.Cr_BookingEntity;
import com.ecrops.entity.Cultivator;
import com.ecrops.entity.NonWebLandData;
import com.ecrops.entity.UnsDownloadDetails;
import com.ecrops.entity.UnsdownloadDetailsEntity;
import com.ecrops.entity.Unsurveyed_UnsettledDdetEntity;
import com.ecrops.entity.WbMaster;
import com.ecrops.repo.Cr_booking_PartitionRepo;
import com.ecrops.repo.NonWebLandRepo;
import com.ecrops.repo.NonWebReasonsRepo;
import com.ecrops.repo.Patt_Mst_NonWebLandRepo;
import com.ecrops.service.DynamicTableService;
import com.ecrops.service.NonWebLandDataEntryService;
import com.ecrops.service.WbMasterService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.service.impl.UnsdownloadDetailsServiceImpl;
import com.ecrops.util.ECropUtility;

@Controller
public class UnsurveyedAndUnsetteldController {
	@Autowired
	private NonWebLandData cr_booking_nwb;

	@Autowired
	private UnsdownloadDetailsServiceImpl unsdownloadDetailsServiceImpl;
	
	

	@Autowired
	private NonWebLandRepo nonWebLandRepo;

	@Autowired
	private DynamicTableService dynamicTableService;
	
	@Autowired
	private Unsurveyed_UnsettledDdetEntity unsurveyed_UnsettledDdetEntity;
	@Autowired
	WbMasterService wbMasterService;

	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;

	@Autowired
	private Cr_booking_PartitionRepo cr_booking_PartitionRepo;

	@Autowired
	private UnsDownloadDetails unsDownloadDetails;

	@GetMapping("/unsurveyed")
	public String unsurvey(HttpSession httpSession, Model model) {
		List<ActiveSeason> crandseason = activeSeasonService.listAll();
		
		
		int dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
		System.out.println("dcode--->"+dcode);
		int mcode = Integer.parseInt((String) httpSession.getAttribute("mcode"));
		System.out.println("mcode--->"+mcode);
		
		model.addAttribute("unsurveydDataDto", new UnsurveydDataDto());
		List<WbMaster> village = wbMasterService.findUnsurveyedVilageList(dcode, mcode);
		model.addAttribute("village", village);
		model.addAttribute("crandseason", crandseason);
		return "unsurveyeddata";
	}

	@PostMapping(path = "/UnsurveyedSearch")

	public String unsurveySearch(@Valid @ModelAttribute("unsurveydDataDto") UnsurveydDataDto unsurveydDataDto,
			BindingResult bindingResult, Model model, HttpSession httpSession, Cultivator cultivator,@RequestParam(value="selectedVillageCode",required=false) String selectedVillageCode) {
		String surveyno = unsurveydDataDto.getSurvyNo();
		List<ActiveSeason> crandseason = activeSeasonService.listAll();
		//String CURRENT_SEASON = (String) httpSession.getAttribute("CURRENT_SEASON");
		int dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
		int mcode = Integer.parseInt((String) httpSession.getAttribute("mcode"));
		Integer wbdcode = (Integer) httpSession.getAttribute("wbdcode");
		String cr_season = (String) httpSession.getAttribute("seasonActive");
		
		Integer cropyear = (Integer) httpSession.getAttribute("ACTIVEYEAR");
		Integer activeYear = (Integer) httpSession.getAttribute("ACTIVEYEAR");
		
	
		cultivator.setCr_year(ECropUtility.sessionData(httpSession).getCropYear());
		cultivator.setCr_season(ECropUtility.sessionData(httpSession).getCurrentSeason());
		
		String partKey=cr_season+wbdcode+cropyear;
		

		String tab ="cr_booking_partition_" + partKey;
		if (activeYear.equals(cropyear)) {
			tab = "ecrop" + activeYear + "." + tab;

		}
		Integer wbvcode = (Integer) httpSession.getAttribute("wbvcode");
		List<WbMaster> village = wbMasterService.findUnsurveyedVilageList(dcode, mcode);
		model.addAttribute("village", village);
		model.addAttribute("selectedVillageCode",selectedVillageCode);
		model.addAttribute("crandseason", crandseason);
		if (bindingResult.hasErrors()) {
			System.out.println("bindig result called");
			return "unsurveyeddata";
		} else {
			List<Cr_BookingEntity> list = dynamicTableService.getEntitiesFromDynamicTable(tab, wbvcode, surveyno);
			if (list.isEmpty()) {
				model.addAttribute("unsetteled_UnsurveyedDto", new Unsetteled_UnsurveyedDto());
				return "settledUnsettledEntry";
			}
		}
		return "settledUnsettledEntry";

	}

	@PostMapping(path = "/saveUnsurveyedData")
	public String postdata(
			@Valid @ModelAttribute("unsetteled_UnsurveyedDto") Unsetteled_UnsurveyedDto unsetteled_UnsurveyedDto,
			BindingResult bindingResult, Model model, HttpSession httpSession,
			@RequestParam("cultfarmerName") String cultfarmerName,
			@RequestParam("cultfatherName") String cultfatherName,
			@RequestParam(value = "totext", required = false) Double totext,
			@RequestParam(value = "cultext", required = false) Double cultext,
			@RequestParam("farmerUid") String farmerUid, @RequestParam("objGender") String objGender,
			@RequestParam(value = "objMobileno", required = false) Long objMobileno,
			@RequestParam("objcat") String objcat, @RequestParam("surveyNo") String surveyNo, Cultivator cultivator,
			HttpServletRequest httpServletRequest,@RequestParam(value="selectedVillageCode",required=false) Integer selectedVillageCode,RedirectAttributes  redirectAttributes) {
		String ipaddress = httpServletRequest.getRemoteAddr();
		Long mobileNo = (objMobileno);
//		String CURRENT_SEASON = (String) httpSession.getAttribute("CURRENT_SEASON");
//		System.out.println("CURRENT_SEASON" + CURRENT_SEASON);
		int dcode = Integer.parseInt((String) httpSession.getAttribute("dcode"));
		int mcode = Integer.parseInt((String) httpSession.getAttribute("mcode"));
		Integer wbdcode = (Integer) httpSession.getAttribute("wbdcode");
		//String cr_season = (String) httpSession.getAttribute("CURRENT_SEASON");
		//Integer cropyear = (Integer) httpSession.getAttribute("CROP_YEAR");
		String cr_season = (String) httpSession.getAttribute("seasonActive");
		Integer cropyear = (Integer) httpSession.getAttribute("ACTIVEYEAR");
		Integer wbmcode = (Integer) httpSession.getAttribute("wbmcode");
		//Integer wbvcode = (Integer) httpSession.getAttribute("wbvcode");
		Integer wbvcode = selectedVillageCode;
		//String partKey = CURRENT_SEASON + ECropUtility.getDcode(ECropUtility.sessionData(httpSession).getWbdcode()) + cropyear;
		String partKey=cr_season+wbdcode+cropyear;
		
		if (bindingResult.hasErrors()) {
			return "settledUnsettledEntry";
		} else {
			model.addAttribute("unsetteled_UnsurveyedDto", new Unsetteled_UnsurveyedDto());
		}

		try {
//			unsdownloadDetailsServiceImpl.saveUnsurveyed_UnsettledDdet(unsurveyed_UnsettledDdetEntity, dcode, mcode,
//					mobileNo, wbdcode, wbmcode, cropyear, cr_season, farmerUid, cultfarmerName, cultfatherName,
//					surveyNo, totext, cultext, objGender, wbvcode, objcat);

			unsdownloadDetailsServiceImpl.saveCr_booking_nwb(cr_booking_nwb, wbdcode, wbvcode, wbmcode, partKey,
					surveyNo, farmerUid, cr_season, objGender, totext, mobileNo, cultfarmerName, cultfatherName,cultext,cropyear);
			// NO OF RECORDS NEEDS TO BE CHANGED

		unsdownloadDetailsServiceImpl.saveUnsDownloadDetails(unsDownloadDetails, cropyear, ipaddress, mcode,
					partKey, mcode, cr_season,wbvcode);
			System.out.println("data inserted");
	
			model.addAttribute("message", "Data successfully added");
			return "unsurveyeddata"; 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("data is not inserted");
		}
		return "unsurveyeddata";
	}

}
