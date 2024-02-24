package com.ecrops.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;
@Component
public class UnsurveydDataDto {
	@NotBlank(message="cropyear should not be null or empty")
	private String cropyear;
	
	@NotNull(message="Village Code should not be null or empty")
	private Integer vcode;
	@Pattern(regexp = "[a-zA-Z0-9|,-]+",message="enter correct survey No")
	@NotBlank(message = "survyNo should not be null or empty")
	private String survyNo;


	public String getCropyear() {
		return cropyear;
	}

	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}

	
	public Integer getVcode() {
		return vcode;
	}

	public void setVcode(Integer vcode) {
		this.vcode = vcode;
	}

	public String getSurvyNo() {
		return survyNo;
	}

	public void setSurvyNo(String survyNo) {
		this.survyNo = survyNo;
	}

	@Override
	public String toString() {
		return "UnsurveydDataDto [cropyear=" + cropyear + ", vcode=" + vcode + ", survyNo=" + survyNo + "]";
	}
	
	

}
