package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.entity.AppUser;
import com.ecrops.entity.DeviceEntity;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.projection.DeviceProjection;
import com.ecrops.repo.DeviceEntrySave;
import com.ecrops.repo.Devicesentryrepo;
import com.ecrops.repo.DistrictRepo;
import com.ecrops.service.EmployeeService;
import com.ecrops.util.MasterFunctions;
import com.ecrops.util.PartitoinsMethods;

@Controller
public class DeviceController {

	public DeviceController() {

	}
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	DeviceEntrySave deviceEntrySave;
	
	@Autowired
	MasterFunctions masterFunctions;
	
	@Autowired
	DistrictRepo districtRepo;
	
	@Autowired
	PartitoinsMethods partitoinsMethods;
	
	@Autowired
	RestControllers restControllers;
	
	@Autowired
	Devicesentryrepo devicesentryrepo;
	
	String email = "";
	AppUser user;

	@GetMapping("/DeviceRegistration")
	public String DeviceRegistration(HttpSession httpSession, Model model, HttpServletRequest httpServletRequest) {
		String district = (String) httpSession.getAttribute("dcode");
		String mandalcode = (String) httpSession.getAttribute("mcode");
		List<ActiveSeasonProjection> villages = employeeService.getVname(Integer.parseInt(district),
				Integer.parseInt(mandalcode));
		model.addAttribute("villages", villages);
		model.addAttribute("deviceEntity", new DeviceEntity());
		return "deviceregistration";
	}

	@RequestMapping("/SaveDeviceRegistration")
	public String SaveDeviceRegistration(HttpSession httpSession, Model model, HttpServletRequest httpServletRequest,
			RedirectAttributes redirectAttributes) {
		try {
			String imei1 = httpServletRequest.getParameter("imei1");
			String imei2 = httpServletRequest.getParameter("imei2");
			String ipadress = httpServletRequest.getRemoteAddr();
			String vcode = httpServletRequest.getParameter("village");
			if (vcode.isEmpty() || vcode.equals(null)) {
				redirectAttributes.addFlashAttribute("msg", "Please select a Village");
				return "redirect:/DeviceRegistration";
			} else {
				List<DeviceProjection> list = devicesentryrepo.getVcode(Integer.parseInt(vcode));
				if (list.size() > 0) {
					if (imei2.isEmpty() || imei2.equals(null) || imei2.length() != 15) {
						redirectAttributes.addFlashAttribute("msg", "Please enter a valid 15-digit IMEI number for the Second device.");
						return "redirect:/DeviceRegistration";
					} else {
						String status = "A";
						int saveddevice = deviceEntrySave.Savedevice(Integer.parseInt(vcode), imei1, imei2, status, ipadress);
						if (saveddevice > 0) {
							redirectAttributes.addFlashAttribute("msg", "Device data is  saved successfully!");
							return "redirect:/DeviceRegistration";
						} else {
							redirectAttributes.addFlashAttribute("msg", "Device data is  not saved. Please try again");
							return "redirect:/DeviceRegistration";
						}
					}
				} else {
					if (imei1.isEmpty() || imei1.equals(null) || imei1 == null) {
						redirectAttributes.addFlashAttribute("msg", "Please enter First device IMEI number");
						return "redirect:/DeviceRegistration";
					} else {
						String status = "A";
						int saveddevice = deviceEntrySave.Savedevice(Integer.parseInt(vcode), imei1, imei2, status, ipadress);
						if (saveddevice > 0) {
							redirectAttributes.addFlashAttribute("msg", "Device data is  saved successfully!");
							return "redirect:/DeviceRegistration";
						} else {
							redirectAttributes.addFlashAttribute("msg", "Device data is  not saved. Please try again");
							return "redirect:/DeviceRegistration";
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "Something went wrong please try again");
			return "redirect:/DeviceRegistration";
		}
	}
}
