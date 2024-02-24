package com.ecrops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "aadhaar_id")
	private String aadhaar_id;

	@Column(name = "type_user")
	private String type_user;

	@Column(name = "mobile_phone")
	private String mobile_phone;

	@Id
	@Column(name = "userid")
	private String userid;

	@Column(name = "encpassword")
	private String encpassword;

	@Column(name = "district")
	private String distCode;

	@Column(name = "blockortehsil")
	private String mandCode;

	@Column(name = "village")
	private String villCode;

	@Column(name = "wbmcode")
	private Integer wbMcode;

	@Column(name = "wbdcode")
	private Integer wbDcode;

	@Column(name = "wbvcode")
	private Integer wbvcode;

	@OneToOne
	@JoinColumn(name = "usertype", insertable = false, updatable = false)
	private UserTypesEntity userTypesEntity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadhaar_id() {
		return aadhaar_id;
	}

	public void setAadhaar_id(String aadhaar_id) {
		this.aadhaar_id = aadhaar_id;
	}

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String type_user) {
		this.type_user = type_user;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEncpassword() {
		return encpassword;
	}

	public void setEncpassword(String encpassword) {
		this.encpassword = encpassword;
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getMandCode() {
		return mandCode;
	}

	public void setMandCode(String mandCode) {
		this.mandCode = mandCode;
	}

	public String getVillCode() {
		return villCode;
	}

	public void setVillCode(String villCode) {
		this.villCode = villCode;
	}

	public Integer getWbMcode() {
		return wbMcode;
	}

	public void setWbMcode(Integer wbMcode) {
		this.wbMcode = wbMcode;
	}

	public UserTypesEntity getUserTypesEntity() {
		return userTypesEntity;
	}

	public void setUserTypesEntity(UserTypesEntity userTypesEntity) {
		this.userTypesEntity = userTypesEntity;
	}

	public Integer getWbDcode() {
		return wbDcode;
	}

	public void setWbDcode(Integer wbDcode) {
		this.wbDcode = wbDcode;
	}

	public Integer getWbvcode() {
		return wbvcode;
	}

	public void setWbvcode(Integer wbvcode) {
		this.wbvcode = wbvcode;
	}

}