package com.ecrops.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.Cultivator;
import com.ecrops.projection.PattadarProjection;
import com.ecrops.repo.CultivatorRepository;
import com.ecrops.service.CultivatorService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
public class CultivatorController {

	Logger logger = LoggerFactory.getLogger(CultivatorController.class);

	@Autowired
	private CultivatorService cultivatorService;

	@Autowired
	private CultivatorRepository cultivatorRepository;

	@Autowired
	private ActiveSeasonServiceImpl activeSeasonService;

	@GetMapping("/cultivator")
	public String loadAddOrUpdateCultivator(Model model, HttpSession session) {

		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();

		model.addAttribute("crYearList", cropYearActiveSeasonList);
		model.addAttribute("cultivator", new Cultivator());
		model.addAttribute("seasonActive", cropYearActiveSeasonList.get(0).getSeason());

		return "cultivatorHomePage";
	}

	@GetMapping("/cultivator/kathaNo/")
	public String getCultivatorDetailsByKathaNo(Cultivator cultivator, Model model, HttpSession session,
			HttpServletRequest httpServletRequest) {

		Integer cropyear = (Integer) session.getAttribute("ACTIVEYEAR");
		String cr_Season = (String) session.getAttribute("seasonActive");
		List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();

		List<Cultivator> allCultiVatorsList = cultivatorRepository.getCultivatorDetailsByKathaNo(cultivator.getKhNo(),
				cultivator.getCr_vcode(), cropyear, cr_Season);

		List<Cultivator> cultivatorDataByKathaNo = cultivatorRepository.getCultivatorDataByKathaNo(cultivator.getKhNo(),
				cultivator.getCr_vcode(), cropyear, cr_Season);

		List<Cultivator> allCcrcList = cultivatorRepository.getCcrcDetailsByKathaNo(cultivator.getKhNo(),
				cultivator.getCr_vcode(), cropyear, cr_Season);
		
		BigDecimal kh= new BigDecimal(cultivator.getKhNo());
		List<PattadarProjection> originalExtentList = cultivatorRepository.getOriginalExtent(kh,cultivator.getCr_vcode());
		model.addAttribute("originalExtentList",originalExtentList);
		

		List<Cultivator> cultivatorsList = allCultiVatorsList.stream().filter(c -> c.getCultivatorType() != null)
				.collect(Collectors.toList());

		List<Cultivator> ownersList = allCultiVatorsList.stream().map(pc -> {
			Float availableExtent = 0.00f;
			if ("O".equals(pc.getOwner_tenant()) || pc.getCultivatorType() == null) {
				availableExtent = pc.getAvailableExtent();
				if ("O".equals(pc.getCultivatorType()) || "C".equals(pc.getCultivatorType())) {
					availableExtent = pc.getAvailableExtent();
				} else if ("L".equals(pc.getCultivatorType())) {
					availableExtent = pc.getAvailableExtent();
				} else if (pc.getCultivatorType() == null) {
					availableExtent = pc.getAvailableExtent();
				}

				for (Cultivator cc : cultivatorsList) {
					if ("K".equals(cc.getCultivatorType()) && pc.getBookingId().equals(cc.getRefBookingId())) {
						availableExtent = pc.getAvailableExtent();
					}
				}
			}

			pc.setAvailableExtent(Float.valueOf(String.format("%1.4f", availableExtent)));
			return pc;
		}).filter(c -> "O".equalsIgnoreCase(c.getOwner_tenant()) || "T".equalsIgnoreCase(c.getOwner_tenant()))
				.collect(Collectors.toList());

		if (  ownersList.size() > 0) {
			model.addAttribute("ownersList", ownersList);
		}
		if(allCultiVatorsList.size() > 0) {
			model.addAttribute("allCultiVatorsList", allCultiVatorsList);
		} 
		if (allCcrcList.size() > 0) {
			model.addAttribute("ccrcList", allCcrcList);
		}
		model.addAttribute("cultivator", new Cultivator());
		model.addAttribute("seasonActive", cropYearActiveSeasonList.get(0).getSeason());
		model.addAttribute("cultivatorsData", cultivatorDataByKathaNo);

//		for (int i = 0; i < allCcrcList.size(); i++) {
//			if (ownersList.get(i).getAvailableExtent() >= allCcrcList.get(i).getOccupantExtent()) {
//				System.out.println(
//						"allCcrcList.get(i).getOccupantExtent()------" + allCcrcList.get(i).getOccupantExtent());
//				model.addAttribute("availableCcrc", allCcrcList.get(i).getOccupantExtent());
//			} else {
//				System.out.println(
//						"ownersList.get(i).getAvailableExtent()---------" + ownersList.get(i).getAvailableExtent());
//				model.addAttribute("availableCcrc", ownersList.get(i).getAvailableExtent());
//			}
//		}

		return "addupdatecultivator";
	}

	@PostMapping("/cultivator/save")
	public String saveCultivatorsData(Cultivator cultivator, Model model) {

		cultivatorService.saveCultivatorsData(cultivator);
		List<Cultivator> cultiVatorsList = cultivatorService.getCultivatorsByKathaNo(cultivator);
		model.addAttribute("ownersList",
				cultiVatorsList.stream().filter(
						c -> "O".equalsIgnoreCase(c.getOwner_tenant()) || "T".equalsIgnoreCase(c.getOwner_tenant()))
						.collect(Collectors.toList()));

		model.addAttribute("cultivatorsList",
				cultiVatorsList.stream().filter(c -> c.getCultivatorType() != null).collect(Collectors.toList()));

		model.addAttribute("cultivator", new Cultivator());

		return "addupdatecultivator";

	}

	@PutMapping("/cultivator/owner/update")
	public String updateOwnerOrEnjoerDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.updateOwnerOrEnjoerDetails(cultivator);

		return "addupdatecultivator";

	}

	@PutMapping("/cultivator/ccrc/update")
	public String updateCcrcDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {
		System.out.println("cultivator---->" + cultivator);
		cultivatorService.updateCcrcDetails(cultivator);

		return "addupdatecultivator";

	}

	@PutMapping("/cultivator/update")
	public String updateCultivatorDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.updateCultivatorDetails(cultivator);

		return "addupdatecultivator";

	}

	@DeleteMapping("/cultivator/delete")
	public String deleteCultivatorDetails(Cultivator cultivator, RedirectAttributes redirectAttributes) {

		cultivatorService.deleteCultivatorDetails(cultivator);

		return "addupdatecultivator";

	}

	@GetMapping("/cultivator/extent")
	public String getAnubhavadarAndOccupantExtent(Cultivator cultivator, Model model, HttpServletRequest request,
			HttpServletResponse response) throws JsonProcessingException {
		Float anubhavadarExtent = cultivatorService.getAnubhavadarExtent(cultivator);

		Float totalOccupantExtent = cultivatorService.getTotalOccupantExtent(cultivator);

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		cultivator.setAnubhavadarExtent(anubhavadarExtent);
		cultivator.setOccupantExtent(totalOccupantExtent);

		String jsonMap = mapper.writeValueAsString(cultivator);

		response.setContentType("json");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(jsonMap);
			out.flush();
			return null;
		} catch (Exception e) {
		}

		return null;
	}

}
