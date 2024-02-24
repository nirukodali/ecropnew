package com.ecrops.model;

public class RequestModel {
	private String dcode;
	private String mcode;
	private String cropyear;
	private String season;
	private String userid;
	private String wbdcode;
	private String wbmcode;
	private String wbvode;
	private String vcode;
	private String  crop;
	private String  bookingid;
	private String  year;
	private String cropgrpid;
	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestModel(String dcode, String mcode, String cropyear, String season, String userid, String wbdcode,
			String wbmcode, String wbvode, String vcode, String crop, String bookingid, String year, String cropgrpid) {
		super();
		this.dcode = dcode;
		this.mcode = mcode;
		this.cropyear = cropyear;
		this.season = season;
		this.userid = userid;
		this.wbdcode = wbdcode;
		this.wbmcode = wbmcode;
		this.wbvode = wbvode;
		this.vcode = vcode;
		this.crop = crop;
		this.bookingid = bookingid;
		this.year = year;
		this.cropgrpid = cropgrpid;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getCropyear() {
		return cropyear;
	}
	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWbdcode() {
		return wbdcode;
	}
	public void setWbdcode(String wbdcode) {
		this.wbdcode = wbdcode;
	}
	public String getWbmcode() {
		return wbmcode;
	}
	public void setWbmcode(String wbmcode) {
		this.wbmcode = wbmcode;
	}
	public String getWbvode() {
		return wbvode;
	}
	public void setWbvode(String wbvode) {
		this.wbvode = wbvode;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCropgrpid() {
		return cropgrpid;
	}
	public void setCropgrpid(String cropgrpid) {
		this.cropgrpid = cropgrpid;
	}
	@Override
	public String toString() {
		return "RequestModel [dcode=" + dcode + ", mcode=" + mcode + ", cropyear=" + cropyear + ", season=" + season
				+ ", userid=" + userid + ", wbdcode=" + wbdcode + ", wbmcode=" + wbmcode + ", wbvode=" + wbvode
				+ ", vcode=" + vcode + ", crop=" + crop + ", bookingid=" + bookingid + ", year=" + year + ", cropgrpid="
				+ cropgrpid + "]";
	}
	
}
