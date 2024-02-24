package com.ecrops.controller;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.service.EditCrBookingDetailsService;
import com.ecrops.service.VillageSecService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EditCropBookingDtlsController {

    ActiveSeasonServiceImpl activeSeasonService;
    EditCrBookingDetailsService editCrBookingDetailsService;
    VillageSecService villageSecService;

    public EditCropBookingDtlsController(ActiveSeasonServiceImpl activeSeasonService, EditCrBookingDetailsService editCrBookingDetailsService, VillageSecService villageSecService) {
        this.activeSeasonService = activeSeasonService;
        this.editCrBookingDetailsService = editCrBookingDetailsService;
        this.villageSecService = villageSecService;
    }

    @GetMapping("/editCropBookingDtls")
    public String loadEditCropBookingDtlsPage(Model model, HttpSession session) {
        List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
        model.addAttribute("crYearList", cropYearActiveSeasonList);
        List<ActiveSeasonProjection> villageList = villageSecService.getVillageListByRbk(Integer.valueOf(ECropUtility.sessionData(session).getVsCode()));
        model.addAttribute("crVillageList", villageList);

        return "editCropBookingDtlsSearch";
    }

    @GetMapping("/editCropBookingDtls/details")
    public String geEditCrBookingDetails(EditCropBookingDetailsModel ecbd, Model model, HttpSession session) {
        final String season = ecbd.getSeason();
        final Integer cropyear = ecbd.getCropYear();
        final Integer wbdcode = ECropUtility.sessionData(session).getWbdcode();
        List<EditCrBookingDtlsEntity> ecbdList = editCrBookingDetailsService.geEditCrBookingDetails(ecbd);
        ecbdList = ecbdList.stream().map(ec -> {
            ec.setSeason(season);
            ec.setCropyear(cropyear);
            ec.setWbdcode(wbdcode);
            return ec;
        }).collect(Collectors.toList());
        model.addAttribute("ecbdList", ecbdList);
        return "editCrBookingUidDetails";
    }

    @PostMapping("/editCropBookingDtls/updateUid")
    public String saveCultivatorsData(EditCrBookingDtlsEntity ecbd) {
        editCrBookingDetailsService.updateCrAadharNo(ecbd);
        return "editCropBookingDtlsSearch";

    }

}
