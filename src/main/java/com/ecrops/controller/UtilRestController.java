package com.ecrops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.config.RegularExpressionclassMethod;
import com.ecrops.entity.CropwiseExtBookedMaoIntf;
import com.ecrops.entity.StateWiseCropIrriAbsIntf;
import com.ecrops.entity.SuperCheckRecordsAlloted;
import com.ecrops.entity.SuperChkReport;
import com.ecrops.entity.VAADetails;
import com.ecrops.entity.VillSecListMaoIntf;
import com.ecrops.model.RequestModel;
import com.ecrops.partitions.CropwiseExtBookedMaoIntfPartition;
import com.ecrops.partitions.CropwiseExtVillPartition;
import com.ecrops.partitions.SuperCheckRecordsAllotedPartition;
import com.ecrops.partitions.SuperChkReportPartition;
import com.ecrops.projections.MasterProjections;
import com.ecrops.repo.DropdownsRepo;
import com.ecrops.repo.StateWiseCropIrriAbsIntfRepo;
import com.ecrops.repo.VAADetailsRepo;
import com.ecrops.repo.VillSecListMaoIntfRepo;

@RestController

@RequestMapping("/util")
public class UtilRestController {
	@Autowired
	VillSecListMaoIntfRepo villSecListMaoIntfRepo;
	@Autowired
	VAADetailsRepo vAADetailsRepo;
	@Autowired
	StateWiseCropIrriAbsIntfRepo stateWiseCropIrriAbsIntfRepo;

//<------------DROP-DOWND-------------->//
	@Autowired
	DropdownsRepo dropdownsRepo;

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

//===============getWaterSorce=====================//
	@GetMapping("/getwatersrc")
	public List<MasterProjections> getWatsrc() {
		List<MasterProjections> list = dropdownsRepo.getWsrcdesc();
		System.out.println("=======list==========" + list.size());
		return list;
	}

	@GetMapping("/villseclistt")
	List<VillSecListMaoIntf> getList(@RequestParam("dcode") String dcode, @RequestParam("mcode") String mcode) {

//		String[] season = cropyear.split("@");
//		String seasonType = season[0];
//		Integer seasonYear = Integer.parseInt(season[1]);
//		//System.out.println("seasonType=>" + seasonType);
//		//System.out.println("seasonYear=>" + seasonYear);

		Integer ddcode = Integer.parseInt(dcode);
		Integer mmcode = Integer.parseInt(mcode);

		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();

		System.out.println("dcode------------->" + ddcode);

		boolean val = regexpressionmethod.districtCode(ddcode.toString());
		boolean val2 = regexpressionmethod.year(mmcode.toString());

		System.out.println("val-------------->" + val);
		System.out.println("val2-------------->" + val2);

		if (val && val2) {
			List<VillSecListMaoIntf> listt = villSecListMaoIntfRepo.getVillsecList(ddcode, mmcode);

			System.out.println("list size=>" + listt.size());
			System.out.println("list =>" + listt.toString());
			return listt;
		}

		return null;
	}

//--------------------------------Rep_VaaDetails-----------------------------------//

	@GetMapping("/vaadetails1")
	List<VAADetails> getVAADetails(@RequestParam("mcode") String mcode) {
		String mmcode = (String) mcode;
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean val2 = regexpressionmethod.year(mmcode.toString());
		System.out.println("val2-------------->" + val2);

		if (val2) {
			List<VAADetails> listt = vAADetailsRepo.getVaaDet(mmcode);
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

		List<SuperCheckRecordsAlloted> spckr = superCheckRecordsAllotedPartition.getSupchkRds(requestModel.getWbdcode(),
				requestModel.getWbmcode(), requestModel.getUserid(), requestModel.getCropyear());
		System.out.println("details===================>" + spckr.size());
		return spckr;
	}
	// =========================SuperCheck Report===============================//

	@Autowired
	SuperChkReportPartition superChkReportPartition;

	@PostMapping("/supcheckReport")
	List<SuperChkReport> getSupChk(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());

		List<SuperChkReport> supkr = superChkReportPartition.getSupchkRep(requestModel.getWbdcode(),
				requestModel.getWbmcode(), requestModel.getUserid(), requestModel.getCropyear(),
				requestModel.getActiveyear());
		System.out.println("details===================>" + supkr.size());
		return supkr;
	}
//=======REP_CropwiseExtBookedMaoIntf============================>

	@Autowired
	CropwiseExtBookedMaoIntfPartition cropwiseExtBookedMaoIntfPartition;

	@PostMapping("/crpwiseext")
	List<CropwiseExtBookedMaoIntf> getCrpWiseExt(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());

		List<CropwiseExtBookedMaoIntf> crpext = cropwiseExtBookedMaoIntfPartition.getCrpExt(requestModel.getDcode(),
				requestModel.getMcode(), requestModel.getCrop(), requestModel.getCropyear(),
				requestModel.getCropgrpid());
		System.out.println("details===================>" + crpext.size());

		return crpext;
	}

	@Autowired
	CropwiseExtVillPartition cropwiseExtVillPartition;

	@PostMapping("/crpwiseextvill")
	List<CropwiseExtBookedMaoIntf> getCrpWiseExtVill(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());

		List<CropwiseExtBookedMaoIntf> crpext = cropwiseExtVillPartition.getCrpExt1(requestModel.getDcode(),
				requestModel.getMcode(), requestModel.getCrop(), requestModel.getCropyear(),
				requestModel.getCropgrpid());
		System.out.println("details===================>" + crpext.size());

		return crpext;
	}

	// =============================StateWiseCropIrriAbsIntf===============================//

	@PostMapping("statewsrc")
	List<StateWiseCropIrriAbsIntf> getStateWiseCropWrsc(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel============>" + requestModel.toString());


		String[] cseason = requestModel.getCropyear().split("@");
		String season = cseason[0];
		Integer Year = Integer.parseInt(cseason[1]);
		

		List<StateWiseCropIrriAbsIntf> wsrcv = null;

		if (requestModel.getRole().equalsIgnoreCase("2") || requestModel.getRole().equalsIgnoreCase("5")
				|| requestModel.getRole().equalsIgnoreCase("42") || requestModel.getRole().equalsIgnoreCase("22")
				|| requestModel.getRole().equalsIgnoreCase("43")) {

			if (requestModel.getCrop().trim().equals("")) {
				wsrcv= stateWiseCropIrriAbsIntfRepo.getWsrcVill(Integer.parseInt(requestModel.getMcode()), 
						Integer.parseInt(requestModel.getCropgrpid()),
						  Integer.parseInt(requestModel.getWsrcid()),
						  Year, 
						  season);
			} else {
				wsrcv= stateWiseCropIrriAbsIntfRepo.getWsrcVill1(Integer.parseInt(requestModel.
						 getMcode()), Integer.parseInt(requestModel.getCropgrpid()),
						 Integer.parseInt(requestModel.getCrop()),
						   Integer.parseInt(requestModel.getWsrcid()),
						   Year,
						   season);
			}

		}
		 if(requestModel.getRole().equalsIgnoreCase("11") || requestModel.getRole().equalsIgnoreCase("17")
					|| requestModel.getRole().equalsIgnoreCase("18") || requestModel.getRole().equalsIgnoreCase("21")){
				  
				  if(requestModel.getCrop().trim().equals("")) { wsrcv=
				  stateWiseCropIrriAbsIntfRepo.getWsrcDist(Integer.parseInt(requestModel.
				  getDcode()), Integer.parseInt(requestModel.getCropgrpid()),
				  Integer.parseInt(requestModel.getWsrcid()),
				  Year,
				  season);
				  
				  }else if(!requestModel.getCrop().trim().equals("")) { wsrcv=
				  stateWiseCropIrriAbsIntfRepo.getWsrcDist1(Integer.parseInt(requestModel.
				  getDcode()), Integer.parseInt(requestModel.getCropgrpid()),
				  Integer.parseInt(requestModel.getCrop()),
				  Integer.parseInt(requestModel.getWsrcid()),
				  Year, 
				  season);
				  
				  
				  }
				  
				  }
		 
		 if(requestModel.getRole().equalsIgnoreCase("9") || requestModel.getRole().equalsIgnoreCase("44")
					|| requestModel.getRole().equalsIgnoreCase("45") || requestModel.getRole().equalsIgnoreCase("19")
					|| requestModel.getRole().equalsIgnoreCase("20")){
				  
				  if(requestModel.getCrop().trim().equals("")) { wsrcv=
				  stateWiseCropIrriAbsIntfRepo.getWsrcMand(Integer.parseInt(requestModel.
				  getDcode()), Integer.parseInt(requestModel.getCropgrpid()),
				  Integer.parseInt(requestModel.getWsrcid()),
				  Year,season);
				  
				  }else if(!requestModel.getCrop().trim().equals("")) { wsrcv=
				  stateWiseCropIrriAbsIntfRepo.getWsrcMand1(Integer.parseInt(requestModel.
				  getDcode()), Integer.parseInt(requestModel.getCropgrpid()),
				  Integer.parseInt(requestModel.getCrop()),
				  Integer.parseInt(requestModel.getWsrcid()),
				  Year, season);
				  }
				 }
	System.out.println("list=============>"+wsrcv.size());
		return wsrcv;
	}
}