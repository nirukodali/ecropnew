
package com.ecrops.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.projection.EmployeeName;
import com.ecrops.projection.WbVillageMastProjection;
import com.ecrops.repo.CrEmployeeProfileRepository;
import com.ecrops.repo.WbvillagesRepository;
import com.ecrops.service.AllocationService;
import com.ecrops.service.SelectionOfSurveyNoSurvice;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	

	@Autowired
	private AllocationService employeeService;
	

	@Autowired
	private WbvillagesRepository wbVillageRepository;
	
	@Autowired
	private CrEmployeeProfileRepository empRepo;
	
	@Autowired
	private SelectionOfSurveyNoSurvice   selectionService;

	@GetMapping("/getRevenueVillage")
	public List<WbVillageMastProjection> getRevenueVillage(@RequestParam("rbkCode") Integer rbkCode) {
		System.out.println("rbkcode--->"+rbkCode);
		List<WbVillageMastProjection> entities = new ArrayList<>();
		try {
			entities = wbVillageRepository.getWebLandDet(rbkCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;

	
	}
	
	
	@GetMapping("/getEmployeeByRevenue")
	public List<EmployeeName> getEmployeeByRevenue(HttpSession httpSession, @RequestParam("rbkCode") Integer rbkCode) {
        String district = (String) httpSession.getAttribute("dcode");
          System.out.println("district"+district);
		String mandal = (String) httpSession.getAttribute("mcode");
		  System.out.println("mandal"+mandal);
		List<WbVillageMastProjection> webLandDetails = employeeService.getWebLandDetails(Integer.parseInt(district),
				Integer.parseInt(mandal));
		String wbdcode2 = webLandDetails.get(0).getWbdcode();
		String wbmcode2 = webLandDetails.get(0).getWbmcode();
		System.out.println("wbdcode2"+wbdcode2);
		System.out.println("wbmcode2"+wbmcode2);
		System.out.println("rbkcode"+rbkCode);
		List<EmployeeName> entities = new ArrayList<>();
		try {
			

			entities = empRepo.getEmpByRevenue(rbkCode, Integer.parseInt(wbdcode2), Integer.parseInt(wbmcode2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
 }
//	 @PostMapping("/getDetails")
//	    public String getDetails(HttpServletRequest request,HttpSession session) {
//		    String data = selectionService.getData(request,session);
//	        return "your-view-name"; // Return the view name or redirect URL
//	    }
}
