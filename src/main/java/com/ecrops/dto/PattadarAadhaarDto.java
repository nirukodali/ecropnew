package com.ecrops.dto;

import javax.validation.constraints.NotBlank;

public class PattadarAadhaarDto {
	
	@NotBlank(message = "Name cannot be empty")
	private String ocName;
	
	@NotBlank(message = "Fathername cannot be empty")
	private String ocfName;
	
	@NotBlank(message = "SurveyNo cannot be empty")
	private String sNo;
	
	@NotBlank(message = "KhataNo cannot be empty")
	private String kh_no;
	
	@NotBlank(message = "AadhaarNo cannot be empty")
	private String aadhaar;
	
	private String regno;
	private String sjointoccupant;
	private String data_src;
	private String cr_year;
	private String cr_season;
	private String cr_vcode;
	
	
	public String getOcName() {
		return ocName;
	}
	public void setOcName(String ocName) {
		this.ocName = ocName;
	}
	public String getOcfName() {
		return ocfName;
	}
	public void setOcfName(String ocfName) {
		this.ocfName = ocfName;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getKh_no() {
		return kh_no;
	}
	public void setKh_no(String kh_no) {
		this.kh_no = kh_no;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getSjointoccupant() {
		return sjointoccupant;
	}
	public void setSjointoccupant(String sjointoccupant) {
		this.sjointoccupant = sjointoccupant;
	}
	public String getData_src() {
		return data_src;
	}
	public void setData_src(String data_src) {
		this.data_src = data_src;
	}
	public String getCr_year() {
		return cr_year;
	}
	public void setCr_year(String cr_year) {
		this.cr_year = cr_year;
	}
	public String getCr_season() {
		return cr_season;
	}
	public void setCr_season(String cr_season) {
		this.cr_season = cr_season;
	}
	public String getCr_vcode() {
		return cr_vcode;
	}
	public void setCr_vcode(String cr_vcode) {
		this.cr_vcode = cr_vcode;
	}

	

}
