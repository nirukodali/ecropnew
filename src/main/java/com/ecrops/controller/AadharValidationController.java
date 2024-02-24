package com.ecrops.controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Validated
public class AadharValidationController {

 
    public String validateAadhar(@RequestParam("aadharNo") String aadharNo) {
        if (isValidAadhar(aadharNo)) {
            return "Valid Aadhar number";
        } else {
            return "Invalid Aadhar number";
        }
    }

    private boolean isValidAadhar(String aadharNo) {
        String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        return aadharNo.matches(regex);
    }
}

