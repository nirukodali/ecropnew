package com.ecrops.config;


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
    
    public boolean season(String doubleValue) {
        return doubleValue != null && doubleValue.matches( "^[kKRrSs]$") && !doubleValue.isEmpty();

    }
    
    public boolean year(String doubleValue) {
        return doubleValue != null && doubleValue.matches( "^\\d{4}$") && !doubleValue.isEmpty();

    }
    
    
  
    
    
    public boolean villageCode(String doubleValue) {
        return doubleValue != null && doubleValue.matches( "^\\d{6,7}$") && !doubleValue.isEmpty();

    }
    public boolean mandalCode(String doubleValue) {
        return doubleValue != null && doubleValue.matches("^\\d{2}(?:\\d{2})?$") && !doubleValue.isEmpty();

    }
    
   
    public boolean districtCode(String doubleValue) {
        return doubleValue != null && doubleValue.matches("^\\d{1,3}$") && !doubleValue.isEmpty();

    }
    
    public boolean cropCode(String doubleValue) {
        return doubleValue != null && doubleValue.matches("^\\d{3}|\\d{5}$") && !doubleValue.isEmpty();

    }
   
    
    
}
