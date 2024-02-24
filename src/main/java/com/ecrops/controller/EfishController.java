package com.ecrops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.dto.crop.response.CropYearCcrcEfish;
import com.ecrops.repo.crop.EfishCropRepository;
import com.ecrops.repo.crop.EfishService;

@Controller
public class EfishController {

    @Autowired
    private EfishCropRepository efishCropRepository;

    @Autowired
    private EfishService efishService;

    @GetMapping("/getEfishDataEntry")
    public String getEfishDataEntry(Model model) {
        List<CropYearCcrcEfish> activeSeasons = efishCropRepository.getCropYear();
        model.addAttribute("activeSeasons", activeSeasons);

        System.out.println("getEfishDataEntry--->"+activeSeasons);
        return "eFishCropEntry";
    }

    @PostMapping("/efishFormEntryData")
    public String getDataFromEfishEntryPage(@RequestParam("cropyear") String cropyear,
            @RequestParam("village") String village, Model model, HttpSession session, HttpServletRequest request) {
        try {
            if (cropyear == null || cropyear.isEmpty()) {
                throw new IllegalArgumentException("Crop year is required");
            }
            String[] seasonParts = cropyear.split("@");
            if (seasonParts.length != 2) {
                throw new IllegalArgumentException("Invalid crop year format");
            }
            String season = seasonParts[0];
            int cropYear = Integer.parseInt(seasonParts[1]);

            if (village == null || village.isEmpty()) {
                throw new IllegalArgumentException("Village is required");
            }
            int villageCode = Integer.parseInt(village);

            int wbdcode = (int) session.getAttribute("wbdcode");
            int wbmcode = (int) session.getAttribute("wbmcode");

            String ipaddress = request.getRemoteAddr();

            int crvcode = efishService.getCr_Vcode(cropYear,season);
            System.out.println("crvcode--->"+crvcode);

            int alreadyAvailableRecords = efishService.checkRecordIsAvailableInDatabase(crvcode, season, cropYear);
            if (alreadyAvailableRecords > 0) {
                model.addAttribute("alreadyAvailableRecords", alreadyAvailableRecords);
                System.out.println("alreadyAvailableRecords--->"+alreadyAvailableRecords);

                int villageinsercount = efishService.inserVillageDataIntoVerifyDownloadTable(cropYear, season,
                        villageCode, ipaddress, wbdcode, wbmcode);
                model.addAttribute("villageinsercount", villageinsercount);
                System.out.println("villageinsercount--->"+villageinsercount);
                System.out.println("villageCode---"+villageCode);

            } else {
                int recordCount = efishService.insertEfishDetails(ipaddress, cropYear, season);
                model.addAttribute("recordCount", recordCount);
                System.out.println("recordCount--->"+recordCount);

            }
        } catch (NumberFormatException e) {
            model.addAttribute("errorMessage", "Invalid input format");
            return "eFishCropEntry";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "eFishCropEntry";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error processing the request");
            return "eFishCropEntry";
        }
        return "efishDataEntry";
    }
}
