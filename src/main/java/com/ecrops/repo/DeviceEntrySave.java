package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class DeviceEntrySave {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int Savedevice(Integer vcode, String imei1, String imei2, String status, String ipadress) {
		String insertQry = "INSERT INTO devicedet( vcode, imei1, imei2, status, cropyear, season, deviceslno, crt_client)VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, vcode);
		if (imei1 != "" && imei2 == "") {
			sql.setParameter(2, imei1);
			sql.setParameter(3, imei1);
			sql.setParameter(7, "F");
		} else if (imei1 == "" && imei2 != "") {
			sql.setParameter(2, imei2);
			sql.setParameter(3, imei2);
			sql.setParameter(7, "A");
		}
		sql.setParameter(4, "A");
		sql.setParameter(5, 2023);
		sql.setParameter(6, "R");
		sql.setParameter(8, ipadress);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
	}

	@Transactional
	public int SaveDelDevice(Integer deviceid, String status) {
		String updateQry = "update devicedet set status='I'  where deviceid=? and status=?";
		Query sql = entityManager.createNativeQuery(updateQry);
		sql.setParameter(1, deviceid);
		sql.setParameter(2, status);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
	}

	public DeviceEntrySave() {
	}

}
