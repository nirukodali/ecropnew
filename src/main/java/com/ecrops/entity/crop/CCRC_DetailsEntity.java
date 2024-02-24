package com.ecrops.entity.crop;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "ccrc_details", schema = "ecrop2023")
public class CCRC_DetailsEntity {

	// int distCode, int vCode, String season, int cropYear
	// Integer dcode, Integer vcode,Character cr_season,Integer cr_year
	@Id
	@Column(name = "ccrcid")
	private Integer ccrcid;

	@Column(name = "docid")
	private String docid;

	@Column(name = "wbdcode")
	private Integer wbdcode;

	@Column(name = "dname")
	private String dname;

	@Column(name = "wbmcode")
	private Integer wbmcode;

	@Column(name = "mname")
	private String mname;

	@Column(name = "vcode")
	private Integer vcode;

	@Column(name = "vname")
	private String vname;

	@Column(name = "tenantfarmername")
	private String tenantfarmername;

	@Column(name = "rid")
	private Integer rid;

	@Column(name = "kahatano")
	private Integer kahatano;

	@Column(name = "surveyno")
	private String surveyno;

	@Column(name = "extent")
	private Double extent;

	@Column(name = "enrolldate")
	private Date enrolldate;

	@Column(name = "enrollenddate")
	private Date enrollenddate;

	@Column(name = "gender")
	private Character gender;

	@Column(name = "dt_crt")
	private Timestamp dt_crt;

	@Column(name = "caste")
	private Integer caste;

	@Column(name = "cr_year")
	private Integer cr_year;

	@Column(name = "cr_season")
	private Character cr_season;

	@Column(name = "cultivable_land")
	private BigDecimal cultivable_land;

	@Column(name = "uncultivable_land")
	private BigDecimal uncultivable_land;

	@Column(name = "tot_extent")
	private BigDecimal tot_extent;

	@Column(name = "pname")
	private String pname;

	@Column(name = "pfname")
	private String pfname;

	@Column(name = "anubhavadar_extent")
	private BigDecimal anubhavadar_extent;

	@Column(name = "part_key")
	private String part_key;

	@Column(name = "dcode")
	private Integer dcode;

	@Column(name = "mcode")
	private Integer mcode;

	@Column(name = "dtcreated")
	private Timestamp dtcreated;

	@Column(name = "tenantfarmer_fathername")
	private String tenantfarmer_fathername;

	@Column(name = "tenant_aadhar")
	private String tenant_aadhar;

	@Column(name = "land_nature")
	private String land_nature;

	@Column(name = "anubhavdar_name")
	private String anubhavdar_name;

	@Column(name = "anubhavdar_fathername")
	private String anubhavdar_fathername;

	@Column(name = "diff_rec")
	private Character diff_rec;

	public CCRC_DetailsEntity() {
		super();
		this.ccrcid = ccrcid;
		this.docid = docid;
		this.wbdcode = wbdcode;
		this.dname = dname;
		this.wbmcode = wbmcode;
		this.mname = mname;
		this.vcode = vcode;
		this.vname = vname;
		this.tenantfarmername = tenantfarmername;
		this.rid = rid;
		this.kahatano = kahatano;
		this.surveyno = surveyno;
		this.extent = extent;
		this.enrolldate = enrolldate;
		this.enrollenddate = enrollenddate;
		this.gender = gender;
		this.dt_crt = dt_crt;
		this.caste = caste;
		this.cr_year = cr_year;
		this.cr_season = cr_season;
		this.cultivable_land = cultivable_land;
		this.uncultivable_land = uncultivable_land;
		this.tot_extent = tot_extent;
		this.pname = pname;
		this.pfname = pfname;
		this.anubhavadar_extent = anubhavadar_extent;
		this.part_key = part_key;
		this.dcode = dcode;
		this.mcode = mcode;
		this.dtcreated = dtcreated;
		this.tenantfarmer_fathername = tenantfarmer_fathername;
		this.tenant_aadhar = tenant_aadhar;
		this.land_nature = land_nature;
		this.anubhavdar_name = anubhavdar_name;
		this.anubhavdar_fathername = anubhavdar_fathername;
		this.diff_rec = diff_rec;
	}

	public Integer getCcrcid() {
		return ccrcid;
	}

	public void setCcrcid(Integer ccrcid) {
		this.ccrcid = ccrcid;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public Integer getWbdcode() {
		return wbdcode;
	}

	public void setWbdcode(Integer wbdcode) {
		this.wbdcode = wbdcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getWbmcode() {
		return wbmcode;
	}

	public void setWbmcode(Integer wbmcode) {
		this.wbmcode = wbmcode;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getVcode() {
		return vcode;
	}

	public void setVcode(Integer vcode) {
		this.vcode = vcode;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getTenantfarmername() {
		return tenantfarmername;
	}

	public void setTenantfarmername(String tenantfarmername) {
		this.tenantfarmername = tenantfarmername;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getKahatano() {
		return kahatano;
	}

	public void setKahatano(Integer kahatano) {
		this.kahatano = kahatano;
	}

	public String getSurveyno() {
		return surveyno;
	}

	public void setSurveyno(String surveyno) {
		this.surveyno = surveyno;
	}

	public Double getExtent() {
		return extent;
	}

	public void setExtent(Double extent) {
		this.extent = extent;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public Date getEnrollenddate() {
		return enrollenddate;
	}

	public void setEnrollenddate(Date enrollenddate) {
		this.enrollenddate = enrollenddate;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Timestamp getDt_crt() {
		return dt_crt;
	}

	public void setDt_crt(Timestamp dt_crt) {
		this.dt_crt = dt_crt;
	}

	public Integer getCaste() {
		return caste;
	}

	public void setCaste(Integer caste) {
		this.caste = caste;
	}

	public Integer getCr_year() {
		return cr_year;
	}

	public void setCr_year(Integer cr_year) {
		this.cr_year = cr_year;
	}

	public Character getCr_season() {
		return cr_season;
	}

	public void setCr_season(Character cr_season) {
		this.cr_season = cr_season;
	}

	public BigDecimal getCultivable_land() {
		return cultivable_land;
	}

	public void setCultivable_land(BigDecimal cultivable_land) {
		this.cultivable_land = cultivable_land;
	}

	public BigDecimal getUncultivable_land() {
		return uncultivable_land;
	}

	public void setUncultivable_land(BigDecimal uncultivable_land) {
		this.uncultivable_land = uncultivable_land;
	}

	public BigDecimal getTot_extent() {
		return tot_extent;
	}

	public void setTot_extent(BigDecimal tot_extent) {
		this.tot_extent = tot_extent;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPfname() {
		return pfname;
	}

	public void setPfname(String pfname) {
		this.pfname = pfname;
	}

	public BigDecimal getAnubhavadar_extent() {
		return anubhavadar_extent;
	}

	public void setAnubhavadar_extent(BigDecimal anubhavadar_extent) {
		this.anubhavadar_extent = anubhavadar_extent;
	}

	public String getPart_key() {
		return part_key;
	}

	public void setPart_key(String part_key) {
		this.part_key = part_key;
	}

	public Integer getDcode() {
		return dcode;
	}

	public void setDcode(Integer dcode) {
		this.dcode = dcode;
	}

	public Integer getMcode() {
		return mcode;
	}

	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}

	public Timestamp getDtcreated() {
		return dtcreated;
	}

	public void setDtcreated(Timestamp dtcreated) {
		this.dtcreated = dtcreated;
	}

	public String getTenantfarmer_fathername() {
		return tenantfarmer_fathername;
	}

	public void setTenantfarmer_fathername(String tenantfarmer_fathername) {
		this.tenantfarmer_fathername = tenantfarmer_fathername;
	}

	public String getTenant_aadhar() {
		return tenant_aadhar;
	}

	public void setTenant_aadhar(String tenant_aadhar) {
		this.tenant_aadhar = tenant_aadhar;
	}

	public String getLand_nature() {
		return land_nature;
	}

	public void setLand_nature(String land_nature) {
		this.land_nature = land_nature;
	}

	public String getAnubhavdar_name() {
		return anubhavdar_name;
	}

	public void setAnubhavdar_name(String anubhavdar_name) {
		this.anubhavdar_name = anubhavdar_name;
	}

	public String getAnubhavdar_fathername() {
		return anubhavdar_fathername;
	}

	public void setAnubhavdar_fathername(String anubhavdar_fathername) {
		this.anubhavdar_fathername = anubhavdar_fathername;
	}

	public Character getDiff_rec() {
		return diff_rec;
	}

	public void setDiff_rec(Character diff_rec) {
		this.diff_rec = diff_rec;
	}

	@Override
	public String toString() {
		return "CCRC_Details [ccrcid=" + ccrcid + ", docid=" + docid + ", wbdcode=" + wbdcode + ", dname=" + dname
				+ ", wbmcode=" + wbmcode + ", mname=" + mname + ", vcode=" + vcode + ", vname=" + vname
				+ ", tenantfarmername=" + tenantfarmername + ", rid=" + rid + ", kahatano=" + kahatano + ", surveyno="
				+ surveyno + ", extent=" + extent + ", enrolldate=" + enrolldate + ", enrollenddate=" + enrollenddate
				+ ", gender=" + gender + ", dt_crt=" + dt_crt + ", caste=" + caste + ", cr_year=" + cr_year
				+ ", cr_season=" + cr_season + ", cultivable_land=" + cultivable_land + ", uncultivable_land="
				+ uncultivable_land + ", tot_extent=" + tot_extent + ", pname=" + pname + ", pfname=" + pfname
				+ ", anubhavadar_extent=" + anubhavadar_extent + ", part_key=" + part_key + ", dcode=" + dcode
				+ ", mcode=" + mcode + ", dtcreated=" + dtcreated + ", tenantfarmer_fathername="
				+ tenantfarmer_fathername + ", tenant_aadhar=" + tenant_aadhar + ", land_nature=" + land_nature
				+ ", anubhavdar_name=" + anubhavdar_name + ", anubhavdar_fathername=" + anubhavdar_fathername
				+ ", diff_rec=" + diff_rec + "]";
	}

}
