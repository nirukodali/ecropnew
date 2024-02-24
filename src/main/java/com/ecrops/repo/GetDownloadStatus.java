package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class GetDownloadStatus {
	
	public GetDownloadStatus() {
		super();
	}

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Character getDownloadStatus(String wbdcode, String wbvcode, String cropyear, String tseason) {
		Character executeUpdate = null;
		String tbname1 = "ecrop2023.cr_booking_partition_" + tseason + wbdcode + cropyear;
		String insertQry ="select distinct downloaded from " + tbname1 + " where cr_vcode = ? and downloaded='Y'";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, Integer.parseInt(wbvcode));
		executeUpdate = (Character) sql.getSingleResult();
		return executeUpdate;
	}


}
