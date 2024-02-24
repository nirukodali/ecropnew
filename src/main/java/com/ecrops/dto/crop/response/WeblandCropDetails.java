package com.ecrops.dto.crop.response;

public class WeblandCropDetails {
    private Integer crDistCode;
    private Integer crMandCode;
    private Integer crVcode;
    private String crFarmeruid;
    private String farmername;
    private String fathername;
    private  Integer mobileno;
    private Integer khNo;
    private String crSno;
    private Double totExtent;
    private String dtCrt;
    private String occupname;
    private String occupfname;
    private Double occupExtent;
    private Integer regno;
    private Integer sjointoccupant;
    private Double cultivableLand;
    private Double uncultivableLand;
    private Integer cropyear;
    private Character season;
    private Character status;
    private Character insflag;
    private String partKey;
    private String digitallySigned;

    public WeblandCropDetails() {
    }

    public WeblandCropDetails(Integer crDistCode, Integer crMandCode, Integer crVcode, String crFarmeruid, String farmername, String fathername, Integer  mobileno, Integer khNo, String crSno, Double totExtent, String dtCrt, String occupname, String occupfname, Double occupExtent, Integer regno, Integer sjointoccupant, Double cultivableLand, Double uncultivableLand, Integer cropyear, Character season, Character status, Character insflag, String partKey, String digitallySigned) {
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
        this.partKey = partKey;
        this.digitallySigned = digitallySigned;
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

    public String getPartKey() {
        return partKey;
    }

    public void setPartKey(String partKey) {
        this.partKey = partKey;
    }

    public String getDigitallySigned() {
        return digitallySigned;
    }

    public void setDigitallySigned(String digitallySigned) {
        this.digitallySigned = digitallySigned;
    }

    @Override
    public String toString() {
        return "WeblandCropDetails{" +
                "crDistCode=" + crDistCode +
                ", crMandCode=" + crMandCode +
                ", crVcode=" + crVcode +
                ", crFarmeruid='" + crFarmeruid + '\'' +
                ", farmername='" + farmername + '\'' +
                ", fathername='" + fathername + '\'' +
                ", mobileno=" + mobileno +
                ", khNo=" + khNo +
                ", crSno='" + crSno + '\'' +
                ", totExtent=" + totExtent +
                ", dtCrt='" + dtCrt + '\'' +
                ", occupname='" + occupname + '\'' +
                ", occupfname='" + occupfname + '\'' +
                ", occupExtent=" + occupExtent +
                ", regno=" + regno +
                ", sjointoccupant=" + sjointoccupant +
                ", cultivableLand=" + cultivableLand +
                ", uncultivableLand=" + uncultivableLand +
                ", cropyear=" + cropyear +
                ", season=" + season +
                ", status=" + status +
                ", insflag=" + insflag +
                ", partKey='" + partKey + '\'' +
                ", digitallySigned='" + digitallySigned + '\'' +
                '}';
    }
}
