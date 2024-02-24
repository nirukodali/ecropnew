package com.ecrops.dto;

import javax.validation.constraints.NotBlank;

public class AllocValidation {
	
	@NotBlank
	private String vcode;
	
	@NotBlank
	private String rbkcode;
	@NotBlank
	private String empcode;
	@NotBlank
	private String cropYear;

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getRbkcode() {
		return rbkcode;
	}

	public void setRbkcode(String rbkcode) {
		this.rbkcode = rbkcode;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}
	

}
