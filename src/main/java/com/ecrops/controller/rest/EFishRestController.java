package com.ecrops.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.dto.crop.response.VillageDataCcrc;
import com.ecrops.repo.crop.EfishCropRepository;

@RestController
@RequestMapping("/rest/api")
public class EFishRestController {

	@Autowired
	private EfishCropRepository efishCropRepository;

	@GetMapping("/efish/villages")
	private List<VillageDataCcrc> getVillages(@RequestParam("activeSeason") String activeSeason, HttpSession session) {
		
	    String mCode = (String) session.getAttribute("mcode");
	   
	    try {
	    	
	    	String[] seasonParts = activeSeason.split("@");
		    String season = seasonParts[0];
		    int activeYear = Integer.parseInt(seasonParts[1]);
	        List<VillageDataCcrc> villages = efishCropRepository.getVillages(Integer.parseInt(mCode),activeYear,season);
	        return villages;
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid format for activeSeason parameter", e);
	    }
	}
}
