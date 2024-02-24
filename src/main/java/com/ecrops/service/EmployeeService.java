package com.ecrops.service;

import java.util.List;
import java.util.Optional;

import com.ecrops.entity.Emplogsentity;
import com.ecrops.entity.Employeename;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.projection.EmployeeName;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.VillageName;
import com.ecrops.projection.WbVillageRepository;

public interface EmployeeService {
	public List<Employeename> getAllEmployees();

	public List<Employeename> addingEmployee(Integer district, Integer mandal, Integer village, String aadharId,
			Integer empCode, String empName, String email, Long mobileNo);

	public List<Employeename> getAadharExists(String aadharId);

	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, Integer empCode);

//Incharge Repo
	public List<InchargeRbkProjection> getInchargeStatus(Integer rbkCode);

	public Optional<Emplogsentity> saveEmpLogDetails(Integer dcode, Integer emp_code, Integer mcode, Integer rbkcode2,
			String rbkuserid, Integer vcode, Integer wbdcode, Integer wbmcode);

	public List<InchargeRbkProjection> getRbkDetailsToSave(Integer rbkCode);

	public List<RbkDetailsProjection> updateInchargeStatus(String incStatus, Integer empCode, Integer rbkCode);

	public List<WbVillageRepository> getWebLandDetails(Integer district, Integer mandal);

	public List<ActiveSeasonProjection> getUserType(Integer usertype);

	public List<VillageName> getVillName(Integer villCode);

	public List<VillageName> getMandalName(Integer mandalCode);

	public List<VillageName> getDistName(Integer distCode);

	public List<InchargeRbkProjection> getDMcode(Integer distcode, Integer mandalcode);

	public List<RbkDetailsProjection> getRegDMcode(Integer distCode, Integer mandalcode);

//	rbkmappinng
	public List<EmployeeName> getEmpProfile(Integer dcode, Integer mcode, Integer empcode);

	public List<InchargeRbkProjection> getmandempcode(Integer mandal, Integer empcode);

	public List<InchargeRbkProjection> getEmprbkmcode(Integer mcode, Integer empcode, Integer rbkcode);

	public int updateEmployeeLogDetails(Integer rbkcode, Integer empcode);

	public int insertEmployeeLogDetails(Integer rbkcode, Integer empcode);

	public int insertEmployeeLogincts(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode, Integer rbkuserid,
			Integer wbdcode, Integer wbmcode, String inchargeStsUpd);

	public int updateEmployeerbkmapstatus(String inchargeStsUpd, Integer empcode, Integer rbkcode, Integer rbkuserid,
			Integer rbkcode1);

	public int updaterbkmapregularstatus(Integer empcode, Integer rbkcode, Integer rbkuserid, Integer rbkcode2);

	public List<InchargeRbkProjection> rbkstatus(Integer mcode, Integer rbkcode);

	public int insertEmployeeincts(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode, Integer rbkuserid,
			Integer wbdcode, Integer wbmcode);

	public int insertEmployeeincharges(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode,
			Integer rbkuserid, Integer wbdcode, Integer wbmcode, String inchargests, String status);

//	ADA / DAO

	public List<InchargeRbkProjection> getadaDMcode(Integer district, Integer mandal);

	public List<InchargeRbkProjection> getdaoDMcode(Integer distCode, Integer mandalcode);

	public int updateADAIch(String maoRecList, String justifyIdList, Integer district, Integer mandal,
			String rbkusersList, String empcodeList);

	public int updateDAOIch(String maoRecList, String justifyIdList, String ada_appr, Integer district, Integer mandal,
			String rbkusersList, String empcodeList);

//	DAO
	public List<InchargeRbkProjection> getInc(Integer rbkcode, Integer empcode);

	public List<InchargeRbkProjection> getInclogic(Integer rbkcode, String rbkuserid);

	public int updateRBK(Integer empcodeList, Integer rbkusersList);

	public List<InchargeRbkProjection> getcheckrbklogs(Integer rbkcode, String rbkuserid);

	public int inslogs(Integer dcode, Integer mcode, String rbkusersList, String empcodeList, String rbkusersList2,
			Integer wbdcode, Integer wbmcode, String inchargests);

	public List<InchargeRbkProjection> getpincharge(Integer rbkcode);

	// DOWNLOADDATA
	public int savedownload(String tbname1, Integer vcode);

	public int insertdownload(String activeYear, Integer vcode, String userid, String remoteAddr, Integer preasonId,
			Integer cropyear, String season);

	public int updateinch(Integer rbkusersList);

	public int updateinch2(Integer rbkusersList);

	public int updateinch3(Integer empcodeList, Integer rbkusersList);

	public int inslogs2(Integer rbkusersList, Integer empcodeList);

	public int inslogs3(Integer empcodeList, Integer rbkusersList);

	public int inslogs4(Integer rbkusersList, Integer empcodeList);

	public int updatelogsfinal(Integer rbkusersList);

	// DeviceRegistration
	public List<ActiveSeasonProjection> getVname(Integer district, Integer mandalcode);

	public List<ActiveSeasonProjection> getVcode(Integer villagecode);

}
