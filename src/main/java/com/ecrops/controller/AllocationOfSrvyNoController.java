package com.ecrops.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.dto.AllocValidation;
import com.ecrops.dto.PattadharPojo;
import com.ecrops.entity.CrEmpProfileEntity;
import com.ecrops.entity.DistrictCsEntity;
import com.ecrops.entity.MandalCsEntity;
import com.ecrops.entity.VillageCsEntity;
import com.ecrops.entity.WbVillageMastEntity;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.repo.ActiveSeasonRepository;
import com.ecrops.repo.DatabaseRepo;
import com.ecrops.repo.DistrictCsRepository;
import com.ecrops.repo.MandalCsRepository;
import com.ecrops.repo.PattadarDetailsRepository;
import com.ecrops.repo.VillSectionRepository;
import com.ecrops.repo.VillagesCsRepository;
import com.ecrops.repo.WbvillagesRepository;
import com.ecrops.service.AllocationService;

@Controller
public class AllocationOfSrvyNoController {

	@Autowired
	private AllocationService employeeService; 

	@Autowired
	private DatabaseRepo repo;

	@Autowired
	private PattadarDetailsRepository detailsRepository;

	@Autowired
	private VillagesCsRepository villageyrepo;

	@Autowired
	private DistrictCsRepository districtRepo;

	@Autowired
	private MandalCsRepository mandalRepo;

	@Autowired
	private WbvillagesRepository repos;

	@Autowired
	private ActiveSeasonRepository cropYearRepo;

	@Autowired
	private VillSectionRepository villSecRepo;

	@GetMapping("/allocOfSurveyNo")
	public String allocOfSurveyNo(@ModelAttribute("allocSurvey") CrEmpProfileEntity employeename, Model model,
			HttpSession httpSession, HttpServletRequest httpServletRequest) {
		String mcode = (String) httpSession.getAttribute("mcode");

		List<ActiveSeasonProjection> activeSeason = cropYearRepo.getActiveSeason();

		List<ActiveSeasonProjection> rbk = villSecRepo.getRbk(Integer.parseInt(mcode));

		model.addAttribute("activeseason", activeSeason);
		model.addAttribute("rbk", rbk);
		model.addAttribute("validation", new AllocValidation());

		return "AllocOfSurveyNo";
	}

	@PostMapping("/getPattaDetails")
	public String pattadharProfile(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) {

		String dcode = (String) httpSession.getAttribute("dcode");
		String mcode = (String) httpSession.getAttribute("mcode");
		String userid = (String) httpSession.getAttribute("userid");

		String cropyear = "", season = "", empCode = "";
		String qry = "", vcode = "", wbdcode = "", rbkcode = "";
		empCode = httpServletRequest.getParameter("employee");
		vcode = httpServletRequest.getParameter("village");
		rbkcode = httpServletRequest.getParameter("rbk");
		wbdcode = repo.getWbdCode(dcode);

		String crpses = httpServletRequest.getParameter("crYear");
		cropyear = crpses.split("@")[1];
		season = crpses.split("@")[0];
		String activeYear = cropyear;
		String crbooknwb = "cr_booking_nwb";
		String efishTab = "cr_details_efish";
		String partitionName = "pattadarmast_wb_partition_";
		String rbksrnoMapTab = "rbk_surveyno_mapping_";
		String partKey = "";

		if (Integer.parseInt(wbdcode) <= 9) {
			partitionName = partitionName + season + "0" + wbdcode + cropyear;
			rbksrnoMapTab = rbksrnoMapTab + season + "0" + wbdcode + cropyear;
			partKey = season + "0" + wbdcode + cropyear;

		} else {
			System.out.println("else  case" + wbdcode);
			partitionName = partitionName + season + wbdcode + cropyear;
			rbksrnoMapTab = rbksrnoMapTab + season + wbdcode + cropyear;
			partKey = season + wbdcode + cropyear;
		}

		if (activeYear.equals(cropyear)) {
			partitionName = "ecrop" + cropyear + "." + partitionName;
			rbksrnoMapTab = "ecrop" + cropyear + "." + rbksrnoMapTab;
			efishTab = "ecrop" + cropyear + "." + efishTab;
			crbooknwb = "ecrop" + cropyear + "." + crbooknwb;
		} else {
			partitionName = partitionName;
		}

		List<PattadharPojo> pojo = repo.pattadharDetails(qry, partitionName, vcode, efishTab, rbksrnoMapTab, crbooknwb);
		DistrictCsEntity dname = districtRepo.findByDcode(Integer.parseInt(dcode));
		MandalCsEntity mname = mandalRepo.findByMcode(Integer.parseInt(mcode));
		VillageCsEntity vname = villageyrepo.findByVcode(Integer.parseInt(vcode.trim()));
		WbVillageMastEntity vnmae = repos.findByWbvcode(Integer.parseInt(vcode.trim()));

		model.addAttribute("pattadharDetails", pojo);
		model.addAttribute("vcode", vcode);

		model.addAttribute("districtname", dname.getDname());
		model.addAttribute("mandalname", mname.getMname());
		model.addAttribute("villagename", vnmae.getWbvname());
		model.addAttribute("rbkcode", rbkcode);
		model.addAttribute("empcode", empCode);
		model.addAttribute("rbkcode", rbkcode);
		model.addAttribute("empcode", empCode);
		model.addAttribute("cropyear", cropyear);
		model.addAttribute("season", season);
		model.addAttribute("partkey", partKey);

		return "AllocSrvyDetails";
	}

	@PostMapping("/saveSelectionInRBK")
	public String saveSelection(HttpServletRequest httpServletRequest, HttpSession httpSession,
			RedirectAttributes redirectAttributes) {
		List<String> selectedBkIds = null;
		Integer dcode = 0, mcode = 0, cr_vcode = 0, cryear = 0, recId=0, regno=0, sjoint=0,crDcode=0, crMcode=0;
		String surveyNo = "", farmerName = "", fatherName = "", occupName = "", occupFname = "",uid="";
		Character season1 = null;
		BigDecimal khathNo = null, totalextent = null, occupextent = null, cropYear = null,cultiland=null,uncultiLand=null,mobileNo=null;
		BigInteger wsno = null;
		String[] bkIdList = httpServletRequest.getParameterValues("selectedBkIds");
		String[] datasrc = httpServletRequest.getParameter("dataSrcList").split(",");
		String cropyear = httpServletRequest.getParameter("pcropyear");
		String season = httpServletRequest.getParameter("pcropseason");
		String rbkcode = httpServletRequest.getParameter("rbkcodes");
		String vcode = httpServletRequest.getParameter("vcodes").trim();
		String empCode = httpServletRequest.getParameter("empCode").trim();
		String partkey = httpServletRequest.getParameter("ppartkey").trim();
		// sesion related
		String userid = httpSession.getAttribute("userid").toString();
		String sesdcode = httpSession.getAttribute("dcode").toString();
		String sesmcode = httpSession.getAttribute("mcode").toString();
		String wbdcode = repo.getWbdCode(sesdcode);
		int count = 0;
		List<RbkDetailsProjection> rbkUserId = employeeService.getRbkUserId(Integer.parseInt(rbkcode),
				Integer.parseInt(empCode));
		String rbkuserid2 = rbkUserId.get(0).getRbkuserid();
		if (bkIdList != null) {
			selectedBkIds = Arrays.asList(bkIdList);
		}

		for (int i = 0; i < bkIdList.length; i++) {
			//cr_dist_code, cr_mand_code,cultivable_land, uncultivable_land, regno, sjointoccupant,cr_farmeruid, mobileno
			if (datasrc[i].equals("W")) {
				List<Object[]> pattadarDetails = detailsRepository.getPattadarDetails(wbdcode, season, cropyear,
						bkIdList[i]);
				for (Object[] list : pattadarDetails) {
					Object[] value = list;
					dcode = (Integer) value[0];
					mcode = (Integer) value[1];
					cr_vcode = (Integer) value[2];
					cryear = (Integer) value[3];
					season1 = (Character) value[4];
					khathNo = (BigDecimal) value[5];
					surveyNo = (String) value[6];
					totalextent = (BigDecimal) value[7];
					occupextent = (BigDecimal) value[8];
					wsno = (BigInteger) value[9];
					farmerName = (String) value[10];
					fatherName = (String) value[11];
					occupName = (String) value[12];
					occupFname = (String) value[13];
					recId =(Integer) value[14];
					crDcode=(Integer) value[15];
					crMcode=(Integer) value[16];
					cultiland=(BigDecimal) value[17];
					uncultiLand=(BigDecimal) value[18];
					regno=(Integer) value[19];
					sjoint=(Integer) value[20];
					uid=(String) value[21];
					mobileNo=(BigDecimal) value[22];
					
				}
				count += detailsRepository.savePattadarDetails(partkey, dcode, mcode, Integer.parseInt(vcode),
						Integer.parseInt(cropyear), season, khathNo, surveyNo, totalextent, occupextent, userid,
						Integer.parseInt(rbkcode), Integer.parseInt(empCode), wsno, rbkuserid2, datasrc[i], bkIdList[i],
						farmerName, fatherName, occupName, occupFname,crDcode,crMcode,cultiland,uncultiLand,regno,sjoint,uid,mobileNo);
				
				
				
				
			} else {
				List<Object[]> crBooking = detailsRepository.crBookingNwb(wbdcode, season, cropyear, bkIdList[i]);
				for (Object[] list : crBooking) {
					Object[] value = list;
					dcode = (Integer) value[0];
					mcode = (Integer) value[1];
					cr_vcode = (Integer) value[2];
					cropYear = (BigDecimal) value[3];
					season1 = (Character) value[4];
					khathNo = (BigDecimal) value[5];
					surveyNo = (String) value[6];
					totalextent = (BigDecimal) value[7];
					occupextent = (BigDecimal) value[8];
					wsno = (BigInteger) value[9];
					farmerName = (String) value[10];
					fatherName = (String) value[11];
					occupName = (String) value[12];
					occupFname = (String) value[13];
					recId =(Integer) value[14];
					crDcode=(Integer) value[15];
					crMcode=(Integer) value[16];
					cultiland=(BigDecimal) value[17];
					uncultiLand=(BigDecimal) value[18];
					regno=(Integer) value[19];
					if(value[20]!=null) {
					sjoint=(Integer) value[20];
					}else {
						sjoint=0;
					}
					uid=(String) value[21];
					if(value[22]!=null) {
					mobileNo=(BigDecimal) value[22];
					}else {
						mobileNo=null;
					}
					
				}
				count += detailsRepository.savePattadarDetails(partkey, dcode, mcode, Integer.parseInt(vcode),
						Integer.parseInt(cropyear), season, khathNo, surveyNo, totalextent, occupextent, userid,
						Integer.parseInt(rbkcode), Integer.parseInt(empCode), wsno, rbkuserid2, datasrc[i],
						bkIdList[i],farmerName, fatherName, occupName, occupFname,crDcode,crMcode,cultiland,uncultiLand,regno,sjoint,uid,mobileNo);
				detailsRepository.updateCrBookingNwd(Integer.parseInt(vcode), bkIdList[i]);

			}
						int updatePattadarStatus = detailsRepository.updatePattadarStatus(recId, wbdcode, season, cropyear);
						System.out.println("count--->"+updatePattadarStatus);
		}

		System.out.println(count);
		redirectAttributes.addFlashAttribute("msg",
				count + "  Records Successfully allocated survey numbers to VAA/VHA/VSA");
		return "redirect:/allocOfSurveyNo";
	}

}
