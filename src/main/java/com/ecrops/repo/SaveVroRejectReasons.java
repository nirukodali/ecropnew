package com.ecrops.repo;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class SaveVroRejectReasons {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int saveVroRejectReasonsDetails(String wbldcode, String mandcode, String sesvcode, String partKey, String userid, String clientip, 
			String tableName, String bookingIdList, String cropCodeList, String cropNumberList, 
			String varietyCodeList, String khathaNumberList, String surveyNumberList, String sownDateLst, String rejectreason) {
		
		String insertQuery = "INSERT INTO "+tableName+"(cr_dist_code,cr_mand_code,cr_vcode,bookingid,cr_crop,cr_no,variety,kh_no,cr_sno,cr_sow_dt,rej_reason,part_key,crt_user,clientip) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Query insertSQL = entityManager.createNativeQuery(insertQuery);
		
		int executeInsert = 0;
		String [] bookids = bookingIdList.split(",");
		String [] cropCodes = cropCodeList.split(",");
		String [] cropNumbers = cropNumberList.split(",");
		String [] varietyCodes = varietyCodeList.split(",");
		String [] khathaNumbers = khathaNumberList.split(",");
		String [] surveyNumbers = surveyNumberList.split(",");
		String [] sownDates = sownDateLst.split(",");
		System.out.println("Total booking Ids -------->   "+bookids.length);
		
		for (int i = 0; i < bookids.length; i++) {

			String reason1[] = rejectreason.split("\\$");
            String reason[] = reason1[i].split(",");
            
            System.out.println("Reasons length --------> "+reason.length);
            System.out.println("Booking Id ---------> "+Integer.parseInt(bookids[i]));

            for (int j = 0; j < reason.length; j++) {
         	   
            	insertSQL.setParameter(1, Integer.parseInt(wbldcode));
            	insertSQL.setParameter(2, Integer.parseInt(mandcode));
            	insertSQL.setParameter(3, Integer.parseInt(sesvcode));
            	insertSQL.setParameter(4, Integer.parseInt(bookids[i]));
            	insertSQL.setParameter(5, Integer.parseInt(cropCodes[i]));
            	insertSQL.setParameter(6, cropNumbers[i].toString());
            	insertSQL.setParameter(7, Integer.parseInt(varietyCodes[i]));
            	insertSQL.setParameter(8, Integer.parseInt(khathaNumbers[i]));
            	insertSQL.setParameter(9, surveyNumbers[i].toString());
            	insertSQL.setParameter(10, Date.valueOf(sownDates[i]));
            	insertSQL.setParameter(11, Integer.parseInt(reason[j]));
            	insertSQL.setParameter(12, partKey.toString());
            	insertSQL.setParameter(13, userid.toString());
            	insertSQL.setParameter(14, clientip.toString());
            	executeInsert = insertSQL.executeUpdate();
            	
            }
        }
		
		
		return executeInsert;
		
	}
	
}
