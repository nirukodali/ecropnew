package com.ecrops.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VAADetails {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String districtname;
	private String mandalname;
	private String villagename;
	@Id
	private String userid;
	private String name;
	private Integer mobile_phone;
	private String emailid; 
	private Character status;
	public VAADetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VAADetails(String districtname, String mandalname, String villagename, String userid, String name,
			Integer mobile_phone, String emailid, Character status) {
		super();
		this.districtname = districtname;
		this.mandalname = mandalname;
		this.villagename = villagename;
		this.userid = userid;
		this.name = name;
		this.mobile_phone = mobile_phone;
		this.emailid = emailid;
		this.status = status;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getMandalname() {
		return mandalname;
	}
	public void setMandalname(String mandalname) {
		this.mandalname = mandalname;
	}
	public String getVillagename() {
		return villagename;
	}
	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(Integer mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "VAADetails [districtname=" + districtname + ", mandalname=" + mandalname + ", villagename="
				+ villagename + ", userid=" + userid + ", name=" + name + ", mobile_phone=" + mobile_phone
				+ ", emailid=" + emailid + ", status=" + status + "]";
	}
	
	

}
