package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecrops.entity.AppUser;
import com.ecrops.entity.Employeename;
import com.ecrops.projection.EmployeeName;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.VillageName;
import com.ecrops.projection.WbVillageRepository;
import com.ecrops.repo.AppUserRepo;
import com.ecrops.repo.EmpLogsSaveRepository;
import com.ecrops.repo.EmpRbkMapIncharges;
import com.ecrops.repo.EmpRbkMapRepository;
import com.ecrops.repo.EmpRepo;
import com.ecrops.repo.RbkEntityRepository;
import com.ecrops.repo.SaveEmployeeDeatilsRepository;
import com.ecrops.repo.UserRegistrationRepository;
import com.ecrops.repo.VillRepo;
import com.ecrops.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmpLogsSaveRepository empLogsRepo;

	@Autowired
	private RbkEntityRepository entityRepository;

	@Autowired
	private UserRegistrationRepository registrationRepository;

	@Autowired
	private EmpRbkMapRepository empRbkMapRepository;

	@Autowired
	private EmpRbkMapIncharges empRbkMapIncharges;

	@Autowired
	private SaveEmployeeDeatilsRepository deatilsRepository;
	@Autowired
	private AppUserRepo appUsersRepo;

	@Autowired
	private VillRepo villRepo;

	@Autowired
	private EmpRepo empRepo;

	String email = "";
	AppUser user;

	@GetMapping("/employeeprofile")
	public String employeeprofile(HttpSession httpSession, Model model) {

		return "employeeprofile";
	}

	@PostMapping("/employeeprofile")
	public String saveEmployee(@ModelAttribute("employee") Employeename employee, HttpSession httpSession, Model model,
			HttpServletRequest httpServletRequest) {
		String district = (String) httpSession.getAttribute("dcode");
		String mandal = (String) httpSession.getAttribute("mcode");
		String aadhar_id = employee.getAadhaar_id();
		Integer emp_code = employee.getEmp_code();
		String emp_name = employee.getEmp_name();
		String email = employee.getEmail();
		Long mobile = employee.getMobile();
		String designation = httpServletRequest.getParameter("box");
		List<Employeename> aadharExists = employeeService.getAadharExists(aadhar_id);
		if (aadharExists.size() > 0) {
			model.addAttribute("msg", "Aadhaar No Already Exists");
		} else {

			int savedEmp = deatilsRepository.saveEmployeeLogDetails(Integer.parseInt(district),
					Integer.parseInt(mandal), aadhar_id, emp_code, emp_name, email, mobile, designation);
			if (savedEmp > 0) {
				model.addAttribute("msg", "Successfully Saved Employee Details");
			}
		}
		return "employeeprofile";
	}

	@GetMapping("/rbkmapping")
	public String rbkmappingTest(Model model, HttpSession httpSession) {
		String village = (String) httpSession.getAttribute("village");
		String mandal = (String) httpSession.getAttribute("mcode");

		List<VillageName> villname = villRepo.getVillName(Integer.parseInt(mandal));
		List<EmployeeName> mandalName = empRepo.findEmpName(Integer.parseInt(mandal));

		model.addAttribute("villname", villname);
		model.addAttribute("mandalName", mandalName);

		return "rbkmapping";
	}

	@PostMapping("/rbkSaveprofile")
	public String saverbk(@ModelAttribute("rbk") Employeename employee, HttpServletRequest httpServletRequest,
			HttpSession httpSession, Model model) {

		String district = (String) httpSession.getAttribute("dcode");

		String mandal = (String) httpSession.getAttribute("mcode");

		String userId = (String) httpSession.getAttribute("userid");

		String incharge = employee.getIncharge();

		String rbkCode = userId.substring(4);

		String emp = httpServletRequest.getParameter("employee");
		System.out.println("emp----->" + emp);

		String villageCode = httpServletRequest.getParameter("village");
		System.out.println("vill---->" + villageCode);

		String rbkUserId = "RBK_" + villageCode;
		String incsts = "";
		String empcode = "", emp_name = "", email = "", mobile = "", aadhaar_id = "", rbkuserid2 = "";
		String dcode = "", emp_code = "", mcode = "", rbkcode2 = "", rbkuserid = "", wbdcode = "", wbmcode = "";
		int saveEmpLogDetails = 0, updateInchargeStatus = 0, saveUserDetails = 0, updateInchargeStatus1 = 0,
				saveUserDetails1 = 0, saveUserDetails2 = 0, saveEmpRbkMap = 0, saveEmpRbkMapIncharge = 0;
		List<WbVillageRepository> webLandDetails = employeeService.getWebLandDetails(Integer.parseInt(district),
				Integer.parseInt(mandal));
		String wbdcode2 = webLandDetails.get(0).getWbdcode();
		String wbmcode2 = webLandDetails.get(0).getWbmcode();
		List<RbkDetailsProjection> savedEmp = employeeService.getEmployeeDetails(Integer.parseInt(district),
				Integer.parseInt(mandal), Integer.parseInt(emp));
		empcode = savedEmp.get(0).getEmp_code();
		System.out.println("empcode---->" + empcode);
		emp_name = savedEmp.get(0).getEmp_name();
		System.out.println("emp_name---->" + emp_name);
		email = savedEmp.get(0).getEmail();
		System.out.println("email---->" + email);
		mobile = savedEmp.get(0).getMobile();
		System.out.println("mobile---->" + mobile);
		aadhaar_id = savedEmp.get(0).getAadhaar_id();
		System.out.println("aadhaar_id---->" + aadhaar_id);
//		rbkuserid2 = savedEmp.get(0).getRbkuserid();System.out.println("rbkuserid2---->"+rbkuserid2);
		if (incharge.equals("R")) {
			List<InchargeRbkProjection> inchargeStatus = employeeService.getInchargeStatus(Integer.parseInt(rbkCode));
			System.out.println("incjharge---->" + inchargeStatus);
			if (inchargeStatus.size() > 0) {
				String incharge_sts = inchargeStatus.get(0).getInchargests();
				if (inchargeStatus.size() > 0) {
					List<InchargeRbkProjection> rbkDetailsToSave = employeeService
							.getRbkDetailsToSave(Integer.parseInt(rbkCode));
					dcode = rbkDetailsToSave.get(0).getDcode();
					emp_code = rbkDetailsToSave.get(0).getEmpcode();
					mcode = rbkDetailsToSave.get(0).getMcode();
					rbkcode2 = rbkDetailsToSave.get(0).getRbkcode();
					rbkuserid = rbkDetailsToSave.get(0).getRbkuserid();
					wbdcode = rbkDetailsToSave.get(0).getWbdcode();
					wbmcode = rbkDetailsToSave.get(0).getWbmcode();

					saveEmpLogDetails = empLogsRepo.saveEmployeeLogDetails(Integer.parseInt(dcode),
							Integer.parseInt(emp_code), Integer.parseInt(mcode), Integer.parseInt(rbkcode2), rbkUserId,
							Integer.parseInt(wbdcode), Integer.parseInt(wbmcode));
					if (saveEmpLogDetails > 0) {
						if (incharge_sts != null) {
							incsts = "R";
							if (incharge_sts.equals("I")) {
								incsts = "R";
							}
							updateInchargeStatus = entityRepository.updateEmpDetails(incsts, Integer.parseInt(emp),
									Integer.parseInt(rbkCode));
							if (updateInchargeStatus > 0) {

								saveUserDetails = registrationRepository.updateUserDetails(incsts,
										Integer.parseInt(empcode), emp_name, email, mobile, aadhaar_id, rbkUserId);
							}
						} else {
							incsts = "R";
							updateInchargeStatus1 = entityRepository.updateEmpDetails1(incsts, Integer.parseInt(emp),
									Integer.parseInt(rbkCode));
							if (updateInchargeStatus1 > 0) {
								saveUserDetails1 = registrationRepository.updateUserDetails1(incsts,
										Integer.parseInt(empcode), emp_name, email, mobile, aadhaar_id, rbkUserId);
							}
						}
					}
				}
			} else {

				saveUserDetails2 = registrationRepository.UpdateUserDetails2(Integer.parseInt(emp), emp_name, email,
						mobile, aadhaar_id, userId);
				if (saveUserDetails > 0) {
					saveEmpRbkMap = empRbkMapRepository.saveEmpRbkMapDetails(Integer.parseInt(district),
							Integer.parseInt(mandal), Integer.parseInt(rbkCode), Integer.parseInt(emp), rbkUserId,
							Integer.parseInt(wbdcode), Integer.parseInt(wbmcode));
				}
			}
		} else if (incharge.equals("A") || incharge.equals("I")) {

			String status = "N";
			saveEmpRbkMapIncharge = empRbkMapIncharges.saveEmpRbkMapIncharges(Integer.parseInt(district),
					Integer.parseInt(mandal), Integer.parseInt(rbkCode), Integer.parseInt(emp), rbkUserId,
					Integer.parseInt(wbdcode2), Integer.parseInt(wbmcode2), incharge, status);
		}
		if (updateInchargeStatus > 0 && saveUserDetails > 0 || updateInchargeStatus1 > 0 && saveUserDetails1 > 0
				|| saveUserDetails2 > 0 && saveEmpRbkMap > 0 || saveEmpRbkMapIncharge > 0) {
			model.addAttribute("msg", "Successfully  Added");
		}

		List<RbkDetailsProjection> regDet = employeeService.getRegDMcode(Integer.parseInt(district),
				Integer.parseInt(mandal));
		model.addAttribute("regDet", regDet);

		return "rbkmapping";
	}

	@GetMapping("/incharge_det")
	public String incharge(HttpSession httpSession, Model model) {

		String district = (String) httpSession.getAttribute("dcode");
		String mandal = (String) httpSession.getAttribute("mcode");
		List<InchargeRbkProjection> regIncDet = employeeService.getDMcode(Integer.parseInt(district),
				Integer.parseInt(mandal));
		model.addAttribute("InchAdd", regIncDet);
		return "incharge_det";
	}

	@GetMapping("/RbkInchDet")
	public String RbkInchDet(HttpSession httpSession, Model model) {
		String district = (String) httpSession.getAttribute("dcode");
		String mandal = (String) httpSession.getAttribute("mcode");
		List<RbkDetailsProjection> regDet = employeeService.getRegDMcode(Integer.parseInt(district),
				Integer.parseInt(mandal));
		model.addAttribute("RegDet", regDet);
		return "RbkInchDet";
	}

}
