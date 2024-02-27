package com.ecrops.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StateWiseCropIrriAbsIntf {
	
	private BigDecimal totext;
	@ Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  cr_vcode;
	public StateWiseCropIrriAbsIntf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateWiseCropIrriAbsIntf(BigDecimal totext, Integer cr_vcode) {
		super();
		this.totext = totext;
		this.cr_vcode = cr_vcode;
	}
	public BigDecimal getTotext() {
		return totext;
	}
	public void setTotext(BigDecimal totext) {
		this.totext = totext;
	}
	public Integer getCr_vcode() {
		return cr_vcode;
	}
	public void setCr_vcode(Integer cr_vcode) {
		this.cr_vcode = cr_vcode;
	}
	@Override
	public String toString() {
		return "StateWiseCropIrriAbsIntf [totext=" + totext + ", cr_vcode=" + cr_vcode + "]";
	}
	
	
}
