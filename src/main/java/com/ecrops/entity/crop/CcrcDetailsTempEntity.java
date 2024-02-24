package com.ecrops.entity.crop;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ccrc_details_temp")
public class CcrcDetailsTempEntity {
    private int ccrcid;
    private String docid;
    private Integer wbdcode;
    private String dname;
    private Integer wbmcode;
    private String mname;
    private Integer vcode;
    private String vname;
    private String tenantfarmername;
    private Integer rid;
    private Integer khatano;
    private String surveyno;
    private Double extent;
    private Date enrolldate;
    private Date enrollenddate;
    private String gender;
    private Time dtCrt;
    private Integer caste;
    private Integer crYear;
    private String crSeason;
    private BigDecimal cultivableLand;
    private BigDecimal uncultivableLand;
    private BigDecimal totExtent;
    private String pname;
    private String pfname;
    private BigDecimal anubhavadarExtent;
    private String partKey;
    private Integer dcode;
    private Integer mcode;
    private Timestamp dtcreated;
    private String tenantfarmerFathername;
    private String tenantAadhaar;
    private String landNature;
    private String anubhavadarName;
    private String anubhavadarFathername;
    

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

	@Id
    @Column(name = "ccrcid", nullable = false)
    public int getCcrcid() {
        return ccrcid;
    }

    public void setCcrcid(int ccrcid) {
        this.ccrcid = ccrcid;
    }

    @Basic
    @Column(name = "docid", nullable = true, length = 255)
    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }
    @Basic
    @Column(name = "wbdcode", nullable = true)
    public Integer getWbdcode() {
        return wbdcode;
    }

    public void setWbdcode(Integer wbdcode) {
        this.wbdcode = wbdcode;
    }
    @Basic
    @Column(name = "tenantfarmername", nullable = true, length = 255)
    public String getTenantfarmername() {
        return tenantfarmername;
    }

    public void setTenantfarmername(String tenantfarmername) {
        this.tenantfarmername = tenantfarmername;
    }

    @Basic
    @Column(name = "rid", nullable = true)
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "khatano", nullable = true)
    public Integer getKhatano() {
        return khatano;
    }

    public void setKhatano(Integer khatano) {
        this.khatano = khatano;
    }

    @Basic
    @Column(name = "surveyno", nullable = true, length = 255)
    public String getSurveyno() {
        return surveyno;
    }

    public void setSurveyno(String surveyno) {
        this.surveyno = surveyno;
    }

    @Basic
    @Column(name = "extent", nullable = true, precision = 17)
    public Double getExtent() {
        return extent;
    }

    public void setExtent(Double extent) {
        this.extent = extent;
    }

    @Basic
    @Column(name = "enrolldate", nullable = true)
    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Basic
    @Column(name = "enrollenddate", nullable = true)
    public java.sql.Date getEnrollenddate() {
        return enrollenddate;
    }

    public void setEnrollenddate(Date enrollenddate) {
        this.enrollenddate = enrollenddate;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "dt_crt", nullable = true)
    public Time getDtCrt() {
        return dtCrt;
    }

    public void setDtCrt(Time ob) {
        this.dtCrt = ob;
    }

    @Basic
    @Column(name = "caste", nullable = true)
    public Integer getCaste() {
        return caste;
    }

    public void setCaste(Integer caste) {
        this.caste = caste;
    }

    @Basic
    @Column(name = "cr_year", nullable = true)
    public Integer getCrYear() {
        return crYear;
    }

    public void setCrYear(Integer crYear) {
        this.crYear = crYear;
    }

    @Basic
    @Column(name = "cr_season", nullable = true, length = 1)
    public String getCrSeason() {
        return crSeason;
    }

    public void setCrSeason(String crSeason) {
        this.crSeason = crSeason;
    }

    @Basic
    @Column(name = "cultivable_land", nullable = true, precision = 10, scale = 4)
    public BigDecimal getCultivableLand() {
        return cultivableLand;
    }

    public void setCultivableLand(BigDecimal cultivableLand) {
        this.cultivableLand = cultivableLand;
    }

    @Basic
    @Column(name = "uncultivable_land", nullable = true, precision = 10, scale = 4)
    public BigDecimal getUncultivableLand() {
        return uncultivableLand;
    }

    public void setUncultivableLand(BigDecimal uncultivableLand) {
        this.uncultivableLand = uncultivableLand;
    }

    @Basic
    @Column(name = "tot_extent", nullable = true, precision = 10, scale = 4)
    public BigDecimal getTotExtent() {
        return totExtent;
    }

    public void setTotExtent(BigDecimal totExtent) {
        this.totExtent = totExtent;
    }

    @Basic
    @Column(name = "pname", nullable = true, length = 200)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "pfname", nullable = true, length = 200)
    public String getPfname() {
        return pfname;
    }

    public void setPfname(String pfname) {
        this.pfname = pfname;
    }

    @Basic
    @Column(name = "anubhavadar_extent", nullable = true, precision = 10, scale = 4)
    public BigDecimal getAnubhavadarExtent() {
        return anubhavadarExtent;
    }

    public void setAnubhavadarExtent(BigDecimal anubhavadarExtent) {
        this.anubhavadarExtent = anubhavadarExtent;
    }

    @Basic
    @Column(name = "part_key", nullable = true, length = 255)
    public String getPartKey() {
        return partKey;
    }

    public void setPartKey(String partKey) {
        this.partKey = partKey;
    }

    @Basic
    @Column(name = "dcode", nullable = true)
    public Integer getDcode() {
        return dcode;
    }

    public void setDcode(Integer dcode) {
        this.dcode = dcode;
    }

    @Basic
    @Column(name = "mcode", nullable = true)
    public Integer getMcode() {
        return mcode;
    }

    public void setMcode(Integer mcode) {
        this.mcode = mcode;
    }

    @Basic
    @Column(name = "dtcreated", nullable = true)
    public java.sql.Timestamp getDtcreated() {
        return dtcreated;
    }

    public void setDtcreated(Timestamp ob) {
        this.dtcreated = ob;
    }

    @Basic
    @Column(name = "tenantfarmer_fathername", nullable = true, length = 255)
    public String getTenantfarmerFathername() {
        return tenantfarmerFathername;
    }

    public void setTenantfarmerFathername(String tenantfarmerFathername) {
        this.tenantfarmerFathername = tenantfarmerFathername;
    }

    @Basic
    @Column(name = "tenant_aadhaar", nullable = true, length = 12)
    public String getTenantAadhaar() {
        return tenantAadhaar;
    }

    public void setTenantAadhaar(String tenantAadhaar) {
        this.tenantAadhaar = tenantAadhaar;
    }

    @Basic
    @Column(name = "land_nature", nullable = true, length = 255)
    public String getLandNature() {
        return landNature;
    }

    public void setLandNature(String landNature) {
        this.landNature = landNature;
    }

    @Basic
    @Column(name = "anubhavadar_name", nullable = true, length = 255)
    public String getAnubhavadarName() {
        return anubhavadarName;
    }

    public void setAnubhavadarName(String anubhavadarName) {
        this.anubhavadarName = anubhavadarName;
    }

    @Basic
    @Column(name = "anubhavadar_fathername", nullable = true, length = 255)
    public String getAnubhavadarFathername() {
        return anubhavadarFathername;
    }

    public void setAnubhavadarFathername(String anubhavadarFathername) {
        this.anubhavadarFathername = anubhavadarFathername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CcrcDetailsTempEntity that = (CcrcDetailsTempEntity) o;
        return ccrcid == that.ccrcid &&
                Objects.equals(docid, that.docid) &&
                Objects.equals(wbdcode, that.wbdcode) &&
                Objects.equals(dname, that.dname) &&
                Objects.equals(wbmcode, that.wbmcode) &&
                Objects.equals(mname, that.mname) &&
                Objects.equals(vcode, that.vcode) &&
                Objects.equals(vname, that.vname) &&
                Objects.equals(tenantfarmername, that.tenantfarmername) &&
                Objects.equals(rid, that.rid) &&
                Objects.equals(khatano, that.khatano) &&
                Objects.equals(surveyno, that.surveyno) &&
                Objects.equals(extent, that.extent) &&
                Objects.equals(enrolldate, that.enrolldate) &&
                Objects.equals(enrollenddate, that.enrollenddate) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dtCrt, that.dtCrt) &&
                Objects.equals(caste, that.caste) &&
                Objects.equals(crYear, that.crYear) &&
                Objects.equals(crSeason, that.crSeason) &&
                Objects.equals(cultivableLand, that.cultivableLand) &&
                Objects.equals(uncultivableLand, that.uncultivableLand) &&
                Objects.equals(totExtent, that.totExtent) &&
                Objects.equals(pname, that.pname) &&
                Objects.equals(pfname, that.pfname) &&
                Objects.equals(anubhavadarExtent, that.anubhavadarExtent) &&
                Objects.equals(partKey, that.partKey) &&
                Objects.equals(dcode, that.dcode) &&
                Objects.equals(mcode, that.mcode) &&
                Objects.equals(dtcreated, that.dtcreated) &&
                Objects.equals(tenantfarmerFathername, that.tenantfarmerFathername) &&
                Objects.equals(tenantAadhaar, that.tenantAadhaar) &&
                Objects.equals(landNature, that.landNature) &&
                Objects.equals(anubhavadarName, that.anubhavadarName) &&
                Objects.equals(anubhavadarFathername, that.anubhavadarFathername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccrcid, docid, wbdcode, dname, wbmcode, mname, vcode, vname, tenantfarmername, rid, khatano, surveyno, extent, enrolldate, enrollenddate, gender, dtCrt, caste, crYear, crSeason, cultivableLand, uncultivableLand, totExtent, pname, pfname, anubhavadarExtent, partKey, dcode, mcode, dtcreated, tenantfarmerFathername, tenantAadhaar, landNature, anubhavadarName, anubhavadarFathername);
    }

    @Override
    public String toString() {
        return "CcrcDetailsTempEntity{" +
                "ccrcid=" + ccrcid +
                ", docid='" + docid + '\'' +
                ", wbdcode=" + wbdcode +
                ", dname='" + dname + '\'' +
                ", wbmcode=" + wbmcode +
                ", mname='" + mname + '\'' +
                ", vcode=" + vcode +
                ", vname='" + vname + '\'' +
                ", tenantfarmername='" + tenantfarmername + '\'' +
                ", rid=" + rid +
                ", khatano=" + khatano +
                ", surveyno='" + surveyno + '\'' +
                ", extent=" + extent +
                ", enrolldate=" + enrolldate +
                ", enrollenddate=" + enrollenddate +
                ", gender='" + gender + '\'' +
                ", dtCrt=" + dtCrt +
                ", caste=" + caste +
                ", crYear=" + crYear +
                ", crSeason='" + crSeason + '\'' +
                ", cultivableLand=" + cultivableLand +
                ", uncultivableLand=" + uncultivableLand +
                ", totExtent=" + totExtent +
                ", pname='" + pname + '\'' +
                ", pfname='" + pfname + '\'' +
                ", anubhavadarExtent=" + anubhavadarExtent +
                ", partKey='" + partKey + '\'' +
                ", dcode=" + dcode +
                ", mcode=" + mcode +
                ", dtcreated=" + dtcreated +
                ", tenantfarmerFathername='" + tenantfarmerFathername + '\'' +
                ", tenantAadhaar='" + tenantAadhaar + '\'' +
                ", landNature='" + landNature + '\'' +
                ", anubhavadarName='" + anubhavadarName + '\'' +
                ", anubhavadarFathername='" + anubhavadarFathername + '\'' +
                '}';
    }
}