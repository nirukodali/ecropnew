package com.ecrops.entity;

public class RegularExpressionclassMethod {
    
    public boolean checkKhataNo(String digitsOnly) {
        return digitsOnly != null && digitsOnly.matches("[0-9]+") && !digitsOnly.isEmpty();
    }

    public boolean checkSuveyNo(String allowedCharacters) {
      return  allowedCharacters != null && allowedCharacters.matches("[a-zA-Z0-9|,-]+") && !allowedCharacters.isEmpty();
    }

    public boolean checkName(String name) {
        return name != null && name.matches("[a-zA-Z. ]+") && !name.isEmpty();
    }

    public boolean checkAadharNumber(String aadharNumber) {
        return aadharNumber != null && aadharNumber.matches("\\d{12}") && !aadharNumber.isEmpty();
    }

    public boolean checkMobileNumber(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("[6-9]\\d{9}") && !mobileNumber.isEmpty();

    }

    public boolean checkExtent(String doubleValue) {
        return doubleValue != null && doubleValue.matches("^(\\d{1,18}|\\d{1,18}\\.\\d{1,2})$") && !doubleValue.isEmpty();

    }
}
