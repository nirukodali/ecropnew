package com.ecrops.dto.webland;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCRCCropData {

	@JsonProperty("ccrc_id")
	private String ccrc_id;

	@JsonProperty("Doc_Id")
	private String Doc_Id;

	@JsonProperty("District")
	private String District;

	@JsonProperty("DName")
	private String DName;

	@JsonProperty("Mandal")
	private String Mandal;

	@JsonProperty("MName")
	private String MName;

	@JsonProperty("Village")
	private String Village;

	@JsonProperty("VName")
	private String VName;

	@JsonProperty("NameOf_TheLandOwner")
	private String NameOf_TheLandOwner;

	@JsonProperty("LandOwnerFather")
	private String LandOwnerFather;

	@JsonProperty("Tenant_Aadhar")
	private String Tenant_Aadhar;

	@JsonProperty("NameOf_TheTenantFarmer")
	private String NameOf_TheTenantFarmer;

	@JsonProperty("TenantFather")
	private String TenantFather;

	@JsonProperty("Caste")
	private String Caste;

	@JsonProperty("khata_no")
	private String khata_no;

	@JsonProperty("Survey_No")
	private String Survey_No;

	@JsonProperty("webland_total_extent")
	private String webland_total_extent;

	@JsonProperty("webland_occupant_extent")
	private String webland_occupant_extent;

	@JsonProperty("land_nature")
	private String land_nature;

	@JsonProperty("Card_Extent")
	private String Card_Extent;

	@JsonProperty("Enroll_Date")
	private String Enroll_Date;

	@JsonProperty("Enroll_End_Date")
	private String Enroll_End_Date;

	@JsonProperty("TenantAddress")
	private String TenantAddress;

	@JsonProperty("TenantMobile")
	private String TenantMobile;

	@JsonProperty("TenantGender")
	private String TenantGender;

	@JsonProperty("webland_Uncultivated_Land")
	private String webland_Uncultivated_Land;

	@JsonProperty("webland_Cultivatable_Land")
	private String webland_Cultivatable_Land;

	@JsonProperty("webland_Occupant_Name")
	private String webland_Occupant_Name;

	@JsonProperty("webland_Occupant_Father_Name")
	private String webland_Occupant_Father_Name;

	public CCRCCropData(String ccrc_id, String doc_Id, String district, String dName, String mandal, String mName,
			String village, String vName, String nameOf_TheLandOwner, String landOwnerFather, String tenant_Aadhar,
			String nameOf_TheTenantFarmer, String tenantFather, String caste, String khata_no, String survey_No,
			String webland_total_extent, String webland_occupant_extent, String land_nature, String card_Extent,
			String enroll_Date, String enroll_End_Date, String tenantAddress, String tenantMobile, String tenantGender,
			String webland_Uncultivated_Land, String webland_Cultivatable_Land, String webland_Occupant_Name,
			String webland_Occupant_Father_Name) {
		super();
		this.ccrc_id = ccrc_id;
		Doc_Id = doc_Id;
		District = district;
		DName = dName;
		Mandal = mandal;
		MName = mName;
		Village = village;
		VName = vName;
		NameOf_TheLandOwner = nameOf_TheLandOwner;
		LandOwnerFather = landOwnerFather;
		Tenant_Aadhar = tenant_Aadhar;
		NameOf_TheTenantFarmer = nameOf_TheTenantFarmer;
		TenantFather = tenantFather;
		Caste = caste;
		this.khata_no = khata_no;
		Survey_No = survey_No;
		this.webland_total_extent = webland_total_extent;
		this.webland_occupant_extent = webland_occupant_extent;
		this.land_nature = land_nature;
		Card_Extent = card_Extent;
		Enroll_Date = enroll_Date;
		Enroll_End_Date = enroll_End_Date;
		TenantAddress = tenantAddress;
		TenantMobile = tenantMobile;
		TenantGender = tenantGender;
		this.webland_Uncultivated_Land = webland_Uncultivated_Land;
		this.webland_Cultivatable_Land = webland_Cultivatable_Land;
		this.webland_Occupant_Name = webland_Occupant_Name;
		this.webland_Occupant_Father_Name = webland_Occupant_Father_Name;
	}
	
	public CCRCCropData() {
		
	}

	public String getCcrc_id() {
		return ccrc_id;
	}

	public void setCcrc_id(String ccrc_id) {
		this.ccrc_id = ccrc_id;
	}

	public String getDoc_Id() {
		return Doc_Id;
	}

	public void setDoc_Id(String doc_Id) {
		Doc_Id = doc_Id;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getMandal() {
		return Mandal;
	}

	public void setMandal(String mandal) {
		Mandal = mandal;
	}

	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}

	public String getVillage() {
		return Village;
	}

	public void setVillage(String village) {
		Village = village;
	}

	public String getVName() {
		return VName;
	}

	public void setVName(String vName) {
		VName = vName;
	}

	public String getNameOf_TheLandOwner() {
		return NameOf_TheLandOwner;
	}

	public void setNameOf_TheLandOwner(String nameOf_TheLandOwner) {
		NameOf_TheLandOwner = nameOf_TheLandOwner;
	}

	public String getLandOwnerFather() {
		return LandOwnerFather;
	}

	public void setLandOwnerFather(String landOwnerFather) {
		LandOwnerFather = landOwnerFather;
	}

	public String getTenant_Aadhar() {
		return Tenant_Aadhar;
	}

	public void setTenant_Aadhar(String tenant_Aadhar) {
		Tenant_Aadhar = tenant_Aadhar;
	}

	public String getNameOf_TheTenantFarmer() {
		return NameOf_TheTenantFarmer;
	}

	public void setNameOf_TheTenantFarmer(String nameOf_TheTenantFarmer) {
		NameOf_TheTenantFarmer = nameOf_TheTenantFarmer;
	}

	public String getTenantFather() {
		return TenantFather;
	}

	public void setTenantFather(String tenantFather) {
		TenantFather = tenantFather;
	}

	public String getCaste() {
		return Caste;
	}

	public void setCaste(String caste) {
		Caste = caste;
	}

	public String getKhata_no() {
		return khata_no;
	}

	public void setKhata_no(String khata_no) {
		this.khata_no = khata_no;
	}

	public String getSurvey_No() {
		return Survey_No;
	}

	public void setSurvey_No(String survey_No) {
		Survey_No = survey_No;
	}

	public String getWebland_total_extent() {
		return webland_total_extent;
	}

	public void setWebland_total_extent(String webland_total_extent) {
		this.webland_total_extent = webland_total_extent;
	}

	public String getWebland_occupant_extent() {
		return webland_occupant_extent;
	}

	public void setWebland_occupant_extent(String webland_occupant_extent) {
		this.webland_occupant_extent = webland_occupant_extent;
	}

	public String getLand_nature() {
		return land_nature;
	}

	public void setLand_nature(String land_nature) {
		this.land_nature = land_nature;
	}

	public String getCard_Extent() {
		return Card_Extent;
	}

	public void setCard_Extent(String card_Extent) {
		Card_Extent = card_Extent;
	}

	public String getEnroll_Date() {
		return Enroll_Date;
	}

	public void setEnroll_Date(String enroll_Date) {
		Enroll_Date = enroll_Date;
	}

	public String getEnroll_End_Date() {
		return Enroll_End_Date;
	}

	public void setEnroll_End_Date(String enroll_End_Date) {
		Enroll_End_Date = enroll_End_Date;
	}

	public String getTenantAddress() {
		return TenantAddress;
	}

	public void setTenantAddress(String tenantAddress) {
		TenantAddress = tenantAddress;
	}

	public String getTenantMobile() {
		return TenantMobile;
	}

	public void setTenantMobile(String tenantMobile) {
		TenantMobile = tenantMobile;
	}

	public String getTenantGender() {
		return TenantGender;
	}

	public void setTenantGender(String tenantGender) {
		TenantGender = tenantGender;
	}

	public String getWebland_Uncultivated_Land() {
		return webland_Uncultivated_Land;
	}

	public void setWebland_Uncultivated_Land(String webland_Uncultivated_Land) {
		this.webland_Uncultivated_Land = webland_Uncultivated_Land;
	}

	public String getWebland_Cultivatable_Land() {
		return webland_Cultivatable_Land;
	}

	public void setWebland_Cultivatable_Land(String webland_Cultivatable_Land) {
		this.webland_Cultivatable_Land = webland_Cultivatable_Land;
	}

	public String getWebland_Occupant_Name() {
		return webland_Occupant_Name;
	}

	public void setWebland_Occupant_Name(String webland_Occupant_Name) {
		this.webland_Occupant_Name = webland_Occupant_Name;
	}

	public String getWebland_Occupant_Father_Name() {
		return webland_Occupant_Father_Name;
	}

	public void setWebland_Occupant_Father_Name(String webland_Occupant_Father_Name) {
		this.webland_Occupant_Father_Name = webland_Occupant_Father_Name;
	}

	@Override
	public String toString() {
		return "CCRCCropData [ccrc_id=" + ccrc_id + ", Doc_Id=" + Doc_Id + ", District=" + District + ", DName=" + DName
				+ ", Mandal=" + Mandal + ", MName=" + MName + ", Village=" + Village + ", VName=" + VName
				+ ", NameOf_TheLandOwner=" + NameOf_TheLandOwner + ", LandOwnerFather=" + LandOwnerFather
				+ ", Tenant_Aadhar=" + Tenant_Aadhar + ", NameOf_TheTenantFarmer=" + NameOf_TheTenantFarmer
				+ ", TenantFather=" + TenantFather + ", Caste=" + Caste + ", khata_no=" + khata_no + ", Survey_No="
				+ Survey_No + ", webland_total_extent=" + webland_total_extent + ", webland_occupant_extent="
				+ webland_occupant_extent + ", land_nature=" + land_nature + ", Card_Extent=" + Card_Extent
				+ ", Enroll_Date=" + Enroll_Date + ", Enroll_End_Date=" + Enroll_End_Date + ", TenantAddress="
				+ TenantAddress + ", TenantMobile=" + TenantMobile + ", TenantGender=" + TenantGender
				+ ", webland_Uncultivated_Land=" + webland_Uncultivated_Land + ", webland_Cultivatable_Land="
				+ webland_Cultivatable_Land + ", webland_Occupant_Name=" + webland_Occupant_Name
				+ ", webland_Occupant_Father_Name=" + webland_Occupant_Father_Name + "]";
	}
}
