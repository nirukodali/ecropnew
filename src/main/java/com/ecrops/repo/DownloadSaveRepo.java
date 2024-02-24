package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class DownloadSaveRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int savedownload(String tbname1, Integer cr_vcode) {
		String updateQry = "update " + tbname1
				+ " set downloaded=null where cr_vcode =? and (((uploaded is null or insertedby='Y') and cultivator_type is not null and downloaded='Y' ) OR (uploaded='Y' and peri_status like 'R%') OR (uploaded='Y' and mao_unlock_appr='A')) ";
		Query sql = entityManager.createNativeQuery(updateQry);
		sql.setParameter(1, cr_vcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;

	}
	@Transactional
	public int insertdownload(String activeYear,Integer vcode,String userid, String remoteAddr,Integer preasonId,Integer cropyear,String season ) {
	String insertQry="INSERT INTO ecrop" + activeYear + ".DataRedownload(  wbvcode, userid, ipaddress,reasonid ,cropyear,season)  VALUES (?, ?, ? ,?, ? ,?)";
	Query sql = entityManager.createNativeQuery(insertQry); 
	sql.setParameter(1, vcode);
	sql.setParameter(2, userid);
	sql.setParameter(3, remoteAddr);
	sql.setParameter(4, preasonId);

	sql.setParameter(5, cropyear);
	sql.setParameter(6, season);
	int executeUpdate = sql.executeUpdate();
	return executeUpdate;

	}
}