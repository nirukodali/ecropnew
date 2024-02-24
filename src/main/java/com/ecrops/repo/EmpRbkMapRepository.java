package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class EmpRbkMapRepository {

	public EmpRbkMapRepository() {
		
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int saveEmpRbkMapDetails(Integer dcode, Integer mcode, Integer rbkcode2, Integer emp_code,  
			 String rbkuserid ,Integer wbdcode, Integer wbmcode) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map(dcode, mcode, rbkcode, empcode, rbkuserid, wbdcode, wbmcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, mcode);
		sql.setParameter(3, rbkcode2);
		sql.setParameter(4, emp_code);
		sql.setParameter(5, rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}

}
