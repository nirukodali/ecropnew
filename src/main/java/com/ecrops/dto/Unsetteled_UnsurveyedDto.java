package com.ecrops.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.ecrops.validations.MobileNumber;
@Component
public class Unsetteled_UnsurveyedDto {

	@NotBlank(message = "cultfarmerName should not be null or empty")
	private String cultfarmerName;
	
	@Pattern(regexp = "[a-zA-Z0-9|,-]+",message="enter correct survey No")
	@NotBlank(message = "surveyNo should not be null or empty")
	private String cultfatherName;
//    @DecimalMin(value = "0.0", inclusive = false,message="total extent should not less than 0.0")
//    @NegativeOrZero
	@NotNull(message = "totext should not be null or empty")
	private Double totext;
	@NotNull(message = "cultext should not be null or empty")
	private Double cultext;
	@NotBlank(message = "farmerUid should not be null or empty")
    @Digits(integer = 12,message = "Aadhar Number should have exactly 12 digits", fraction = 0)
	private String farmerUid;
	@NotBlank(message = "Please select atleast one dropdown value")
	private String objGender;
	@NotNull(message = "Mobile number should not be null")
    @Digits(integer = 10,message = "Mobile number should have exactly 10 digits", fraction = 0)
    //@Size(min = 10, max = 10, message = "Mobile number should have exactly 10 digits")
    @Digits(integer = 10, fraction = 0, message = "Mobile number should have exactly 10 digits")
//@Min(value = 0)
    //@Pattern(regexp="\\d{10}", message="Mobile number should be exactly 10 digits")
   // @Size(max = 10, message = "Mobile number should not be less than 10 digits")
  //  @MobileNumber(message = "Mobile number should not be less than 10 digits")
	private Long objMobileno;
	@NotBlank(message = "Please select atleast one dropdown value")
	private String objcat;
	@NotBlank(message = "surveyNo should not be null or empty")
	private String surveyNo;
    public String getCultfarmerName() {
		return cultfarmerName;
	}

	public void setCultfarmerName(String cultfarmerName) {
		this.cultfarmerName = cultfarmerName;
	}

	public String getCultfatherName() {
		return cultfatherName;
	}

	public void setCultfatherName(String cultfatherName) {
		this.cultfatherName = cultfatherName;
	}

	public Double getTotext() {
		return totext;
	}

	public void setTotext(Double totext) {
		this.totext = totext;
	}

	public Double getCultext() {
		return cultext;
	}

	public void setCultext(Double cultext) {
		this.cultext = cultext;
	}

	public String getFarmerUid() {
		return farmerUid;
	}

	public void setFarmerUid(String farmerUid) {
		this.farmerUid = farmerUid;
	}

	public String getObjGender() {
		return objGender;
	}

	public void setObjGender(String objGender) {
		this.objGender = objGender;
	}

	public Long getObjMobileno() {
		return objMobileno;
	}

	public void setObjMobileno(Long objMobileno) {
		this.objMobileno = objMobileno;
	}

	public String getObjcat() {
		return objcat;
	}

	public void setObjcat(String objcat) {
		this.objcat = objcat;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

}
