package com.ecrops.dto.webland;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeblandCropData {
    @JsonProperty("dist_code")
    private String dist_code;
    @JsonProperty("Mand_code")
    private String Mand_code;
    @JsonProperty("Village_Code")
    private String Village_Code;
    @JsonProperty("Pattadar_uid")
    private String Pattadar_uid;
    @JsonProperty("pName")
    private String pName;
    @JsonProperty("pFname")
    private String pFname;
    @JsonProperty("pMobileno")
    private String pMobileno;
    @JsonProperty("pSurveyno")
    private String pSurveyno;
    @JsonProperty("pKhatano")
    private String pKhatano;
    @JsonProperty("OccuptName")
    private String OccuptName;
    @JsonProperty("OccuptFname")
    private String OccuptFname;
    @JsonProperty("pextent")
    private String pextent;
    @JsonProperty("Totalextent")
    private String Totalextent;
    @JsonProperty("Uncultivated_Land")
    private String Uncultivated_Land;
    @JsonProperty("Cultivatable_land")
    private String Cultivatable_land;
    @JsonProperty("Regno")
    private String Regno;
    @JsonProperty("ResponseCode")
    private String ResponseCode;
    @JsonProperty("Response")
    private String Response;
    @JsonProperty("singlejointoccupant")
    private int singlejointoccupant;
    @JsonProperty("DataSrc")
    private String DataSrc;
    @JsonProperty("IsSignedorNot")
    private String IsSignedorNot;
    @JsonProperty("BaseSurveyNo")
    private String BaseSurveyNo;

    public WeblandCropData() {
    }

    public WeblandCropData(String dist_code, String mand_code, String village_Code, String pattadar_uid, String pName, String pFname, String pMobileno, String pSurveyno, String pKhatano, String occuptName, String occuptFname, String pextent, String totalextent, String uncultivated_Land, String cultivatable_land, String regno, String responseCode, String response, int singlejointoccupant, String dataSrc, String isSignedorNot, String baseSurveyNo) {
        this.dist_code = dist_code;
        Mand_code = mand_code;
        Village_Code = village_Code;
        Pattadar_uid = pattadar_uid;
        this.pName = pName;
        this.pFname = pFname;
        this.pMobileno = pMobileno;
        this.pSurveyno = pSurveyno;
        this.pKhatano = pKhatano;
        OccuptName = occuptName;
        OccuptFname = occuptFname;
        this.pextent = pextent;
        Totalextent = totalextent;
        Uncultivated_Land = uncultivated_Land;
        Cultivatable_land = cultivatable_land;
        Regno = regno;
        ResponseCode = responseCode;
        Response = response;
        this.singlejointoccupant = singlejointoccupant;
        DataSrc = dataSrc;
        IsSignedorNot = isSignedorNot;
        BaseSurveyNo = baseSurveyNo;
    }

    public String getDist_code() {
        return dist_code;
    }

    public void setDist_code(String dist_code) {
        this.dist_code = dist_code;
    }

    public String getMand_code() {
        return Mand_code;
    }

    public void setMand_code(String mand_code) {
        Mand_code = mand_code;
    }

    public String getVillage_Code() {
        return Village_Code;
    }

    public void setVillage_Code(String village_Code) {
        Village_Code = village_Code;
    }

    public String getPattadar_uid() {
        return Pattadar_uid;
    }

    public void setPattadar_uid(String pattadar_uid) {
        Pattadar_uid = pattadar_uid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpFname() {
        return pFname;
    }

    public void setpFname(String pFname) {
        this.pFname = pFname;
    }

    public String getpMobileno() {
        return pMobileno;
    }

    public void setpMobileno(String pMobileno) {
        this.pMobileno = pMobileno;
    }

    public String getpSurveyno() {
        return pSurveyno;
    }

    public void setpSurveyno(String pSurveyno) {
        this.pSurveyno = pSurveyno;
    }

    public String getpKhatano() {
        return pKhatano;
    }

    public void setpKhatano(String pKhatano) {
        this.pKhatano = pKhatano;
    }

    public String getOccuptName() {
        return OccuptName;
    }

    public void setOccuptName(String occuptName) {
        OccuptName = occuptName;
    }

    public String getOccuptFname() {
        return OccuptFname;
    }

    public void setOccuptFname(String occuptFname) {
        OccuptFname = occuptFname;
    }

    public String getPextent() {
        return pextent;
    }

    public void setPextent(String pextent) {
        this.pextent = pextent;
    }

    public String getTotalextent() {
        return Totalextent;
    }

    public void setTotalextent(String totalextent) {
        Totalextent = totalextent;
    }

    public String getUncultivated_Land() {
        return Uncultivated_Land;
    }

    public void setUncultivated_Land(String uncultivated_Land) {
        Uncultivated_Land = uncultivated_Land;
    }

    public String getCultivatable_land() {
        return Cultivatable_land;
    }

    public void setCultivatable_land(String cultivatable_land) {
        Cultivatable_land = cultivatable_land;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(String regno) {
        Regno = regno;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public int getSinglejointoccupant() {
        return singlejointoccupant;
    }

    public void setSinglejointoccupant(int singlejointoccupant) {
        this.singlejointoccupant = singlejointoccupant;
    }

    public String getDataSrc() {
        return DataSrc;
    }

    public void setDataSrc(String dataSrc) {
        DataSrc = dataSrc;
    }

    public String getIsSignedorNot() {
        return IsSignedorNot;
    }

    public void setIsSignedorNot(String isSignedorNot) {
        IsSignedorNot = isSignedorNot;
    }

    public String getBaseSurveyNo() {
        return BaseSurveyNo;
    }

    public void setBaseSurveyNo(String baseSurveyNo) {
        BaseSurveyNo = baseSurveyNo;
    }

    @Override
    public String toString() {
        return "WeblandCropData{" +
                "dist_code='" + dist_code + '\'' +
                ", Mand_code='" + Mand_code + '\'' +
                ", Village_Code='" + Village_Code + '\'' +
                ", Pattadar_uid='" + Pattadar_uid + '\'' +
                ", pName='" + pName + '\'' +
                ", pFname='" + pFname + '\'' +
                ", pMobileno='" + pMobileno + '\'' +
                ", pSurveyno='" + pSurveyno + '\'' +
                ", pKhatano='" + pKhatano + '\'' +
                ", OccuptName='" + OccuptName + '\'' +
                ", OccuptFname='" + OccuptFname + '\'' +
                ", pextent='" + pextent + '\'' +
                ", Totalextent='" + Totalextent + '\'' +
                ", Uncultivated_Land='" + Uncultivated_Land + '\'' +
                ", Cultivatable_land='" + Cultivatable_land + '\'' +
                ", Regno='" + Regno + '\'' +
                ", ResponseCode='" + ResponseCode + '\'' +
                ", Response='" + Response + '\'' +
                ", singlejointoccupant=" + singlejointoccupant +
                ", DataSrc='" + DataSrc + '\'' +
                ", IsSignedorNot='" + IsSignedorNot + '\'' +
                ", BaseSurveyNo='" + BaseSurveyNo + '\'' +
                '}';
    }
}
