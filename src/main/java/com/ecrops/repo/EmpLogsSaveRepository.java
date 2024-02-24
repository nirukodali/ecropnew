package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class EmpLogsSaveRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int saveEmployeeLogDetails(Integer dcode,Integer emp_code, Integer mcode, 
			Integer rbkcode2, String rbkuserid, Integer wbdcode, Integer wbmcode) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_logs(dcode, empcode, mcode, rbkcode, rbkuserid, wbdcode, wbmcode, ts) VALUES (?, ?, ?, ?, ?, ?, ?, now())";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, emp_code);
		sql.setParameter(3, mcode);
		sql.setParameter(4, rbkcode2);
		sql.setParameter(5, rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}
	
	@Transactional
	public int updateEmployeeLogDetails(Integer empcode, Integer rbkcode) {
		String updateQry ="update ecrop2023.emp_rbk_map_logs set to_date=now()  where rbkcode=? and empcode=?";
		Query sql = entityManager.createNativeQuery(updateQry);
		sql.setParameter(1, rbkcode);
		sql.setParameter(2, empcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
}
	
	@Transactional
	public int insertEmployeeLogDetails(Integer rbkcode, Integer empcode) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_logs dcode, mcode, vcode, rbkcode, empcode, ts, rbkuserid, ipaddress, "
				+ "wbdcode, wbmcode, incharge_sts, to_date) SELECT dcode, mcode, vcode, rbkcode, empcode, ts, rbkuserid, ipaddress,"
				+ " wbdcode, wbmcode, incharge_sts,now() FROM ecrop2023.emp_rbk_map where rbkcode=? and empcode=? ";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, rbkcode);
		sql.setParameter(2, empcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
}
	
	@Transactional
	public int insertEmployeeLogincts(Integer dcode,Integer mcode, Integer rbkcode, 
			Integer empcode, Integer rbkuserid, Integer wbdcode, Integer wbmcode, String inchargeStsUpd) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_logs(dcode,mcode,rbkcode,empcode, rbkuserid,wbdcode,wbmcode,incharge_sts, ts) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, now())";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, mcode);
		sql.setParameter(3, rbkcode);
		sql.setParameter(4, empcode);
		sql.setParameter(5, "RBK_" + rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		sql.setParameter(8, inchargeStsUpd);

		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}
	
	@Transactional
	public int updateEmployeerbkmapstatus(String inchargeStsUpd, Integer empcode,Integer rbkcode,Integer rbkuserid,Integer  rbkcode1) {
		String updateQry ="update ecrop2023.emp_rbk_map set status='A',ts=now(),incharge_sts=?,empcode=?,rbkcode=? ,rbkuserid=? where  rbkcode=? ";
		Query sql = entityManager.createNativeQuery(updateQry);
		sql.setParameter(1, inchargeStsUpd);
		sql.setParameter(2, empcode);
		sql.setParameter(3, rbkcode);
		sql.setParameter(4, "RBK_" + rbkuserid);
		sql.setParameter(5, rbkcode1);
		int executeUpdate = sql.executeUpdate();
		System.out.println("executeUpdate"+executeUpdate);
		return executeUpdate;
}
	@Transactional
	public int updaterbkmapregularstatus( Integer empcode,Integer rbkcode,Integer rbkuserid,Integer  rbkcode2) {
		String updateQry ="update ecrop2023.emp_rbk_map set status='A',ts=now(),incharge_sts='R',empcode=?,rbkcode=? ,rbkuserid=? where  rbkcode=?";
		Query sql = entityManager.createNativeQuery(updateQry);
		sql.setParameter(1, empcode);
		sql.setParameter(2, rbkcode);
		sql.setParameter(3, "RBK_" + rbkuserid);
		sql.setParameter(4, rbkcode2);
		
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
}
	
	@Transactional
	public int insertEmployeeincts(Integer dcode,Integer mcode, Integer rbkcode, 
			Integer empcode, Integer rbkuserid, Integer wbdcode, Integer wbmcode) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map(dcode,mcode,rbkcode,empcode,rbkuserid,wbdcode,wbmcode,incharge_sts) VALUES ( ?, ?, ?, ?, ?, ?, ?,'R')";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, mcode);
		sql.setParameter(3, rbkcode);
		sql.setParameter(4, empcode);
//		sql.setParameter(5, ts);
		sql.setParameter(5, "RBK_" + rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}

	@Transactional
	public int insertEmployeeincharges(Integer dcode, Integer mcode,Integer rbkcode,Integer empcode,Integer rbkuserid,Integer wbdcode,Integer wbmcode,String inchargests,String status) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_incharges(dcode, mcode, rbkcode, empcode, rbkuserid,wbdcode,wbmcode,inchargests,status) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, mcode);
		sql.setParameter(3, rbkcode);
		sql.setParameter(4, empcode);
		sql.setParameter(5, rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		sql.setParameter(8, inchargests);
		sql.setParameter(9, status);
		
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
}
	

}
