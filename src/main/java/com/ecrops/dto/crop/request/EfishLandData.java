package com.ecrops.dto.crop.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EfishLandData {
	
	    @JsonProperty("WEBLAND_ID")
	    private int webLandId;
	    @JsonProperty("SURVEY_NO")
	    private String surveyNo;
	    @JsonProperty("TOTAL_EXTENT")
	    private String totalExtent;
	    @JsonProperty("UNCULTIVATED_LAND")
	    private String uncultivatedLand;
	    @JsonProperty("CULTIVATABLE_LAND")
	    private String cultivatableLand;
	    @JsonProperty("LAND_NATURE")
	    private String landNature;
	    @JsonProperty("TAX")
	    private String tax;
	    @JsonProperty("LAND_CLASSIFICATION")
	    private String landClassification;
	    @JsonProperty("WATER_SOURCE")
	    private String waterSource;
	    @JsonProperty("AYAKAT_EXTENT")
	    private String ayakatExtent;
	    @JsonProperty("KHATA_NO")
	    private String khataNo;
	    @JsonProperty("PATTADAR_NAME")
	    private String pattadarName;
	    @JsonProperty("PATTADAR_FATHER_NAME")
	    private String pattadarFatherName;
	    @JsonProperty("BASE_SURVEY_NO")
	    private String baseSurveyNo;
	    @JsonProperty("OCCUPANT_NAME")
	    private String occupantName;
	    @JsonProperty("OCCUPANT_FATHER_NAME")
	    private String occupantFatherName;
	    @JsonProperty("OCCUPANT_EXTENT")
	    private String occupantExtent;
	    @JsonProperty("ENJOYMENT_NATURE")
	    private String enjoymentNature;
	    @JsonProperty("DIST_CODE")
	    private int distCode;
	    @JsonProperty("DIST_NAME")
	    private String distName;
	    @JsonProperty("MAND_CODE")
	    private int mandCode;
	    @JsonProperty("MAND_NAME")
	    private String mandName;
	    @JsonProperty("VILLAGE_CODE")
	    private String villageCode;
	    @JsonProperty("VILLAGE_NAME")
	    private String villageName;
	    @JsonProperty("AQUA_ZONE_STATUS")
	    private String aquaZoneStatus;
	    @JsonProperty("MAPPED_EXTENT")
	    private double mappedExtent;
	    
	    
	    public EfishLandData() {
	    	
	    }
	    
		public int getWebLandId() {
			return webLandId;
		}

		public void setWebLandId(int webLandId) {
			this.webLandId = webLandId;
		}

		public String getSurveyNo() {
			return surveyNo;
		}

		public void setSurveyNo(String surveyNo) {
			this.surveyNo = surveyNo;
		}

		public String getTotalExtent() {
			return totalExtent;
		}

		public void setTotalExtent(String totalExtent) {
			this.totalExtent = totalExtent;
		}

		public String getUncultivatedLand() {
			return uncultivatedLand;
		}

		public void setUncultivatedLand(String uncultivatedLand) {
			this.uncultivatedLand = uncultivatedLand;
		}

		public String getCultivatableLand() {
			return cultivatableLand;
		}

		public void setCultivatableLand(String cultivatableLand) {
			this.cultivatableLand = cultivatableLand;
		}

		public String getLandNature() {
			return landNature;
		}

		public void setLandNature(String landNature) {
			this.landNature = landNature;
		}

		public String getTax() {
			return tax;
		}

		public void setTax(String tax) {
			this.tax = tax;
		}

		public String getLandClassification() {
			return landClassification;
		}

		public void setLandClassification(String landClassification) {
			this.landClassification = landClassification;
		}

		public String getWaterSource() {
			return waterSource;
		}

		public void setWaterSource(String waterSource) {
			this.waterSource = waterSource;
		}

		public String getAyakatExtent() {
			return ayakatExtent;
		}

		public void setAyakatExtent(String ayakatExtent) {
			this.ayakatExtent = ayakatExtent;
		}

		public String getKhataNo() {
			return khataNo;
		}

		public void setKhataNo(String khataNo) {
			this.khataNo = khataNo;
		}

		public String getPattadarName() {
			return pattadarName;
		}

		public void setPattadarName(String pattadarName) {
			this.pattadarName = pattadarName;
		}

		public String getPattadarFatherName() {
			return pattadarFatherName;
		}

		public void setPattadarFatherName(String pattadarFatherName) {
			this.pattadarFatherName = pattadarFatherName;
		}

		public String getBaseSurveyNo() {
			return baseSurveyNo;
		}

		public void setBaseSurveyNo(String baseSurveyNo) {
			this.baseSurveyNo = baseSurveyNo;
		}

		public String getOccupantName() {
			return occupantName;
		}

		public void setOccupantName(String occupantName) {
			this.occupantName = occupantName;
		}

		public String getOccupantFatherName() {
			return occupantFatherName;
		}

		public void setOccupantFatherName(String occupantFatherName) {
			this.occupantFatherName = occupantFatherName;
		}

		public String getOccupantExtent() {
			return occupantExtent;
		}

		public void setOccupantExtent(String occupantExtent) {
			this.occupantExtent = occupantExtent;
		}

		public String getEnjoymentNature() {
			return enjoymentNature;
		}

		public void setEnjoymentNature(String enjoymentNature) {
			this.enjoymentNature = enjoymentNature;
		}

		public int getDistCode() {
			return distCode;
		}

		public void setDistCode(int distCode) {
			this.distCode = distCode;
		}

		public String getDistName() {
			return distName;
		}

		public void setDistName(String distName) {
			this.distName = distName;
		}

		public int getMandCode() {
			return mandCode;
		}

		public void setMandCode(int mandCode) {
			this.mandCode = mandCode;
		}

		public String getMandName() {
			return mandName;
		}

		public void setMandName(String mandName) {
			this.mandName = mandName;
		}

		public String getVillageCode() {
			return villageCode;
		}

		public void setVillageCode(String villageCode) {
			this.villageCode = villageCode;
		}

		public String getVillageName() {
			return villageName;
		}

		public void setVillageName(String villageName) {
			this.villageName = villageName;
		}

		public String getAquaZoneStatus() {
			return aquaZoneStatus;
		}

		public void setAquaZoneStatus(String aquaZoneStatus) {
			this.aquaZoneStatus = aquaZoneStatus;
		}

		public double getMappedExtent() {
			return mappedExtent;
		}

		public void setMappedExtent(double mappedExtent) {
			this.mappedExtent = mappedExtent;
		}

		
		public EfishLandData(int webLandId, String surveyNo, String totalExtent, String uncultivatedLand,
				String cultivatableLand, String landNature, String tax, String landClassification, String waterSource,
				String ayakatExtent, String khataNo, String pattadarName, String pattadarFatherName,
				String baseSurveyNo, String occupantName, String occupantFatherName, String occupantExtent,
				String enjoymentNature, int distCode, String distName, int mandCode, String mandName,
				String villageCode, String villageName, String aquaZoneStatus, double mappedExtent) {
			super();
			this.webLandId = webLandId;
			this.surveyNo = surveyNo;
			this.totalExtent = totalExtent;
			this.uncultivatedLand = uncultivatedLand;
			this.cultivatableLand = cultivatableLand;
			this.landNature = landNature;
			this.tax = tax;
			this.landClassification = landClassification;
			this.waterSource = waterSource;
			this.ayakatExtent = ayakatExtent;
			this.khataNo = khataNo;
			this.pattadarName = pattadarName;
			this.pattadarFatherName = pattadarFatherName;
			this.baseSurveyNo = baseSurveyNo;
			this.occupantName = occupantName;
			this.occupantFatherName = occupantFatherName;
			this.occupantExtent = occupantExtent;
			this.enjoymentNature = enjoymentNature;
			this.distCode = distCode;
			this.distName = distName;
			this.mandCode = mandCode;
			this.mandName = mandName;
			this.villageCode = villageCode;
			this.villageName = villageName;
			this.aquaZoneStatus = aquaZoneStatus;
			this.mappedExtent = mappedExtent;
		}

		@Override
		public String toString() {
			return "EfishLandData [webLandId=" + webLandId + ", surveyNo=" + surveyNo + ", totalExtent=" + totalExtent
					+ ", uncultivatedLand=" + uncultivatedLand + ", cultivatableLand=" + cultivatableLand
					+ ", landNature=" + landNature + ", tax=" + tax + ", landClassification=" + landClassification
					+ ", waterSource=" + waterSource + ", ayakatExtent=" + ayakatExtent + ", khataNo=" + khataNo
					+ ", pattadarName=" + pattadarName + ", pattadarFatherName=" + pattadarFatherName
					+ ", baseSurveyNo=" + baseSurveyNo + ", occupantName=" + occupantName + ", occupantFatherName="
					+ occupantFatherName + ", occupantExtent=" + occupantExtent + ", enjoymentNature=" + enjoymentNature
					+ ", distCode=" + distCode + ", distName=" + distName + ", mandCode=" + mandCode + ", mandName="
					+ mandName + ", villageCode=" + villageCode + ", villageName=" + villageName + ", aquaZoneStatus="
					+ aquaZoneStatus + ", mappedExtent=" + mappedExtent +  "]";
		}
	    
	    
	    
	    

	}
