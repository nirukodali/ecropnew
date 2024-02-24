package com.ecrops.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.dto.crop.response.VillageData;
import com.ecrops.repo.crop.WeblandCropRepository;
import com.ecrops.repo.crop.WeblandCropServiceRepo;

@RestController
@RequestMapping("/rest/api/webland-crop")
public class WeblandCropRestController {

	@Autowired
	private WeblandCropServiceRepo ServiceRepo;

	@Autowired
	private WeblandCropRepository cropRepository;

	/*@GetMapping("/data")
	private List<PattadarmastWbEntity> getDataFromDB() {
		return ServiceRepo.getCropDetails(18, 1804012, "K", 2023);
	}

	@GetMapping("/check")
	private boolean checkData() {
		return ServiceRepo.checkRecordIsAvailableInDatabase(1804012, "K", 2023);
	}

	@GetMapping("/crop-year")
	private List<CropYear> getCropYear() {
		return cropRepository.getCropYear();
	}*/

	//akash code below
	
//	@GetMapping("/villages")
//	private List<VillageData> getVillages(@RequestParam("activeSeason") String activeSeason, HttpSession session) {
//
//		int mCode = (Integer) session.getAttribute("mcode");
//		System.out.println("mcode : " + mCode);
//		int activeYear = Integer.parseInt(activeSeason.split("@")[1]);
//		String season = activeSeason.split("@")[0];
//
//		return cropRepository.getVillages(mCode, activeYear, season);
//	}
	
	@GetMapping("/villages")
	private List<VillageData> getVillages(@RequestParam("activeSeason") String activeSeason, HttpSession session) {
	    int mCode = Integer.valueOf((String)session.getAttribute("mcode"));
	    System.out.println("mcode : " + mCode);

	    // Check if activeSeason contains the expected delimiter "@"
	    String[] seasonParts = activeSeason.split("@");
	    if (seasonParts.length != 2) {
	        // Handle the case where the delimiter is not present or not in the expected format
	        // You may throw an exception, log an error, or handle it according to your requirements
	        throw new IllegalArgumentException("Invalid format for activeSeason parameter");
	    }

	    int activeYear = Integer.parseInt(seasonParts[1]);
	    String season = seasonParts[0];

//	   List<VillageData> villages= cropRepository.getVillages(mCode, activeYear, season);
//	   System.out.println("villages:-------->"+villages.toString());
	   
	   List<VillageData> villages = cropRepository.getVillages(mCode, activeYear, season);
	   System.out.println("Villages:");
	   for (VillageData village : villages) {
	       System.out.println("Village code: " + village.getWbvcode() + ", VillageName: " + village.getWbvname());
	   }

	     
	     return villages;
	    
	}


	/*@GetMapping("/all")
	public List<PattadarmastWbEntity> getAllData(@RequestParam("vcode") int vcode){
		return ServiceRepo.getCropDetails(18,vcode,"K",2023);
	}*/
}
