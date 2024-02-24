package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class RbkEntityRepository {

	public RbkEntityRepository() {
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int updateEmpDetails(String incsts,Integer emp, Integer rbkCode) {
		String insertQry ="update  ecrop2023.emp_rbk_map set incharge_sts=?, empcode=? where rbkcode=?";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, incsts);
		sql.setParameter(2, emp);
		sql.setParameter(3, rbkCode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
	}
	
	@Transactional
	public int updateEmpDetails1(String incsts,Integer emp, Integer rbkCode) {
		String insertQry ="update  ecrop2023.emp_rbk_map set incharge_sts=?, empcode=? where rbkcode=?";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, incsts);
		sql.setParameter(2, emp);
		sql.setParameter(3, rbkCode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
	}

}
