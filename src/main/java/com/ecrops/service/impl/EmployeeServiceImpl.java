package com.ecrops.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Emplogsentity;
import com.ecrops.entity.Employeename;
import com.ecrops.entity.WbVillageEntity;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.projection.DeviceProjection;
import com.ecrops.projection.EmployeeName;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.VillageName;
import com.ecrops.projection.WbVillageRepository;
import com.ecrops.repo.DistrictRepo;
import com.ecrops.repo.DownloadSaveRepo;
import com.ecrops.repo.EmpLogsRepo;
import com.ecrops.repo.EmpLogsSaveRepository;
import com.ecrops.repo.EmpRbkMapIncharges;
import com.ecrops.repo.EmpRepo;
import com.ecrops.repo.InchargeRbkRepo;
import com.ecrops.repo.MandalRepo;
import com.ecrops.repo.RbkInchRepo;
import com.ecrops.repo.RbkRepo;
import com.ecrops.repo.UserTypesRepo;
import com.ecrops.repo.VillRepo;
import com.ecrops.repo.VillSecRepo;
import com.ecrops.repo.WbvillageRepository;
import com.ecrops.service.EmployeeService;

@Service
public class EmployeeServiceImpl<rbkcode>  implements EmployeeService {
	
	@Autowired
	private EmpRepo repo;
	
	@Autowired
	private RbkRepo repo2;
	
	@Autowired
	private InchargeRbkRepo inchargeRbkRepo;
	
	@Autowired
	private EmpLogsRepo empLogsRepo;
	
	@Autowired
	private WbvillageRepository wbvillageRepository;
	
	@Autowired
	private UserTypesRepo userTypesRepo;
	
	@Autowired
	private VillRepo secRepo;
	
	@Autowired
	private VillSecRepo villsec;
	
	@Autowired
	private MandalRepo mandalRepo;
	
	@Autowired
	private DistrictRepo districtRepo;
	
	@Autowired
	private RbkInchRepo inchRepo;
@Autowired
	private EmpLogsSaveRepository empLogsSaveRepository;
	
	@Autowired
	private EmpRbkMapIncharges empRbkMapIncharges;
	
	@Autowired
	private DownloadSaveRepo downloadrepo;

	@Override
	public List<Employeename> addingEmployee(Integer district, Integer mandal, Integer village, 
			String aadharId, Integer empCode, String empName, String email, Long mobileNo) {
		return repo.saveEmployeeRegistration(district, mandal, village, aadharId, empCode, empName, email, mobileNo);
	}

	@Override
	public List<Employeename> getAllEmployees() {
		return null;
	}

	@Override
	public List<Employeename> getAadharExists(String aadharId) {
		return repo.getAadharExits(aadharId);
	}
	
	@Override
	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, Integer empCode) {
		return repo2.getEmployeeDetails(district, mandal, empCode);
	}

	@Override
	public List<InchargeRbkProjection> getInchargeStatus(Integer rbkCode) {
		return inchargeRbkRepo.getInchargeStatus(rbkCode);
	}

	@Override
	public Optional<Emplogsentity> saveEmpLogDetails(Integer dcode, Integer emp_code,Integer mcode,Integer rbkcode2,String rbkuserid, Integer vcode,Integer wbdcode,Integer wbmcode) {
		return empLogsRepo.saveEmplogs(dcode, emp_code, mcode, rbkcode2, rbkuserid, vcode, wbdcode, wbmcode);
	}

	@Override
	public List<InchargeRbkProjection> getRbkDetailsToSave(Integer rbkCode) {
		return inchargeRbkRepo.getRbkDetailsToSave(rbkCode);
	}

	@Override
	public List<RbkDetailsProjection> updateInchargeStatus(String incStatus, Integer empCode, Integer rbkCode) {
		return inchargeRbkRepo.updateInchargeStatus(incStatus,empCode,rbkCode);
	}
	
	@Override
	public List<WbVillageRepository> getWebLandDetails(Integer dcode,Integer mcode) {
		return wbvillageRepository.getWebLandDetails(dcode, mcode);
	}

	@Override
	public List<ActiveSeasonProjection> getUserType(Integer usertype) {
		return userTypesRepo.getUserType(usertype);
	}

	@Override
	public List<VillageName> getVillName(Integer villCode) {
		return secRepo.getVillName(villCode);
	}

	@Override
	public List<VillageName> getMandalName(Integer mandalCode) {
		return mandalRepo.getmandalName(mandalCode);
	}
	
	@Override
	public List<VillageName> getDistName(Integer distCode) {
		return districtRepo.getDistName(distCode);

	}

	@Override
	public List<InchargeRbkProjection> getDMcode(Integer distcode, Integer mandalcode) {
		return inchRepo.getDMcode(distcode, mandalcode);
	}

	@Override
	public List<RbkDetailsProjection> getRegDMcode(Integer distcode, Integer mandalcode) {
		return inchargeRbkRepo.getRegDMcode(distcode, mandalcode);
		}
//	rbkmapping
	@Override
	public List<EmployeeName> getEmpProfile(Integer dcode, Integer mcode, Integer empcode) {
		// TODO Auto-generated method stub
		return repo.getEmpProfile(dcode, mcode, empcode);
	}

	@Override
	public List<InchargeRbkProjection> getmandempcode(Integer mandal, Integer empcode) {
		// TODO Auto-generated method stub
		return inchargeRbkRepo.getmandempcode(mandal, empcode);
	}

	@Override
	public List<InchargeRbkProjection> getEmprbkmcode(Integer mcode,Integer empcode, Integer rbkcode) {
		// TODO Auto-generated method stub
		return inchargeRbkRepo.getEmprbkmcode(mcode,empcode, rbkcode);
	}

	@Override
	public int updateEmployeeLogDetails(Integer rbkcode, Integer empcode) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.updateEmployeeLogDetails(rbkcode, empcode);
	}

	@Override
	public int insertEmployeeLogDetails(Integer rbkcode, Integer empcode) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.insertEmployeeLogDetails(rbkcode, empcode);
	}

	@Override
	public int insertEmployeeLogincts(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode, Integer rbkuserid,
			Integer wbdcode, Integer wbmcode, String inchargeStsUpd) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.insertEmployeeLogincts(dcode, mcode, rbkcode, empcode, rbkuserid, wbdcode, wbmcode, inchargeStsUpd);
	}

	@Override
	public int updateEmployeerbkmapstatus(String inchargeStsUpd,Integer empcode, Integer rbkcode, Integer rbkuserid, Integer rbkcode1) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.updateEmployeerbkmapstatus(inchargeStsUpd,empcode, rbkcode, rbkuserid, rbkcode1);
	}

	@Override
	public int updaterbkmapregularstatus(Integer empcode, Integer rbkcode, Integer rbkuserid, Integer rbkcode2) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.updaterbkmapregularstatus(empcode, rbkcode, rbkuserid, rbkcode2);
	}

	@Override
	public List<InchargeRbkProjection> rbkstatus(Integer mcode, Integer rbkcode) {
		// TODO Auto-generated method stub
		return  inchargeRbkRepo.rbkstatus(mcode, rbkcode) ;
	}

	@Override
	public int insertEmployeeincts(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode, Integer rbkuserid,
			Integer wbdcode, Integer wbmcode) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.insertEmployeeincts(dcode, mcode, rbkcode, empcode, rbkuserid, wbdcode, wbmcode);
	}

	@Override
	public int insertEmployeeincharges(Integer dcode, Integer mcode, Integer rbkcode, Integer empcode,
			Integer rbkuserid, Integer wbdcode, Integer wbmcode, String inchargests,String status) {
		// TODO Auto-generated method stub
		return empLogsSaveRepository.insertEmployeeincharges(dcode, mcode, rbkcode, empcode, rbkuserid, wbdcode, wbmcode, inchargests ,status);
	}
	@Override
	public List<InchargeRbkProjection> getadaDMcode(Integer district, Integer mandal) {
		return inchRepo.getadaDMcode(district, mandal);
	}
	
	@Override
	public int updateADAIch(String maoRecList, String justifyIdList, Integer district, Integer mandal, String rbkusersList,
			String empcodeList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateADAIch(maoRecList, justifyIdList, district, mandal, rbkusersList, empcodeList);
	}
	
	
	@Override
	public List<InchargeRbkProjection> getdaoDMcode(Integer distCode, Integer mandalcode) {
		return inchRepo.getdaoDMcode(distCode, mandalcode);
	}
	
	@Override
	public int updateDAOIch(String maoRecList, String justifyIdList, String ada_appr, Integer district, Integer mandal,
			String rbkusersList, String empcodeList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateDAOIch(maoRecList, justifyIdList, ada_appr, district, mandal, rbkusersList, empcodeList);
	}
//DA0
	@Override
	public List<InchargeRbkProjection> getInc(Integer rbkcode, Integer empcode) {
		// TODO Auto-generated method stub
		return inchRepo.getInc(rbkcode, empcode);
	}
	@Override
	public List<InchargeRbkProjection> getInclogic(Integer rbkcode, String rbkuserid) {
		// TODO Auto-generated method stub
		return inchRepo.getInclogic(rbkcode, rbkuserid);
	}

	@Override
	public int updateRBK(Integer empcodeList , Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateRBK(empcodeList,rbkusersList );
	}

	@Override
	public List<InchargeRbkProjection> getcheckrbklogs(Integer rbkcode,String rbkuserid) {
		// TODO Auto-generated method stub
		return inchRepo.getcheckrbklogs(rbkcode, rbkuserid) ;
	}

	@Override
	public int inslogs(Integer dcode, Integer mcode, String rbkusersList, String empcodeList,String rbkusersList2,
			Integer wbdcode, Integer wbmcode, String inchargests){
		// TODO Auto-generated method stub
		return empRbkMapIncharges.inslogs(dcode, mcode, rbkusersList, empcodeList,rbkusersList2, wbdcode, wbmcode, inchargests) ;
	}

	@Override
	public List<InchargeRbkProjection> getpincharge(Integer rbkcode) {
		// TODO Auto-generated method stub
		return inchRepo.getpincharge(rbkcode);
	}

	@Override
	public int updateinch(Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateinch(rbkusersList);
	}

	@Override
	public int updateinch2(Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateinch2(rbkusersList);
	}

	@Override
	public int updateinch3(Integer empcodeList,Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updateinch3(empcodeList, rbkusersList);
	}

	@Override
	public int inslogs2(Integer rbkusersList,Integer empcodeList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.inslogs2(rbkusersList, empcodeList);
	}

	@Override
	public int inslogs3(Integer empcodeList, Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.inslogs3(empcodeList, rbkusersList);
	}
	
	@Override
	public int inslogs4(Integer rbkusersList,Integer empcodeList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.inslogs4(rbkusersList, empcodeList);
	}

	@Override
	public int updatelogsfinal(Integer rbkusersList) {
		// TODO Auto-generated method stub
		return empRbkMapIncharges.updatelogsfinal(rbkusersList);
	}

	//DeviceRegistration
		@Override
		public List<ActiveSeasonProjection> getVcode(Integer villagecode) {
			// TODO Auto-generated method stub
			return villsec.getVcode(villagecode);
		}
		
		@Override
		public List<ActiveSeasonProjection> getVname(Integer district, Integer mandalcode) {
			return villsec.getVname(district, mandalcode);
		}

		@Override
		public int savedownload(String tbname1, Integer vcode) {
			return downloadrepo.savedownload(tbname1, vcode);
		}

		@Override
		public int insertdownload(String activeYear, Integer vcode, String userid, String remoteAddr, Integer preasonId,
				Integer cropyear, String season) {
			return downloadrepo.insertdownload(activeYear, vcode, userid, remoteAddr, preasonId, cropyear, season);
		}


		

		//Device Deletion
//		@Override
//		public List<DeviceProjection> getdevicedet(String mcode, String vcode) {
//			// TODO Auto-generated method stub
//			return devicedel.getdevicedet(mcode,vcode);
//		}
//
//		@Override
//		public int SaveDelDevice(Integer deviceid, String status) {
//			// TODO Auto-generated method stub
//			return devsave.SaveDelDevice(deviceid, status);
//		}

		
}
