package com.ecrops.controller;

import com.ecrops.dto.crop.request.WeblandPullRequest;

import com.ecrops.dto.crop.response.CropYear;
//import com.ecrops.dto.crop.response.VillageData;
import com.ecrops.dto.crop.response.WeblandPullResponse;
import com.ecrops.repo.crop.WeblandCropRepository;
import com.ecrops.repo.crop.WeblandCropServiceRepo;
//import com.ecrops.repo.crop.WeblandVillageRepository;

import com.ecrops.service.impl.WbMasterServiceCcrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WeblandCropController {

	@Autowired
	private WeblandCropServiceRepo serviceRepo;

	@Autowired
	private WeblandCropRepository cropRepository;

	@Autowired
	private WbMasterServiceCcrc wbMasterServiceCcrc;

	// Handle requests to the weblandCropEntry page
	@GetMapping("/weblandCropEntry")
	public String webland(Model model, HttpSession httpSession) {
		String userId = (String) httpSession.getAttribute("userid");
		List<CropYear> activeSeasons = cropRepository.getCropYear();
		model.addAttribute("activeSeasons", activeSeasons);
		model.addAttribute("weblandPullRequest", new WeblandPullRequest());
		return "WeblandCropEntry";
	}

	// Handle the form submission for fetching webland details
	@PostMapping("/fetch-crop-data")
	public String fetchWeblandDetails(@ModelAttribute WeblandPullRequest dto, Model model, HttpSession session,
			HttpServletRequest request) {

		try {

			// Extract user information from the session
			String userId = (String) session.getAttribute("userid");
			int wbdcode = (int) session.getAttribute("wbdcode");
			int wbmcode = (int) session.getAttribute("wbmcode");
			String sesdcode = (String) session.getAttribute("dcode");
			String sesmcode = (String) session.getAttribute("mcode");


			// Extract crop year information from the form
			String seasonWithYear = dto.getCropyear();
			String season = seasonWithYear.split("@")[0];
			int cropYear = Integer.parseInt(seasonWithYear.split("@")[1]);

			// Extract village information from the form
			String villageString = dto.getVillage().replaceAll(",", "");
			if (villageString.isEmpty()) {
				throw new IllegalArgumentException("Village number is empty");
			}
			int villageCode = Integer.parseInt(villageString);
			String ipAddress = request.getRemoteAddr();

			String villageName = wbMasterServiceCcrc.getVillageNameByCode(villageCode);

			// Add village name to the model
			model.addAttribute("selectedVillageName", villageName);

			WeblandPullResponse pullResponse = serviceRepo.checkInsertAndViewWeblandCropDetails(userId, ipAddress,
					String.valueOf(wbdcode),wbmcode, villageCode, season, cropYear,Integer.parseInt(sesdcode),Integer.parseInt(sesmcode));

			// System.out.println("is calling------<<<<>>>>>");
			// Add attributes to the model for rendering in the view
			model.addAttribute("message", pullResponse.getMessage());
			model.addAttribute("cropDetails", pullResponse.getCropData());
			model.addAttribute("selectedCropYear", season);
			model.addAttribute("selectedVillageCode", villageCode);
			model.addAttribute("Size", pullResponse.getCropData().size());

//			// retrieved crop data
			System.out.println("Size : " + pullResponse.getCropData().size());
			System.out.println("******");
			System.out.println("cropYear:-------------->" + cropYear);
			System.out.println("******");
			System.out.println("selectedSeason:-------------->" + season);
			System.out.println("******");
			System.out.println("selectedVillageCode:-------------->" + villageCode);
			System.out.println("******");
			System.out.println("selectedVillageName:-------------->" + villageName);

			// Redirect to the selected data page
			return "selected-data";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error processing the request");
			return "WeblandCropEntry";
		}
	}
}
