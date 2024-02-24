package com.ecrops.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.config.RegularExpressionclassMethod;
import com.ecrops.entity.SuperCheckRecordsAlloted;
import com.ecrops.entity.SuperChkReport;
import com.ecrops.entity.VAADetails;
import com.ecrops.entity.VillSecListMaoIntf;
import com.ecrops.model.RequestModel;
import com.ecrops.partitions.SuperCheckRecordsAllotedPartition;
import com.ecrops.partitions.SuperChkReportPartition;
import com.ecrops.projections.MasterProjections;
import com.ecrops.repo.DropdownsRepo;
import com.ecrops.repo.VAADetailsRepo;
import com.ecrops.repo.VillSecListMaoIntfRepo;

@RestController

@RequestMapping("/util")
public class UtilRestController {
@Autowired VillSecListMaoIntfRepo villSecListMaoIntfRepo;
@Autowired VAADetailsRepo vAADetailsRepo;
	

//<------------DROP-DOWND-------------->//
@Autowired DropdownsRepo dropdownsRepo;
@GetMapping("/getAllSeason")
public List<MasterProjections> getAllSeasonn() {
	List<MasterProjections> list = dropdownsRepo.getAllSeason();
	return list;
}

@GetMapping("/getAllCrop")
public List<MasterProjections> getAllCrop() {
	List<MasterProjections> list = dropdownsRepo.getAllCrops();
	return list;
}

@GetMapping("/getAllMandals")
public List<MasterProjections> getMandals(Integer dcode) {
	List<MasterProjections> list = dropdownsRepo.getAllMandals(dcode);
	return list;
}

//**************************************************//Villages//*************************************************
@GetMapping("/getAllVillages")
public List<MasterProjections> getVillages(Integer dcode, Integer mcode) {
	System.out.println("dcode=>" + dcode);
	System.out.println("mcode=>" + mcode);
	List<MasterProjections> list = dropdownsRepo.getAllVillages(dcode, mcode);
	return list;
}
//===========================CropGroups=================================//

@GetMapping("/getCropGroup")
public List<MasterProjections> getCropGroup() {
	System.out.println("=======getCropGroup==========");
	List<MasterProjections> list = dropdownsRepo.getAllCropGrp();
	System.out.println("=======list==========" + list.size());
	return list;
}

// ===============getAllCrpGrp=====================//
@GetMapping("/getCropGroupid")
public List<MasterProjections> getCropGoupidd(String grpcode) {
	List<MasterProjections> list = dropdownsRepo.getAllCrpGrpid(Integer.parseInt(grpcode));
	System.out.println("=======list==========" + list.size());
	return list;
}


	@GetMapping("/villseclistt")
	List<VillSecListMaoIntf> getList(@RequestParam ("dcode")String dcode, @RequestParam ("mcode")String mcode) {

//		String[] season = cropyear.split("@");
//		String seasonType = season[0];
//		Integer seasonYear = Integer.parseInt(season[1]);
//		//System.out.println("seasonType=>" + seasonType);
//		//System.out.println("seasonYear=>" + seasonYear);

		Integer ddcode = Integer.parseInt(dcode);
		Integer mmcode = Integer.parseInt(mcode);

	

		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

		System.out.println("dcode------------->"+ddcode);
		
	    boolean val= regexpressionmethod.districtCode(ddcode.toString());
		boolean val2= regexpressionmethod.year(mmcode.toString());
		
	System.out.println("val-------------->"+val);
	System.out.println("val2-------------->"+val2);
	
	if(val && val2 ) {
		List<VillSecListMaoIntf> listt = villSecListMaoIntfRepo.getVillsecList(ddcode, mmcode);
		
		System.out.println("list size=>" + listt.size());
		System.out.println("list =>" + listt.toString());
		return listt;
	   }
	
	return null; 
	}



//--------------------------------Rep_VaaDetails-----------------------------------//

@GetMapping("/vaadetails1")
List<VAADetails> getVAADetails(@RequestParam ("mcode")String mcode) {
	String mmcode = (String)mcode;
	RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();
	boolean val2= regexpressionmethod.year(mmcode.toString());
System.out.println("val2-------------->"+val2);

if( val2 ) {
	List<VAADetails> listt = vAADetailsRepo.getVaaDet( mmcode);
	System.out.println("list size=>" + listt.size());
	System.out.println("list =>" + listt.toString());
	return listt;
   }
return null; 
}
//================================ SperCheck Allotment Records==========================================//
	@Autowired
	private SuperCheckRecordsAllotedPartition superCheckRecordsAllotedPartition;

	@PostMapping("/supchkalltrecrds")
	List<SuperCheckRecordsAlloted> getSupChkR(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		
		List<SuperCheckRecordsAlloted> spckr = superCheckRecordsAllotedPartition.getSupchkRds(
				requestModel.getWbdcode(),
				requestModel.getWbmcode(), 
				requestModel.getUserid(), 
				requestModel.getCropyear());
		System.out.println("details===================>" + spckr.size());
		return spckr;
	}
	//=========================SuperCheck Report===============================//

		@Autowired
		SuperChkReportPartition superChkReportPartition;

		@PostMapping("/supcheckReport")
		List<SuperChkReport> getSupChk(@RequestBody RequestModel requestModel) {
			System.out.println("requestModel=>" + requestModel.toString());

			List<SuperChkReport> supkr = superChkReportPartition.getSupchkRep(requestModel.getWbdcode(),
					requestModel.getWbmcode(), requestModel.getUserid(), requestModel.getCropyear());
			System.out.println("details===================>" + supkr.size());
			return supkr;
		}

}
