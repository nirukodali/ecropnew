package com.ecrops.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.entity.RedownloadReasons;
import com.ecrops.projection.DeviceProjection;
import com.ecrops.repo.Devicedelrepo;
import com.ecrops.repo.Devicesentryrepo;
import com.ecrops.repo.Reasons;
import com.ecrops.util.PartitoinsMethods;
import com.ecrops.util.WbVillageModel;

@RestController
@RequestMapping("/util")
public class RestControllers {

	@Autowired
	private Devicesentryrepo deviceRepo;
	
	@Autowired
	PartitoinsMethods partitoinsmethods;
	
	@Autowired
	private Reasons reasons;
	
	@Autowired
	private Devicedelrepo devicedelrepo;
	

	
	public RestControllers() { 

	}

	@GetMapping("/getFirstDeviceVerify")
	public List<DeviceProjection> getImeiVerify(@RequestParam("vcode") String vcode) {
		List<DeviceProjection> deviceEntitiesList = deviceRepo.getVcode(Integer.parseInt(vcode));
		return deviceEntitiesList;
	}

	@GetMapping("/getVillAndMandal")
	public List<WbVillageModel> getVillAndMandal(@RequestParam("distcode") String distcode,
			@RequestParam("mandcode") String mandcode, @RequestParam("sescrpyear") String sescrpyear) {
		List<WbVillageModel> list = partitoinsmethods.getVillAndMandal(distcode, mandcode, sescrpyear);
		return list;
	}
	
	@GetMapping("/getReasons")
	public List<RedownloadReasons> getReasons() {
		List<RedownloadReasons> reaso=reasons.getreasons();
		return reaso;
	}
	
	@GetMapping("/getdevice")
	public List<DeviceProjection> getdevice(String vcode) {
		List<DeviceProjection> list = devicedelrepo.getdevice(Integer.parseInt(vcode));
		return list;
		
	}

	
}
