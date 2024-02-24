package com.ecrops.dto;

import javax.persistence.Column;

public class VroRejectReasonsDto {
	    @Column(name="bookingid")
	    private int bookingId;

	    @Column(name="kh_no")
	    private String khathaNo;

	    @Column(name="cr_sno")
	    private String surveyNo;

	    @Column(name="tot_extent")
	    private double totalExtent;

	    @Column(name="cropname")
	    private String cropName;

	    @Column(name="oc_name")
	    private String farmerName;

	    @Column(name="oc_fname")
	    private String farmerFatherName;

	    @Column(name="cr_no")
	    private int cropNumber;

	    @Column(name="vname")
	    private String varietyName;

	    @Column(name="cr_farmeruid")
	    private String aadhaarNo;

	    public VroRejectReasonsDto() {
	        // Default constructor
	    }

	    public VroRejectReasonsDto(int bookingId, String khathaNo, String surveyNo, double totalExtent,
	                               String cropName, String farmerName, String farmerFatherName, int cropNumber,
	                               String varietyName, String aadhaarNo) {
	        this.bookingId = bookingId;
	        this.khathaNo = khathaNo;
	        this.surveyNo = surveyNo;
	        this.totalExtent = totalExtent;
	        this.cropName = cropName;
	        this.farmerName = farmerName;
	        this.farmerFatherName = farmerFatherName;
	        this.cropNumber = cropNumber;
	        this.varietyName = varietyName;
	        this.aadhaarNo = aadhaarNo;
	    }

	    public int getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(int bookingId) {
	        this.bookingId = bookingId;
	    }

	    public String getKhathaNo() {
	        return khathaNo;
	    }

	    public void setKhathaNo(String khathaNo) {
	        this.khathaNo = khathaNo;
	    }

	    public String getSurveyNo() {
	        return surveyNo;
	    }

	    public void setSurveyNo(String surveyNo) {
	        this.surveyNo = surveyNo;
	    }

	    public double getTotalExtent() {
	        return totalExtent;
	    }

	    public void setTotalExtent(double totalExtent) {
	        this.totalExtent = totalExtent;
	    }

	    public String getCropName() {
	        return cropName;
	    }

	    public void setCropName(String cropName) {
	        this.cropName = cropName;
	    }

	    public String getFarmerName() {
	        return farmerName;
	    }

	    public void setFarmerName(String farmerName) {
	        this.farmerName = farmerName;
	    }

	    public String getFarmerFatherName() {
	        return farmerFatherName;
	    }

	    public void setFarmerFatherName(String farmerFatherName) {
	        this.farmerFatherName = farmerFatherName;
	    }

	    public int getCropNumber() {
	        return cropNumber;
	    }

	    public void setCropNumber(int cropNumber) {
	        this.cropNumber = cropNumber;
	    }

	    public String getVarietyName() {
	        return varietyName;
	    }

	    public void setVarietyName(String varietyName) {
	        this.varietyName = varietyName;
	    }

	    public String getAadhaarNo() {
	        return aadhaarNo;
	    }

	    public void setAadhaarNo(String aadhaarNo) {
	        this.aadhaarNo = aadhaarNo;
	    }

	    @Override
	    public String toString() {
	        return "VroRejectReasonsDto{" +
	                "bookingId=" + bookingId +
	                ", khathaNo='" + khathaNo + '\'' +
	                ", surveyNo='" + surveyNo + '\'' +
	                ", totalExtent=" + totalExtent +
	                ", cropName='" + cropName + '\'' +
	                ", farmerName='" + farmerName + '\'' +
	                ", farmerFatherName='" + farmerFatherName + '\'' +
	                ", cropNumber=" + cropNumber +
	                ", varietyName='" + varietyName + '\'' +
	                ", aadhaarNo='" + aadhaarNo + '\'' +
	                '}';
	    }
	
}
