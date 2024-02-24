package com.ecrops.dto.crop.response;

public class CcrcCropDetails {
    private Integer ccrcId;
    private String docId;
    private Integer district;
    private String dName;
    private Integer mandal;
    private String mName;
    private Integer village;
    private String vName;
    private String nameOfTheLandOwner;
    private String landOwnerFather;
    private String tenantAadhar;
    private String nameOfTheTenantFarmer;
    private String tenantFather;
    private String caste;
    private Integer khataNo;
    private String surveyNo;
    private double weblandTotalExtent;
    private double weblandOccupantExtent;
    private String landNature;
    private double cardExtent;
    private String enrollDate;
    private String enrollEndDate;
    private String tenantAddress;
    private long tenantMobile;
    private String tenantGender;
    private double weblandUncultivatedLand;
    private double weblandCultivatableLand;
    private String weblandOccupantName;
    private String weblandOccupantFatherName;
    
    
    
    public CcrcCropDetails() {
        // Default constructor, you can leave it empty or initialize default values
    }



    // Constructor
    public CcrcCropDetails(Integer ccrcId, String docId, Integer district, String dName, Integer mandal, String mName, Integer village, String vName, String nameOfTheLandOwner, String landOwnerFather, String tenantAadhar, String nameOfTheTenantFarmer, String tenantFather, String caste, Integer khataNo, String surveyNo, double weblandTotalExtent, double weblandOccupantExtent, String landNature, double cardExtent, String enrollDate, String enrollEndDate, String tenantAddress, long tenantMobile, String tenantGender, double weblandUncultivatedLand, double weblandCultivatableLand, String weblandOccupantName, String weblandOccupantFatherName) {
        this.ccrcId = ccrcId;
        this.docId = docId;
        this.district = district;
        this.dName = dName;
        this.mandal = mandal;
        this.mName = mName;
        this.village = village;
        this.vName = vName;
        this.nameOfTheLandOwner = nameOfTheLandOwner;
        this.landOwnerFather = landOwnerFather;
        this.tenantAadhar = tenantAadhar;
        this.nameOfTheTenantFarmer = nameOfTheTenantFarmer;
        this.tenantFather = tenantFather;
        this.caste = caste;
        this.khataNo = khataNo;
        this.surveyNo = surveyNo;
        this.weblandTotalExtent = weblandTotalExtent;
        this.weblandOccupantExtent = weblandOccupantExtent;
        this.landNature = landNature;
        this.cardExtent = cardExtent;
        this.enrollDate = enrollDate;
        this.enrollEndDate = enrollEndDate;
        this.tenantAddress = tenantAddress;
        this.tenantMobile = tenantMobile;
        this.tenantGender = tenantGender;
        this.weblandUncultivatedLand = weblandUncultivatedLand;
        this.weblandCultivatableLand = weblandCultivatableLand;
        this.weblandOccupantName = weblandOccupantName;
        this.weblandOccupantFatherName = weblandOccupantFatherName;
    }


	public Integer getCcrcId() {
		return ccrcId;
	}


	public void setCcrcId(Integer ccrcId) {
		this.ccrcId = ccrcId;
	}


	public String getDocId() {
		return docId;
	}


	public void setDocId(String docId) {
		this.docId = docId;
	}


	public Integer getDistrict() {
		return district;
	}


	public void setDistrict(Integer district) {
		this.district = district;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	public Integer getMandal() {
		return mandal;
	}


	public void setMandal(Integer mandal) {
		this.mandal = mandal;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public Integer getVillage() {
		return village;
	}


	public void setVillage(Integer village) {
		this.village = village;
	}


	public String getvName() {
		return vName;
	}


	public void setvName(String vName) {
		this.vName = vName;
	}


	public String getNameOfTheLandOwner() {
		return nameOfTheLandOwner;
	}


	public void setNameOfTheLandOwner(String nameOfTheLandOwner) {
		this.nameOfTheLandOwner = nameOfTheLandOwner;
	}


	public String getLandOwnerFather() {
		return landOwnerFather;
	}


	public void setLandOwnerFather(String landOwnerFather) {
		this.landOwnerFather = landOwnerFather;
	}


	public String getTenantAadhar() {
		return tenantAadhar;
	}


	public void setTenantAadhar(String tenantAadhar) {
		this.tenantAadhar = tenantAadhar;
	}


	public String getNameOfTheTenantFarmer() {
		return nameOfTheTenantFarmer;
	}


	public void setNameOfTheTenantFarmer(String nameOfTheTenantFarmer) {
		this.nameOfTheTenantFarmer = nameOfTheTenantFarmer;
	}


	public String getTenantFather() {
		return tenantFather;
	}


	public void setTenantFather(String tenantFather) {
		this.tenantFather = tenantFather;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public Integer getKhataNo() {
		return khataNo;
	}


	public void setKhataNo(Integer khataNo) {
		this.khataNo = khataNo;
	}


	public String getSurveyNo() {
		return surveyNo;
	}


	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}


	public double getWeblandTotalExtent() {
		return weblandTotalExtent;
	}


	public void setWeblandTotalExtent(double weblandTotalExtent) {
		this.weblandTotalExtent = weblandTotalExtent;
	}


	public double getWeblandOccupantExtent() {
		return weblandOccupantExtent;
	}


	public void setWeblandOccupantExtent(double weblandOccupantExtent) {
		this.weblandOccupantExtent = weblandOccupantExtent;
	}


	public String getLandNature() {
		return landNature;
	}


	public void setLandNature(String landNature) {
		this.landNature = landNature;
	}


	public double getCardExtent() {
		return cardExtent;
	}


	public void setCardExtent(double cardExtent) {
		this.cardExtent = cardExtent;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getEnrollEndDate() {
		return enrollEndDate;
	}


	public void setEnrollEndDate(String enrollEndDate) {
		this.enrollEndDate = enrollEndDate;
	}


	public String getTenantAddress() {
		return tenantAddress;
	}


	public void setTenantAddress(String tenantAddress) {
		this.tenantAddress = tenantAddress;
	}


	public long getTenantMobile() {
		return tenantMobile;
	}


	public void setTenantMobile(long tenantMobile) {
		this.tenantMobile = tenantMobile;
	}


	public String getTenantGender() {
		return tenantGender;
	}


	public void setTenantGender(String tenantGender) {
		this.tenantGender = tenantGender;
	}


	public double getWeblandUncultivatedLand() {
		return weblandUncultivatedLand;
	}


	public void setWeblandUncultivatedLand(double weblandUncultivatedLand) {
		this.weblandUncultivatedLand = weblandUncultivatedLand;
	}


	public double getWeblandCultivatableLand() {
		return weblandCultivatableLand;
	}


	public void setWeblandCultivatableLand(double weblandCultivatableLand) {
		this.weblandCultivatableLand = weblandCultivatableLand;
	}


	public String getWeblandOccupantName() {
		return weblandOccupantName;
	}


	public void setWeblandOccupantName(String weblandOccupantName) {
		this.weblandOccupantName = weblandOccupantName;
	}


	public String getWeblandOccupantFatherName() {
		return weblandOccupantFatherName;
	}


	public void setWeblandOccupantFatherName(String weblandOccupantFatherName) {
		this.weblandOccupantFatherName = weblandOccupantFatherName;
	}


	@Override
	public String toString() {
		return "CcrcCropDetails [ccrcId=" + ccrcId + ", docId=" + docId + ", district=" + district + ", dName=" + dName
				+ ", mandal=" + mandal + ", mName=" + mName + ", village=" + village + ", vName=" + vName
				+ ", nameOfTheLandOwner=" + nameOfTheLandOwner + ", landOwnerFather=" + landOwnerFather
				+ ", tenantAadhar=" + tenantAadhar + ", nameOfTheTenantFarmer=" + nameOfTheTenantFarmer
				+ ", tenantFather=" + tenantFather + ", caste=" + caste + ", khataNo=" + khataNo + ", surveyNo="
				+ surveyNo + ", weblandTotalExtent=" + weblandTotalExtent + ", weblandOccupantExtent="
				+ weblandOccupantExtent + ", landNature=" + landNature + ", cardExtent=" + cardExtent + ", enrollDate="
				+ enrollDate + ", enrollEndDate=" + enrollEndDate + ", tenantAddress=" + tenantAddress
				+ ", tenantMobile=" + tenantMobile + ", tenantGender=" + tenantGender + ", weblandUncultivatedLand="
				+ weblandUncultivatedLand + ", weblandCultivatableLand=" + weblandCultivatableLand
				+ ", weblandOccupantName=" + weblandOccupantName + ", weblandOccupantFatherName="
				+ weblandOccupantFatherName + ", getCcrcId()=" + getCcrcId() + ", getDocId()=" + getDocId()
				+ ", getDistrict()=" + getDistrict() + ", getdName()=" + getdName() + ", getMandal()=" + getMandal()
				+ ", getmName()=" + getmName() + ", getVillage()=" + getVillage() + ", getvName()=" + getvName()
				+ ", getNameOfTheLandOwner()=" + getNameOfTheLandOwner() + ", getLandOwnerFather()="
				+ getLandOwnerFather() + ", getTenantAadhar()=" + getTenantAadhar() + ", getNameOfTheTenantFarmer()="
				+ getNameOfTheTenantFarmer() + ", getTenantFather()=" + getTenantFather() + ", getCaste()=" + getCaste()
				+ ", getKhataNo()=" + getKhataNo() + ", getSurveyNo()=" + getSurveyNo() + ", getWeblandTotalExtent()="
				+ getWeblandTotalExtent() + ", getWeblandOccupantExtent()=" + getWeblandOccupantExtent()
				+ ", getLandNature()=" + getLandNature() + ", getCardExtent()=" + getCardExtent() + ", getEnrollDate()="
				+ getEnrollDate() + ", getEnrollEndDate()=" + getEnrollEndDate() + ", getTenantAddress()="
				+ getTenantAddress() + ", getTenantMobile()=" + getTenantMobile() + ", getTenantGender()="
				+ getTenantGender() + ", getWeblandUncultivatedLand()=" + getWeblandUncultivatedLand()
				+ ", getWeblandCultivatableLand()=" + getWeblandCultivatableLand() + ", getWeblandOccupantName()="
				+ getWeblandOccupantName() + ", getWeblandOccupantFatherName()=" + getWeblandOccupantFatherName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
    



}
