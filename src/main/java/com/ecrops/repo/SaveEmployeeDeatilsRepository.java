package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class SaveEmployeeDeatilsRepository {

	public SaveEmployeeDeatilsRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int saveEmployeeLogDetails(Integer district,
			Integer mandal, String aadhar_id, Integer emp_code, String emp_name, String email, long mobile, String designation) {
		String insertQry ="INSERT INTO ecrop2023.cr_emp_profile (dcode, mcode, aadhaar_id, emp_code, emp_name, email, mobile, designation) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, district);
		sql.setParameter(2, mandal);
		sql.setParameter(3, aadhar_id);
		sql.setParameter(4, emp_code);
		sql.setParameter(5, emp_name);
		sql.setParameter(6, email);
		sql.setParameter(7, mobile);
		sql.setParameter(8, designation);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}


}
