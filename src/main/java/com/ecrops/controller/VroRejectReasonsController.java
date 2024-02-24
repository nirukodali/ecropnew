package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.AuthenticationRequest;
import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.VroRejectDropdownEntity;
import com.ecrops.entity.VroRejectReasonsEntity;
import com.ecrops.repo.SaveVroRejectReasons;
import com.ecrops.repo.UpdateVroRejectReasons;
import com.ecrops.repo.VroRejectDropdownRepo;
import com.ecrops.repo.VroRejectReasonsRepoImpl;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;


@Controller
public class VroRejectReasonsController {
	
	@Autowired 
	private VroRejectReasonsRepoImpl vroRejectReasonsRepoImpl;
	

	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;


	@Autowired
	private VroRejectDropdownRepo vroRejectDropdownRepo;
	
	@Autowired
	private SaveVroRejectReasons saveVroRejectReasons;
	
	@Autowired
	private UpdateVroRejectReasons updateVroRejectReasons;

	@GetMapping("/VroRejectReasons") 
	public String showData(@ModelAttribute AuthenticationRequest authenticationRequest, Model model, HttpSession httpSession) {
		
		int vscode = (Integer) httpSession.getAttribute("wbvcode");
		List<ActiveSeason> activeSeason = activeSeasonService.listAll();
		
		String season = activeSeason.get(0).getSeason();
		Integer cropYear =  (Integer) activeSeason.get(0).getCropyear();
//		
//		System.out.println("season---> " + season);
//		System.out.println("cropYear---> " + cropYear);
//		System.out.println("vscode---> " + vscode);

		
		Integer activeYear = cropYear;        
		Integer wbdcodeInt = (Integer) httpSession.getAttribute("wbdcode");
		String wbdcode = wbdcodeInt.toString();
//		System.out.println("wbedcode---> " + wbdcode);

		String partitionName = "cr_crop_det_new_v_";
	    if(wbdcodeInt <= 9) {
	        partitionName = partitionName + season + "0" + wbdcode + cropYear;
	    } else {
	        partitionName = partitionName + season + wbdcode + cropYear;
	    }

	    if (activeYear == cropYear) {
	        partitionName = "ecrop" + activeYear + "." + partitionName;
	    }
	    
	    List<VroRejectReasonsEntity> dataList=vroRejectReasonsRepoImpl.findDynamicTableData(vscode, partitionName);
        List<VroRejectDropdownEntity> rejectionList = vroRejectDropdownRepo.findByCode();
        model.addAttribute("dataList", dataList);
        model.addAttribute("rejectionList",rejectionList);
        
	    return "VroRejectReasons"; 
	}
	   
	   @PostMapping(path = "/saveSelection", consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		public String saveSelection(HttpServletRequest httpServletRequest, HttpSession httpSession,
				RedirectAttributes redirectAttributes,  Model model,HttpSession session) {

			String bookingIdList = httpServletRequest.getParameter("bookingIdLst");
			String khathaNumberList = httpServletRequest.getParameter("khathaNoLst");			
			String surveyNumberList = httpServletRequest.getParameter("surveyNoLst");			
			String cropCodeList = httpServletRequest.getParameter("cropCodeLst"); 			
			String cropNumber = httpServletRequest.getParameter("cropNumberLst");			
			String varietyCode = httpServletRequest.getParameter("varietyCodeLst");			
			String rejectreason = httpServletRequest.getParameter("selectedItemList");			
			String sownDateLst = httpServletRequest.getParameter("sownDateLst");			
			String clientip = httpServletRequest.getRemoteAddr();			
			System.out.println(httpSession.getAttribute("wbvcode")+"hiii");
			String userid = httpSession.getAttribute("userid").toString();
		
            String sesvcode = httpSession.getAttribute("wbvcode").toString(); 
			String wbldcode = httpSession.getAttribute("wbdcode").toString(); 
			String mandcode = httpSession.getAttribute("mcode").toString();
			
//			String  wbldcode = ECropUtility.sessionData(session).getWbdcode().toString();
//            String sesvcode = ECropUtility.sessionData(session).getWbvcode();            
//            String mandcode = ECropUtility.sessionData(session).getMcode();
            List<ActiveSeason> activeSeason = activeSeasonService.listAll();
    		
    		String season = activeSeason.get(0).getSeason();
    		Integer cropyear =  activeSeason.get(0).getCropyear();
    		Integer activeYear = activeSeason.get(0).getCropyear();

            if (wbldcode.length()==1) {
                wbldcode="0"+wbldcode;
              
           } 
           
           String tableName="VRO_REJ_DETAILS";

           if(activeYear.equals(cropyear)) {
        	   tableName="ecrop"+activeYear+"."+tableName;
        	   }
           
           String  partKey = "";
           partKey = season+wbldcode+cropyear;
           			
		   int savedDetailsCount = saveVroRejectReasons.saveVroRejectReasonsDetails(wbldcode, mandcode, sesvcode, partKey, userid, clientip, 
					 tableName, bookingIdList, cropCodeList, cropNumber, 
					 varietyCode, khathaNumberList, surveyNumberList, sownDateLst, rejectreason);
		
					 
		  int flag = 0;
		  String lowerCaseSeason = season.toLowerCase();
			 
		  if (savedDetailsCount == 0) {
			  flag = 1;
		  }
			 
		  if (flag == 0) {
			  int updateDetails = updateVroRejectReasons.updateVroRejectReasonsDetails(activeYear, cropyear, lowerCaseSeason, wbldcode, sesvcode, 
						 bookingIdList, cropCodeList, cropNumber, varietyCode);
			  
		  }
			          
		  return "VroRejectReasons";
		}
	   
}
