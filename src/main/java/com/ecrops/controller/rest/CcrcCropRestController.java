package com.ecrops.controller.rest;

import com.ecrops.dto.crop.response.VillageData;
import com.ecrops.dto.crop.response.VillageDataCcrc;
import com.ecrops.repo.crop.CcrcCropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/api/Ccrc-Crop")
public class CcrcCropRestController {

    @Autowired
    private CcrcCropRepository cropRepository;
        
    
//    @GetMapping("/villages")
//	private List<VillageDataCcrc> getVillages(@RequestParam("activeSeason") String activeSeason, HttpSession session) {		
//		Integer mCode = (Integer) session.getAttribute("mcode");
//		if (mCode != null) {
//		    System.out.println("mcode : " + mCode);
//		    int activeYear = Integer.parseInt(activeSeason.split("@")[1]);
//		    String season = activeSeason.split("@")[0];
//
//		    
//		    List<VillageDataCcrc> villages = cropRepository.getVillages(mCode, activeYear, season);
//			   System.out.println("Villages:");
//			   for (VillageDataCcrc village : villages) {
//			       System.out.println("Village code: " + village.getWbvcode() + ", VillageName: " + village.getWbvname());
//			   }
//		    return villages;
//		} else {
//		    		    return Collections.emptyList();
//		}
//}
    
    
    
    @GetMapping("/villages")
	private List<VillageDataCcrc> getVillages(@RequestParam("activeSeason") String activeSeason, HttpSession session) {
    	int mCode = Integer.valueOf((String)session.getAttribute("mcode"));
	    System.out.println("mcode : " + mCode);

	    // Check if activeSeason contains the expected delimiter "@"
	    String[] seasonParts = activeSeason.split("@");
	    String season = seasonParts[0];
	    int activeYear = Integer.parseInt(seasonParts[1]);


	    
	    List<VillageDataCcrc> villages = cropRepository.getVillages(mCode,activeYear,season);
//		   System.out.println("Villages:");
//		   for (VillageDataCcrc village : villages) {
//		       System.out.println("Village code: " + village.getWbvcode() + ", VillageName: " + village.getWbvname());
//		   }		     
		     return villages;
		    
	    
	}

    
    
    
    
}
