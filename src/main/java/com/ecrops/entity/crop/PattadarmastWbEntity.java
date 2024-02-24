package com.ecrops.entity.crop;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pattadarmast_wb" , schema = "ecrop2023")

public class PattadarmastWbEntity {

    @Id
    @Column(name = "cr_dist_code")
    private Integer crDistCode;
    @Column(name = "cr_mand_code")
    private Integer crMandCode;
    @Column(name = "cr_vcode")
    private Integer crVcode;
    @Column(name = "cr_farmeruid", length = 20)
    private String crFarmeruid;
    @Column(name = "farmername")
    private String farmername;
    @Column(name = "fathername")
    private String fathername;
    @Column(name = "mobileno")
    private Integer mobileno;
    @Column(name = "kh_no")
    private Integer khNo;
    @Column(name = "cr_sno")
    private String crSno;
    @Column(name = "tot_extent")
    private Double totExtent;
    @Column(name = "dt_crt")
    private String dtCrt;
    @Column(name = "occupname")
    private String occupname;
    @Column(name = "occupfname")
    private String occupfname;
    @Column(name = "occup_extent")
    private Double occupExtent;
    @Column(name = "regno")
    private Integer regno;
    @Column(name = "sjointoccupant")
    private Integer sjointoccupant;
    @Column(name = "cultivable_land")
    private Double cultivableLand;
    @Column(name = "uncultivable_land")
    private Double uncultivableLand;
    @Column(name = "cropyear")
    private Integer cropyear;
    @Column(name = "season")
    private Character season;
    @Column(name = "status")
    private Character status;
    @Column(name = "insflag")
    private Character insflag;
    @Column(name = "dcode")
    private Integer dcode;
    @Column(name = "mcode")
    private Integer mcode;
    @Column(name = "part_key")
    private String partKey;
    @Column(name = "encuid")
    private String encuid;
    @Column(name = "digitally_signed")
    private String digitallySigned;
    @Column(name = "digitally_unsigned")
    private String digitallyUnsigned;
    @Column(name = "diff_rec")
    private Character diffRec;

    public PattadarmastWbEntity() {
    }

    public PattadarmastWbEntity(Integer crDistCode, Integer crMandCode, Integer crVcode, String crFarmeruid, String farmername, String fathername, Integer mobileno, Integer khNo, String crSno, Double totExtent, String dtCrt, String occupname, String occupfname, Double occupExtent, Integer regno, Integer sjointoccupant, Double cultivableLand, Double uncultivableLand, Integer cropyear, Character season, Character status, Character insflag, Integer dcode, Integer mcode, String partKey, String encuid, String digitallySigned, String digitallyUnsigned, Character diffRec) {
        this.crDistCode = crDistCode;
        this.crMandCode = crMandCode;
        this.crVcode = crVcode;
        this.crFarmeruid = crFarmeruid;
        this.farmername = farmername;
        this.fathername = fathername;
        this.mobileno = mobileno;
        this.khNo = khNo;
        this.crSno = crSno;
        this.totExtent = totExtent;
        this.dtCrt = dtCrt;
        this.occupname = occupname;
        this.occupfname = occupfname;
        this.occupExtent = occupExtent;
        this.regno = regno;
        this.sjointoccupant = sjointoccupant;
        this.cultivableLand = cultivableLand;
        this.uncultivableLand = uncultivableLand;
        this.cropyear = cropyear;
        this.season = season;
        this.status = status;
        this.insflag = insflag;
        this.dcode = dcode;
        this.mcode = mcode;
        this.partKey = partKey;
        this.encuid = encuid;
        this.digitallySigned = digitallySigned;
        this.digitallyUnsigned = digitallyUnsigned;
        this.diffRec = diffRec;
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

    public Integer getCrVcode() {
        return crVcode;
    }

    public void setCrVcode(Integer crVcode) {
        this.crVcode = crVcode;
    }

    public String getCrFarmeruid() {
        return crFarmeruid;
    }

    public void setCrFarmeruid(String crFarmeruid) {
        this.crFarmeruid = crFarmeruid;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    
    public Integer getMobileno() {
		return mobileno;
	}

	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}

	public Integer getKhNo() {
        return khNo;
    }

    public void setKhNo(Integer khNo) {
        this.khNo = khNo;
    }

    public String getCrSno() {
        return crSno;
    }

    public void setCrSno(String crSno) {
        this.crSno = crSno;
    }

    public Double getTotExtent() {
        return totExtent;
    }

    public void setTotExtent(Double totExtent) {
        this.totExtent = totExtent;
    }

    public String getDtCrt() {
        return dtCrt;
    }

    public void setDtCrt(String dtCrt) {
        this.dtCrt = dtCrt;
    }

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

    public Double getOccupExtent() {
        return occupExtent;
    }

    public void setOccupExtent(Double occupExtent) {
        this.occupExtent = occupExtent;
    }

    public Integer getRegno() {
        return regno;
    }

    public void setRegno(Integer regno) {
        this.regno = regno;
    }

    public Integer getSjointoccupant() {
        return sjointoccupant;
    }

    public void setSjointoccupant(Integer sjointoccupant) {
        this.sjointoccupant = sjointoccupant;
    }

    public Double getCultivableLand() {
        return cultivableLand;
    }

    public void setCultivableLand(Double cultivableLand) {
        this.cultivableLand = cultivableLand;
    }

    public Double getUncultivableLand() {
        return uncultivableLand;
    }

    public void setUncultivableLand(Double uncultivableLand) {
        this.uncultivableLand = uncultivableLand;
    }

    public Integer getCropyear() {
        return cropyear;
    }

    public void setCropyear(Integer cropyear) {
        this.cropyear = cropyear;
    }

    public Character getSeason() {
        return season;
    }

    public void setSeason(Character season) {
        this.season = season;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getInsflag() {
        return insflag;
    }

    public void setInsflag(Character insflag) {
        this.insflag = insflag;
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

    public String getPartKey() {
        return partKey;
    }

    public void setPartKey(String partKey) {
        this.partKey = partKey;
    }

    public String getEncuid() {
        return encuid;
    }

    public void setEncuid(String encuid) {
        this.encuid = encuid;
    }

    public String getDigitallySigned() {
        return digitallySigned;
    }

    public void setDigitallySigned(String digitallySigned) {
        this.digitallySigned = digitallySigned;
    }

    public String getDigitallyUnsigned() {
        return digitallyUnsigned;
    }

    public void setDigitallyUnsigned(String digitallyUnsigned) {
        this.digitallyUnsigned = digitallyUnsigned;
    }

    public Character getDiffRec() {
        return diffRec;
    }

    public void setDiffRec(Character diffRec) {
        this.diffRec = diffRec;
    }
}
