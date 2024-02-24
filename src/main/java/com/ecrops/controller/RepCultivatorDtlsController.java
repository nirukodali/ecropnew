package com.ecrops.controller;

import com.ecrops.entity.ActiveSeason;
import com.ecrops.entity.Cultivator;
import com.ecrops.service.RepCultivatorDtlsService;
import com.ecrops.service.impl.ActiveSeasonServiceImpl;
import com.ecrops.util.ECropUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class RepCultivatorDtlsController {

    private ActiveSeasonServiceImpl activeSeasonService;
    private RepCultivatorDtlsService repCultivatorDtlsService;

    public RepCultivatorDtlsController(ActiveSeasonServiceImpl activeSeasonService, RepCultivatorDtlsService repCultivatorDtlsService) {
        this.activeSeasonService = activeSeasonService;
        this.repCultivatorDtlsService = repCultivatorDtlsService;
    }

    @GetMapping("/repCultivatorDtls")
    public String loadAddOrUpdateCultivator(Model model) {
        List<ActiveSeason> cropYearActiveSeasonList = activeSeasonService.listAll();
        model.addAttribute("crYearList",cropYearActiveSeasonList);
        model.addAttribute("cultivator", new Cultivator());

        return "repCultivatorDtlsHomePage";
    }

    @GetMapping("/repCultivatorDtls/aadharNo/{aadharNo}")
    public String getCultivatorDetailsByKathaNo(@PathVariable("aadharNo") String aadharNo, @PathParam("cropYear") Integer cropYear,
                                                @PathParam("season") String season, Model model, HttpSession session) {

        String userId = ECropUtility.sessionData(session).getUserid();

        Integer wbdCode = ECropUtility.sessionData(session).getWbdcode();

        String tableName = "ecrop"+cropYear+".phy_ack_" + season + (wbdCode <= 9 ? "0" + wbdCode : wbdCode) + "_mv";

        List<Cultivator> repCultivatorDtlsList = repCultivatorDtlsService.getRepCultivatorsDtlsByAadharNo(aadharNo, userId, tableName);

        model.addAttribute("repCultivatorDtlsList", repCultivatorDtlsList);
        return "repCultivatorDtls";
    }

}
