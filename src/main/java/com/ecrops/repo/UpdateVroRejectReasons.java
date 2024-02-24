package com.ecrops.repo;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class UpdateVroRejectReasons {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int updateVroRejectReasonsDetails(Integer activeYear, Integer cropyear, String season, String wbldcode, String sesvcode, 
			String bookingIdList, String cropCodeList, String cropNumberList, 
			String varietyCodeList) {
		
		int executeUpdate = 0;
		String [] bookids = bookingIdList.split(",");
		String [] cropCodes = cropCodeList.split(",");
		String [] cropNumbers = cropNumberList.split(",");
		String [] varietyCodes = varietyCodeList.split(",");
		
//		ZoneId indianTimeZone = ZoneId.of("Asia/Kolkata");
//        Instant currentUTC = Instant.now();
//        ZonedDateTime indianTime = ZonedDateTime.ofInstant(currentUTC, indianTimeZone);
//        Timestamp currentTimestamp = Timestamp.from(indianTime.toInstant());
        
//        LocalDateTime currentDateTime = LocalDateTime.now();
		
		Instant currentUtcTime = Instant.now();

        // Convert to Indian Standard Time (IST)
        ZonedDateTime indianTime = currentUtcTime.atZone(ZoneId.of("Asia/Kolkata"));

        
//        Instant currentUtcTime = Instant.now();
		
//		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		
		
		
		String partitionName = "cr_details_";
        if (wbldcode.length()==1) {
            wbldcode="0"+wbldcode;
        } 
        partitionName =partitionName+ season+wbldcode+cropyear;
     
        if(activeYear.equals(cropyear)){
        	partitionName="ecrop"+activeYear+"."+partitionName;
        }
        
        System.out.println("Update Table name ------------> "+partitionName);
        
        String pvro_verify = "Y";
        String updateQuery = "update "+partitionName+" set vro_verify=?,dt_vroverify=? where cr_dist_code=? and bookingid=? and cr_crop=? and cr_no=? and cr_vcode=? and variety=?";
        Query updateSQL = entityManager.createNativeQuery(updateQuery);

        for (int j = 0; j < bookids.length; j++) {
       	 updateSQL.setParameter(1, pvro_verify);
       	 updateSQL.setParameter(2, indianTime);
       	 updateSQL.setParameter(3, Integer.parseInt(wbldcode));
       	 updateSQL.setParameter(4, Integer.parseInt(bookids[j]));
       	 updateSQL.setParameter(5, Integer.parseInt(cropCodes[j]));
       	 updateSQL.setParameter(6, cropNumbers[j]);
       	 updateSQL.setParameter(7, Integer.parseInt(sesvcode));
       	 updateSQL.setParameter(8, Integer.parseInt(varietyCodes[j]));
       	 executeUpdate = updateSQL.executeUpdate();
        }
		
		return executeUpdate;
		
	}
	
}
