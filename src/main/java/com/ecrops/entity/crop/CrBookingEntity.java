package com.ecrops.entity.crop;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cr_booking", schema = "public")
@NamedQuery(name = "CrBookingEntity.findByPartKey", query = "SELECT c FROM CrBookingEntity c WHERE c.partKey = :partKey")
public class CrBookingEntity implements Serializable {
	private String partKey;
	private int bookingid;
	private BigDecimal crDistCode;
	private BigDecimal crMandCode;
	private int crVcode;
	private BigDecimal crYear;
	private String crSeason;
	private String crFarmerUid;
	private String ownerTenant;
	private String ocName;
	private String ocFname;
	private String email;
	private BigDecimal mobileNo;
	private BigDecimal age;
	private BigDecimal khNo;
	private String crSno;
	private BigDecimal totExtent;
	private BigDecimal crTrDExt;
	private BigDecimal crTrIExt;
	private String entryBy;
	private Timestamp entryDate;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String imei;
	private String updatedBy;
	private Timestamp updateOn;
	private String ipAddress;
	private String uploaded;
	private String dataSrc;
	private String downloadTime;
	private String ccrcid;
	private int rid;
	private String cropInsured;
	private BigDecimal occupantExtent;
	private int dcode;
	private int mcode;
	private String occupName;
	private String occupFname;
	private int regNo;
	private int socCategory;
	private String gender;
	private int sJointOccupant;
	private int cType;
	private int variety;
	private int irrMethod;
	private String downloaded;
	private String crtUser;
	private String dwldVer;
	private String upldVer;
	private String ageFlag;
	private String mobileFlag;
	private int cropType;
	private String anubhavadarName;
	private BigDecimal anubhavadarExtent;
	private String cultivatorType;
	private BigDecimal oldBookingId;
	private Timestamp dtCrt;
	private String landOwnershipType;
	private int refBookingId;
	private String cultiExtUpdFlag;
	private BigDecimal oldCrTrIExt;
	private BigDecimal oldCrTrDExt;
	private String forwardedBooking;
	private String insertedBy;
	private int dataPrepBkId;
	private String ipsFlag;
	private String digitallySigned;
	private String crFarmerUidOld;

	@Id
	@Column(name = "part_key", nullable = false, length = 10)
	public String getPartKey() {
		return partKey;
	}

	public void setPartKey(String partKey) {
		this.partKey = partKey;
	}

	@Basic
	@Column(name = "bookingid", nullable = false)
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Basic
	@Column(name = "cr_dist_code", nullable = true, precision = 18, scale = 0)
	public BigDecimal getCrDistCode() {
		return crDistCode;
	}

	public void setCrDistCode(BigDecimal crDistCode) {
		this.crDistCode = crDistCode;
	}

	@Basic
	@Column(name = "cr_mand_code", nullable = true, precision = 18, scale = 0)
	public BigDecimal getCrMandCode() {
		return crMandCode;
	}

	public void setCrMandCode(BigDecimal crMandCode) {
		this.crMandCode = crMandCode;
	}

	@Basic
	@Column(name = "cr_vcode", nullable = false)
	public int getCrVcode() {
		return crVcode;
	}

	public void setCrVcode(int crVcode) {
		this.crVcode = crVcode;
	}

	@Basic
	@Column(name = "cr_year", nullable = false, precision = 4, scale = 0)
	public BigDecimal getCrYear() {
		return crYear;
	}

	public void setCrYear(BigDecimal crYear) {
		this.crYear = crYear;
	}

	@Basic
	@Column(name = "cr_season", nullable = false, length = 1)
	public String getCrSeason() {
		return crSeason;
	}

	public void setCrSeason(String crSeason) {
		this.crSeason = crSeason;
	}

	@Basic
	@Column(name = "cr_farmeruid", nullable = true, length = 12)
	public String getCrFarmerUid() {
		return crFarmerUid;
	}

	public void setCrFarmerUid(String crFarmerUid) {
		this.crFarmerUid = crFarmerUid;
	}

	@Basic
	@Column(name = "owner_tenant", nullable = false, length = 1)
	public String getOwnerTenant() {
		return ownerTenant;
	}

	public void setOwnerTenant(String ownerTenant) {
		this.ownerTenant = ownerTenant;
	}

	@Basic
	@Column(name = "oc_name", nullable = true, length = 200)
	public String getOcName() {
		return ocName;
	}

	public void setOcName(String ocName) {
		this.ocName = ocName;
	}

	@Basic
	@Column(name = "oc_fname", nullable = true, length = 200)
	public String getOcFname() {
		return ocFname;
	}

	public void setOcFname(String ocFname) {
		this.ocFname = ocFname;
	}

	@Basic
	@Column(name = "email", nullable = true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "mobileno", nullable = true, precision = 10, scale = 0)
	public BigDecimal getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(BigDecimal mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Basic
	@Column(name = "age", nullable = true, precision = 3, scale = 0)
	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	@Basic
	@Column(name = "kh_no", nullable = false, precision = 10, scale = 0)
	public BigDecimal getKhNo() {
		return khNo;
	}

	public void setKhNo(BigDecimal khNo) {
		this.khNo = khNo;
	}

	@Basic
	@Column(name = "cr_sno", nullable = false, length = 100)
	public String getCrSno() {
		return crSno;
	}

	public void setCrSno(String crSno) {
		this.crSno = crSno;
	}

	@Basic
	@Column(name = "tot_extent", nullable = true, precision = 20, scale = 4)
	public BigDecimal getTotExtent() {
		return totExtent;
	}

	public void setTotExtent(BigDecimal totExtent) {
		this.totExtent = totExtent;
	}

	@Basic
	@Column(name = "entry_by", nullable = true, length = 15)
	public String getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	@Basic
	@Column(name = "entry_date", nullable = true)
	public Timestamp getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	@Basic
	@Column(name = "longitude", nullable = true, precision = 18, scale = 10)
	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Basic
	@Column(name = "latitude", nullable = true, precision = 18, scale = 10)
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@Basic
	@Column(name = "imei", nullable = true, length = 50)
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Basic
	@Column(name = "updatedby", nullable = true, length = 50)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Basic
	@Column(name = "updateon", nullable = true)
	public Timestamp getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Timestamp updateOn) {
		this.updateOn = updateOn;
	}

	@Basic
	@Column(name = "ipaddress", nullable = true, length = 50)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Basic
	@Column(name = "uploaded", nullable = true, length = 1)
	public String getUploaded() {
		return uploaded;
	}

	public void setUploaded(String uploaded) {
		this.uploaded = uploaded;
	}

	@Basic
	@Column(name = "data_src", nullable = true, length = 1)
	public String getDataSrc() {
		return dataSrc;
	}

	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}

	@Basic
	@Column(name = "downloadtime", nullable = true, length = 30)
	public String getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}

	@Basic
	@Column(name = "ccrcid", nullable = true, length = 100)
	public String getCcrcid() {
		return ccrcid;
	}

	public void setCcrcid(String ccrcid) {
		this.ccrcid = ccrcid;
	}

	@Basic
	@Column(name = "rid", nullable = true)
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Basic
	@Column(name = "crop_insured", nullable = true, length = 1)
	public String getCropInsured() {
		return cropInsured;
	}

	public void setCropInsured(String cropInsured) {
		this.cropInsured = cropInsured;
	}

	@Basic
	@Column(name = "occupant_extent", nullable = true, precision = 20, scale = 4)
	public BigDecimal getOccupantExtent() {
		return occupantExtent;
	}

	public void setOccupantExtent(BigDecimal occupantExtent) {
		this.occupantExtent = occupantExtent;
	}

	// ... (previous code)

	@Basic
	@Column(name = "cr_tr_d_ext", nullable = true, precision = 10, scale = 4)
	public BigDecimal getCrTrDExt() {
		return crTrDExt;
	}

	public void setCrTrDExt(BigDecimal crTrDExt) {
		this.crTrDExt = crTrDExt;
	}

	@Basic
	@Column(name = "cr_tr_i_ext", nullable = true, precision = 10, scale = 4)
	public BigDecimal getCrTrIExt() {
		return crTrIExt;
	}

	public void setCrTrIExt(BigDecimal crTrIExt) {
		this.crTrIExt = crTrIExt;
	}

	@Basic
	@Column(name = "dcode", nullable = true)
	public int getDcode() {
		return dcode;
	}

	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	@Basic
	@Column(name = "mcode", nullable = true)
	public int getMcode() {
		return mcode;
	}

	public void setMcode(int mcode) {
		this.mcode = mcode;
	}

	@Basic
	@Column(name = "occupname", nullable = true, length = 200)
	public String getOccupName() {
		return occupName;
	}

	public void setOccupName(String occupName) {
		this.occupName = occupName;
	}

	@Basic
	@Column(name = "occupfname", nullable = true, length = 200)
	public String getOccupFname() {
		return occupFname;
	}

	public void setOccupFname(String occupFname) {
		this.occupFname = occupFname;
	}

	@Basic
	@Column(name = "regno", nullable = true)
	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	@Basic
	@Column(name = "soc_category", nullable = true)
	public int getSocCategory() {
		return socCategory;
	}

	public void setSocCategory(int socCategory) {
		this.socCategory = socCategory;
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
	@Column(name = "sjointoccupant", nullable = true)
	public int getsJointOccupant() {
		return sJointOccupant;
	}

	public void setsJointOccupant(int sJointOccupant) {
		this.sJointOccupant = sJointOccupant;
	}

	@Basic
	@Column(name = "ctype", nullable = true)
	public int getcType() {
		return cType;
	}

	public void setcType(int cType) {
		this.cType = cType;
	}

	@Basic
	@Column(name = "variety", nullable = true)
	public int getVariety() {
		return variety;
	}

	public void setVariety(int variety) {
		this.variety = variety;
	}

	@Basic
	@Column(name = "irrmethod", nullable = true)
	public int getIrrMethod() {
		return irrMethod;
	}

	public void setIrrMethod(int irrMethod) {
		this.irrMethod = irrMethod;
	}

	@Basic
	@Column(name = "downloaded", nullable = true, length = 1)
	public String getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(String downloaded) {
		this.downloaded = downloaded;
	}

	@Basic
	@Column(name = "crt_user", nullable = true, length = 100)
	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	@Basic
	@Column(name = "dwld_ver", nullable = true, length = 255)
	public String getDwldVer() {
		return dwldVer;
	}

	public void setDwldVer(String dwldVer) {
		this.dwldVer = dwldVer;
	}

	@Basic
	@Column(name = "upld_ver", nullable = true, length = 255)
	public String getUpldVer() {
		return upldVer;
	}

	public void setUpldVer(String upldVer) {
		this.upldVer = upldVer;
	}

	@Basic
	@Column(name = "age_flag", nullable = true, length = 1)
	public String getAgeFlag() {
		return ageFlag;
	}

	public void setAgeFlag(String ageFlag) {
		this.ageFlag = ageFlag;
	}

	@Basic
	@Column(name = "mobile_flag", nullable = true, length = 1)
	public String getMobileFlag() {
		return mobileFlag;
	}

	public void setMobileFlag(String mobileFlag) {
		this.mobileFlag = mobileFlag;
	}

	@Basic
	@Column(name = "croptype", nullable = true)
	public int getCropType() {
		return cropType;
	}

	public void setCropType(int cropType) {
		this.cropType = cropType;
	}

	@Basic
	@Column(name = "anubhavadar_name", nullable = true, length = 200)
	public String getAnubhavadarName() {
		return anubhavadarName;
	}

	public void setAnubhavadarName(String anubhavadarName) {
		this.anubhavadarName = anubhavadarName;
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
	@Column(name = "cultivator_type", nullable = true, length = 1)
	public String getCultivatorType() {
		return cultivatorType;
	}

	public void setCultivatorType(String cultivatorType) {
		this.cultivatorType = cultivatorType;
	}

	@Basic
	@Column(name = "old_booking_id", nullable = true, precision = 20, scale = 0)
	public BigDecimal getOldBookingId() {
		return oldBookingId;
	}

	public void setOldBookingId(BigDecimal oldBookingId) {
		this.oldBookingId = oldBookingId;
	}

	@Basic
	@Column(name = "dt_crt", nullable = true)
	public Timestamp getDtCrt() {
		return dtCrt;
	}

	public void setDtCrt(Timestamp dtCrt) {
		this.dtCrt = dtCrt;
	}

	@Basic
	@Column(name = "landownership_type", nullable = true, length = 2)
	public String getLandOwnershipType() {
		return landOwnershipType;
	}

	public void setLandOwnershipType(String landOwnershipType) {
		this.landOwnershipType = landOwnershipType;
	}

	@Basic
	@Column(name = "ref_booking_id", nullable = true)
	public int getRefBookingId() {
		return refBookingId;
	}

	public void setRefBookingId(int refBookingId) {
		this.refBookingId = refBookingId;
	}

	@Basic
	@Column(name = "culti_ext_upd_flag", nullable = true, length = 1)
	public String getCultiExtUpdFlag() {
		return cultiExtUpdFlag;
	}

	public void setCultiExtUpdFlag(String cultiExtUpdFlag) {
		this.cultiExtUpdFlag = cultiExtUpdFlag;
	}

	@Basic
	@Column(name = "old_cr_tr_i_ext", nullable = true, precision = 10, scale = 4)
	public BigDecimal getOldCrTrIExt() {
		return oldCrTrIExt;
	}

	public void setOldCrTrIExt(BigDecimal oldCrTrIExt) {
		this.oldCrTrIExt = oldCrTrIExt;
	}

	@Basic
	@Column(name = "old_cr_tr_d_ext", nullable = true, precision = 10, scale = 4)
	public BigDecimal getOldCrTrDExt() {
		return oldCrTrDExt;
	}

	public void setOldCrTrDExt(BigDecimal oldCrTrDExt) {
		this.oldCrTrDExt = oldCrTrDExt;
	}

	@Basic
	@Column(name = "forwarded_booking", nullable = true, length = 1)
	public String getForwardedBooking() {
		return forwardedBooking;
	}

	public void setForwardedBooking(String forwardedBooking) {
		this.forwardedBooking = forwardedBooking;
	}

	@Basic
	@Column(name = "insertedby", nullable = true, length = 1)
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	@Basic
	@Column(name = "dataprep_bkid", nullable = true)
	public int getDataPrepBkId() {
		return dataPrepBkId;
	}

	public void setDataPrepBkId(int dataPrepBkId) {
		this.dataPrepBkId = dataPrepBkId;
	}

	@Basic
	@Column(name = "ips_flag", nullable = true, length = 1)
	public String getIpsFlag() {
		return ipsFlag;
	}

	public void setIpsFlag(String ipsFlag) {
		this.ipsFlag = ipsFlag;
	}

	@Basic
	@Column(name = "digitally_signed", nullable = true)
	public String getDigitallySigned() {
		return digitallySigned;
	}

	public void setDigitallySigned(String digitallySigned) {
		this.digitallySigned = digitallySigned;
	}

	@Basic
	@Column(name = "cr_farmeruid_old", nullable = true, length = 12)
	public String getCrFarmerUidOld() {
		return crFarmerUidOld;
	}

	public void setCrFarmerUidOld(String crFarmerUidOld) {
		this.crFarmerUidOld = crFarmerUidOld;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CrBookingEntity crBooking = (CrBookingEntity) o;

		if (bookingid != crBooking.bookingid)
			return false;
		if (crDistCode != null ? !crDistCode.equals(crBooking.crDistCode) : crBooking.crDistCode != null)
			return false;
		if (crMandCode != null ? !crMandCode.equals(crBooking.crMandCode) : crBooking.crMandCode != null)
			return false;
		if (crVcode != crBooking.crVcode)
			return false;
		if (crYear != crBooking.crYear)
			return false;
		if (crSeason != null ? !crSeason.equals(crBooking.crSeason) : crBooking.crSeason != null)
			return false;
		if (crFarmerUid != null ? !crFarmerUid.equals(crBooking.crFarmerUid) : crBooking.crFarmerUid != null)
			return false;
		if (ownerTenant != null ? !ownerTenant.equals(crBooking.ownerTenant) : crBooking.ownerTenant != null)
			return false;
		if (ocName != null ? !ocName.equals(crBooking.ocName) : crBooking.ocName != null)
			return false;
		if (ocFname != null ? !ocFname.equals(crBooking.ocFname) : crBooking.ocFname != null)
			return false;
		if (email != null ? !email.equals(crBooking.email) : crBooking.email != null)
			return false;
		if (mobileNo != null ? !mobileNo.equals(crBooking.mobileNo) : crBooking.mobileNo != null)
			return false;
		if (age != null ? !age.equals(crBooking.age) : crBooking.age != null)
			return false;
		if (khNo != null ? !khNo.equals(crBooking.khNo) : crBooking.khNo != null)
			return false;
		if (crSno != null ? !crSno.equals(crBooking.crSno) : crBooking.crSno != null)
			return false;
		if (totExtent != null ? !totExtent.equals(crBooking.totExtent) : crBooking.totExtent != null)
			return false;
		if (crTrDExt != null ? !crTrDExt.equals(crBooking.crTrDExt) : crBooking.crTrDExt != null)
			return false;
		if (crTrIExt != null ? !crTrIExt.equals(crBooking.crTrIExt) : crBooking.crTrIExt != null)
			return false;
		if (entryBy != null ? !entryBy.equals(crBooking.entryBy) : crBooking.entryBy != null)
			return false;
		if (entryDate != null ? !entryDate.equals(crBooking.entryDate) : crBooking.entryDate != null)
			return false;
		if (longitude != null ? !longitude.equals(crBooking.longitude) : crBooking.longitude != null)
			return false;
		if (latitude != null ? !latitude.equals(crBooking.latitude) : crBooking.latitude != null)
			return false;
		if (imei != null ? !imei.equals(crBooking.imei) : crBooking.imei != null)
			return false;
		if (updatedBy != null ? !updatedBy.equals(crBooking.updatedBy) : crBooking.updatedBy != null)
			return false;
		if (updateOn != null ? !updateOn.equals(crBooking.updateOn) : crBooking.updateOn != null)
			return false;
		if (ipAddress != null ? !ipAddress.equals(crBooking.ipAddress) : crBooking.ipAddress != null)
			return false;
		if (uploaded != null ? !uploaded.equals(crBooking.uploaded) : crBooking.uploaded != null)
			return false;
		if (dataSrc != null ? !dataSrc.equals(crBooking.dataSrc) : crBooking.dataSrc != null)
			return false;
		if (downloadTime != null ? !downloadTime.equals(crBooking.downloadTime) : crBooking.downloadTime != null)
			return false;
		if (ccrcid != null ? !ccrcid.equals(crBooking.ccrcid) : crBooking.ccrcid != null)
			return false;
		if (rid != crBooking.rid)
			return false;
		if (cropInsured != null ? !cropInsured.equals(crBooking.cropInsured) : crBooking.cropInsured != null)
			return false;
		if (occupantExtent != null ? !occupantExtent.equals(crBooking.occupantExtent)
				: crBooking.occupantExtent != null)
			return false;
		if (dcode != crBooking.dcode)
			return false;
		if (mcode != crBooking.mcode)
			return false;
		if (occupName != null ? !occupName.equals(crBooking.occupName) : crBooking.occupName != null)
			return false;
		if (occupFname != null ? !occupFname.equals(crBooking.occupFname) : crBooking.occupFname != null)
			return false;
		if (regNo != crBooking.regNo)
			return false;
		if (socCategory != crBooking.socCategory)
			return false;
		if (gender != null ? !gender.equals(crBooking.gender) : crBooking.gender != null)
			return false;
		if (sJointOccupant != crBooking.sJointOccupant)
			return false;
		if (cType != crBooking.cType)
			return false;
		if (variety != crBooking.variety)
			return false;
		if (irrMethod != crBooking.irrMethod)
			return false;
		if (downloaded != null ? !downloaded.equals(crBooking.downloaded) : crBooking.downloaded != null)
			return false;
		if (crtUser != null ? !crtUser.equals(crBooking.crtUser) : crBooking.crtUser != null)
			return false;
		if (dwldVer != null ? !dwldVer.equals(crBooking.dwldVer) : crBooking.dwldVer != null)
			return false;
		if (upldVer != null ? !upldVer.equals(crBooking.upldVer) : crBooking.upldVer != null)
			return false;
		if (ageFlag != null ? !ageFlag.equals(crBooking.ageFlag) : crBooking.ageFlag != null)
			return false;
		if (mobileFlag != null ? !mobileFlag.equals(crBooking.mobileFlag) : crBooking.mobileFlag != null)
			return false;
		if (cropType != crBooking.cropType)
			return false;
		if (anubhavadarName != null ? !anubhavadarName.equals(crBooking.anubhavadarName)
				: crBooking.anubhavadarName != null)
			return false;
		if (anubhavadarExtent != null ? !anubhavadarExtent.equals(crBooking.anubhavadarExtent)
				: crBooking.anubhavadarExtent != null)
			return false;
		if (cultivatorType != null ? !cultivatorType.equals(crBooking.cultivatorType)
				: crBooking.cultivatorType != null)
			return false;
		if (oldBookingId != null ? !oldBookingId.equals(crBooking.oldBookingId) : crBooking.oldBookingId != null)
			return false;
		if (dtCrt != null ? !dtCrt.equals(crBooking.dtCrt) : crBooking.dtCrt != null)
			return false;
		if (landOwnershipType != null ? !landOwnershipType.equals(crBooking.landOwnershipType)
				: crBooking.landOwnershipType != null)
			return false;
		if (refBookingId != crBooking.refBookingId)
			return false;
		if (cultiExtUpdFlag != null ? !cultiExtUpdFlag.equals(crBooking.cultiExtUpdFlag)
				: crBooking.cultiExtUpdFlag != null)
			return false;
		if (oldCrTrIExt != null ? !oldCrTrIExt.equals(crBooking.oldCrTrIExt) : crBooking.oldCrTrIExt != null)
			return false;
		if (oldCrTrDExt != null ? !oldCrTrDExt.equals(crBooking.oldCrTrDExt) : crBooking.oldCrTrDExt != null)
			return false;
		if (forwardedBooking != null ? !forwardedBooking.equals(crBooking.forwardedBooking)
				: crBooking.forwardedBooking != null)
			return false;
		if (insertedBy != null ? !insertedBy.equals(crBooking.insertedBy) : crBooking.insertedBy != null)
			return false;
		if (dataPrepBkId != crBooking.dataPrepBkId)
			return false;
		if (ipsFlag != null ? !ipsFlag.equals(crBooking.ipsFlag) : crBooking.ipsFlag != null)
			return false;
		if (digitallySigned != null ? !digitallySigned.equals(crBooking.digitallySigned)
				: crBooking.digitallySigned != null)
			return false;
		if (crFarmerUidOld != null ? !crFarmerUidOld.equals(crBooking.crFarmerUidOld)
				: crBooking.crFarmerUidOld != null)
			return false;

		return true;

	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingid, crDistCode, crMandCode, crVcode, crYear, crSeason, crFarmerUid, ownerTenant,
				ocName, ocFname, email, mobileNo, age, khNo, crSno, totExtent, crTrDExt, crTrIExt, entryBy, entryDate,
				longitude, latitude, imei, updatedBy, updateOn, ipAddress, uploaded, dataSrc, downloadTime, ccrcid, rid,
				cropInsured, occupantExtent, dcode, mcode, occupName, occupFname, regNo, socCategory, gender,
				sJointOccupant, cType, variety, irrMethod, downloaded, crtUser, dwldVer, upldVer, ageFlag, mobileFlag,
				cropType, anubhavadarName, anubhavadarExtent, cultivatorType, oldBookingId, dtCrt, landOwnershipType,
				refBookingId, cultiExtUpdFlag, oldCrTrIExt, oldCrTrDExt, forwardedBooking, insertedBy, dataPrepBkId,
				ipsFlag, digitallySigned, crFarmerUidOld);
	}

	@Override
	public String toString() {
		return "CrBookingEntity{" + "partKey='" + partKey + '\'' + ", bookingid=" + bookingid + ", crDistCode="
				+ crDistCode + ", crMandCode=" + crMandCode + ", crVcode=" + crVcode + ", crYear=" + crYear
				+ ", crSeason='" + crSeason + '\'' + ", crFarmerUid='" + crFarmerUid + '\'' + ", ownerTenant='"
				+ ownerTenant + '\'' + ", ocName='" + ocName + '\'' + ", ocFname='" + ocFname + '\'' + ", email='"
				+ email + '\'' + ", mobileNo=" + mobileNo + ", age=" + age + ", khNo=" + khNo + ", crSno='" + crSno
				+ '\'' + ", totExtent=" + totExtent + ", crTrDExt=" + crTrDExt + ", crTrIExt=" + crTrIExt
				+ ", entryBy='" + entryBy + '\'' + ", entryDate=" + entryDate + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", imei='" + imei + '\'' + ", updatedBy='" + updatedBy + '\''
				+ ", updateOn=" + updateOn + ", ipAddress='" + ipAddress + '\'' + ", uploaded='" + uploaded + '\''
				+ ", dataSrc='" + dataSrc + '\'' + ", downloadTime='" + downloadTime + '\'' + ", ccrcid='" + ccrcid
				+ '\'' + ", rid=" + rid + ", cropInsured='" + cropInsured + '\'' + ", occupantExtent=" + occupantExtent
				+ ", dcode=" + dcode + ", mcode=" + mcode + ", occupName='" + occupName + '\'' + ", occupFname='"
				+ occupFname + '\'' + ", regNo=" + regNo + ", socCategory=" + socCategory + ", gender='" + gender + '\''
				+ ", sJointOccupant=" + sJointOccupant + ", cType=" + cType + ", variety=" + variety + ", irrMethod="
				+ irrMethod + ", downloaded='" + downloaded + '\'' + ", crtUser='" + crtUser + '\'' + ", dwldVer='"
				+ dwldVer + '\'' + ", upldVer='" + upldVer + '\'' + ", ageFlag='" + ageFlag + '\'' + ", mobileFlag='"
				+ mobileFlag + '\'' + ", cropType=" + cropType + ", anubhavadarName='" + anubhavadarName + '\''
				+ ", anubhavadarExtent=" + anubhavadarExtent + ", cultivatorType='" + cultivatorType + '\''
				+ ", oldBookingId=" + oldBookingId + ", dtCrt=" + dtCrt + ", landOwnershipType='" + landOwnershipType
				+ '\'' + ", refBookingId=" + refBookingId + ", cultiExtUpdFlag='" + cultiExtUpdFlag + '\''
				+ ", oldCrTrIExt=" + oldCrTrIExt + ", oldCrTrDExt=" + oldCrTrDExt + ", forwardedBooking='"
				+ forwardedBooking + '\'' + ", insertedBy='" + insertedBy + '\'' + ", dataPrepBkId=" + dataPrepBkId
				+ ", ipsFlag='" + ipsFlag + '\'' + ", digitallySigned='" + digitallySigned + '\'' + ", crFarmerUidOld='"
				+ crFarmerUidOld + '\'' + '}';
	}
}