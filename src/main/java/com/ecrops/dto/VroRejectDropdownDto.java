package com.ecrops.dto;

import javax.persistence.Column;


public class VroRejectDropdownDto {

	
	@Column(name = "code")
	private Integer code;

	@Column(name = "reason")
	private String reason;

	@Column(name = "active")
	private String active;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public VroRejectDropdownDto() {
		super();
		}
	

	public VroRejectDropdownDto(Integer code, String reason, String active) {
		super();
		this.code = code;
		this.reason = reason;
		this.active = active;
	}

	@Override
	public String toString() {
		return "VroRejectDropdownDto [code=" + code + ", reason=" + reason + ", active=" + active + "]";
	}
	
	
}
