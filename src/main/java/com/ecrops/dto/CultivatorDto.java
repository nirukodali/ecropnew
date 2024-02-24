package com.ecrops.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cr_booking",schema = "ecrop2023")
public class CultivatorDto {

	@EmbeddedId
	CultivatorEmbedableDto cultivatorEmbedableDto;

	@Column(name = "cr_sno")
	private String crSno;

	@Column(name = "tot_extent")
	private Float totalExtent;

	@Column(name = "cr_farmeruid")
	private String aadharNo;

	@Column(name = "oc_fname")
	private String fatherName;

	@Column(name = "occupant_extent")
	private Float occupantExtent;

	@Column(name = "kh_no")
	private Integer khNo;

	@Column(name = "oc_name")
	private String ocName;

	@Column(name = "cr_vcode")
	private Integer cr_vcode;

	@Column(name = "cr_year")
	private Integer cr_year;

	@Column(name = "cr_season")
	private String cr_season;

	@Column(name = "owner_tenant")
	private String owner_tenant;

	@Column(name = "refbookingid")
	private Integer refBookingId;

	@Column(name = "cultivator_type")
	private String cultivatorType;

	@Column(name = "anubhavadar_extent")
	private Float anubhavadarExtent;

	@Column(name = "cr_dist_code")
	private Integer crDistCode;

	@Column(name = "cr_mand_code")
	private Integer crMandCode;

	@Column(name = "updatedby", insertable = true, updatable = true)
	private String updatedby;

	@Column(name = "updateon")
	private Timestamp updateon;
	
	@Column(name = "cult_updatedby", insertable = true, updatable = true)
	private String cult_updatedby;
	
	@Column(name = "cult_updateon")
	private Timestamp cult_updateon;

	@Column(name = "dcode")
	private Integer dcode;

	@Column(name = "mcode")
	private Integer mcode;

	@Column(name = "downloaded", insertable = false, updatable = false)
	private String downloaded;
	
	@Column(name="peri_status", insertable = true, updatable = true)
	private String peri_status;
	
	@Column(name = "regno", insertable = true, updatable = true)
    private Integer regno;

    @Column(name = "cr_wsno", insertable = true, updatable = true)
    private Integer cr_wsno;

    @Column(name = "geo_reffered", insertable = true, updatable = true)
    private String geo_reffered;

    @Column(name = "rec_id", insertable = true, updatable = true)
    private Integer rec_id;

    @Column(name = "vs_sel", insertable = true, updatable = true)
    private String vs_sel;
    
    
    @Column(name = "anubhavadar_name", insertable = true, updatable = true)
    private String anubhavadar_name;
    
    @Column(name = "occupname")
    private String occupname;

    @Column(name = "occupfname")
    private String occupfname;


    @Column(name = "data_src", insertable = true, updatable = false)
    private String data_src;
    
    @Column(name = "emp_code", insertable = true, updatable = false)
    private Integer emp_code;


    @Column(name = "mobileno", insertable = true, updatable = false)
    private Integer mobileno;

    @Column(name = "sjointoccupant", insertable = true, updatable = false)
    private Integer sjointoccupant;

    @Column(name = "cr_tr_d_ext", insertable = true, updatable = false)
    private Double cr_tr_d_ext;
    
    @Column(name = "cr_tr_i_ext", insertable = true, updatable = false)
    private Double cr_tr_i_ext;
    
    
    
    

	public String getOccupname() {
		return occupname;
	}

	public void setOccupname(String occupname) {
		this.occupname = occupname;
	}

	public String getOccupfname() {
		return occupfname;
	}

	public void setOccupfname(String occupfname) {
		this.occupfname = occupfname;
	}

	public CultivatorEmbedableDto getCultivatorEmbedableDto() {
		return cultivatorEmbedableDto;
	}

	public void setCultivatorEmbedableDto(CultivatorEmbedableDto cultivatorEmbedableDto) {
		this.cultivatorEmbedableDto = cultivatorEmbedableDto;
	}

	public String getCrSno() {
		return crSno;
	}

	public void setCrSno(String crSno) {
		this.crSno = crSno;
	}

	public Float getTotalExtent() {
		return totalExtent;
	}

	public void setTotalExtent(Float totalExtent) {
		this.totalExtent = totalExtent;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Float getOccupantExtent() {
		return occupantExtent;
	}

	public void setOccupantExtent(Float occupantExtent) {
		this.occupantExtent = occupantExtent;
	}

	public Integer getKhNo() {
		return khNo;
	}

	public void setKhNo(Integer khNo) {
		this.khNo = khNo;
	}

	public String getOcName() {
		return ocName;
	}

	public void setOcName(String ocName) {
		this.ocName = ocName;
	}

	public Integer getCr_vcode() {
		return cr_vcode;
	}

	public void setCr_vcode(Integer cr_vcode) {
		this.cr_vcode = cr_vcode;
	}

	public Integer getCr_year() {
		return cr_year;
	}

	public void setCr_year(Integer cr_year) {
		this.cr_year = cr_year;
	}

	public String getCr_season() {
		return cr_season;
	}

	public void setCr_season(String cr_season) {
		this.cr_season = cr_season;
	}

	public String getOwner_tenant() {
		return owner_tenant;
	}

	public void setOwner_tenant(String owner_tenant) {
		this.owner_tenant = owner_tenant;
	}

	public Integer getRefBookingId() {
		return refBookingId;
	}

	public void setRefBookingId(Integer refBookingId) {
		this.refBookingId = refBookingId;
	}

	public String getCultivatorType() {
		return cultivatorType;
	}

	public void setCultivatorType(String cultivatorType) {
		this.cultivatorType = cultivatorType;
	}

	public Float getAnubhavadarExtent() {
		return anubhavadarExtent;
	}

	public void setAnubhavadarExtent(Float anubhavadarExtent) {
		this.anubhavadarExtent = anubhavadarExtent;
	}

	public Integer getCrDistCode() {
		return crDistCode;
	}

	public void setCrDistCode(Integer crDistCode) {
		this.crDistCode = crDistCode;
	}

	public Integer getCrMandCode() {
		return crMandCode;
	}

	public void setCrMandCode(Integer crMandCode) {
		this.crMandCode = crMandCode;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Timestamp getUpdateon() {
		return updateon;
	}

	public void setUpdateon(Timestamp updateon) {
		this.updateon = updateon;
	}

	public String getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(String downloaded) {
		this.downloaded = downloaded;
	}

	public String getCult_updatedby() {
		return cult_updatedby;
	}

	public void setCult_updatedby(String cult_updatedby) {
		this.cult_updatedby = cult_updatedby;
	}

	public Timestamp getCult_updateon() {
		return cult_updateon;
	}

	public void setCult_updateon(Timestamp cult_updateon) {
		this.cult_updateon = cult_updateon;
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

	public String getPeri_status() {
		return peri_status;
	}

	public void setPeri_status(String peri_status) {
		this.peri_status = peri_status;
	}

	public Integer getRegno() {
		return regno;
	}

	public void setRegno(Integer regno) {
		this.regno = regno;
	}

	public Integer getCr_wsno() {
		return cr_wsno;
	}

	public void setCr_wsno(Integer cr_wsno) {
		this.cr_wsno = cr_wsno;
	}

	public String getGeo_reffered() {
		return geo_reffered;
	}

	public void setGeo_reffered(String geo_reffered) {
		this.geo_reffered = geo_reffered;
	}

	public Integer getRec_id() {
		return rec_id;
	}

	public void setRec_id(Integer rec_id) {
		this.rec_id = rec_id;
	}

	public String getVs_sel() {
		return vs_sel;
	}

	public void setVs_sel(String vs_sel) {
		this.vs_sel = vs_sel;
	}

	public String getAnubhavadar_name() {
		return anubhavadar_name;
	}

	public void setAnubhavadar_name(String anubhavadar_name) {
		this.anubhavadar_name = anubhavadar_name;
	}

	public String getData_src() {
		return data_src;
	}

	public void setData_src(String data_src) {
		this.data_src = data_src;
	}

	public Integer getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(Integer emp_code) {
		this.emp_code = emp_code;
	}

	public Integer getMobileno() {
		return mobileno;
	}

	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}

	public Integer getSjointoccupant() {
		return sjointoccupant;
	}

	public void setSjointoccupant(Integer sjointoccupant) {
		this.sjointoccupant = sjointoccupant;
	}

	public Double getCr_tr_d_ext() {
		return cr_tr_d_ext;
	}

	public void setCr_tr_d_ext(Double cr_tr_d_ext) {
		this.cr_tr_d_ext = cr_tr_d_ext;
	}

	public Double getCr_tr_i_ext() {
		return cr_tr_i_ext;
	}

	public void setCr_tr_i_ext(Double cr_tr_i_ext) {
		this.cr_tr_i_ext = cr_tr_i_ext;
	}
	
	
	
}
