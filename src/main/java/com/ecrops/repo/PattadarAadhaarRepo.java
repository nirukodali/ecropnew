package com.ecrops.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ecrops.entity.PattadarUpdate;

@Component
public class PattadarAadhaarRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<PattadarUpdate> getDetails(String partitionName, int cropyear, String season, int vcode, String surveyNo, String khataNo) {
		String qry = "select cr_dist_code,cr_mand_code,dcode,mcode,cr_vcode,oc_name,oc_fname,kh_no,cr_sno,regno,sjointoccupant,data_src,cr_year,cr_season \r\n"
				+ "from " + partitionName + " where cr_year=" + cropyear + " and cr_season='" + season
				+ "' and cr_vcode=" + vcode + "  and (length(cr_farmeruid)<12 or cr_farmeruid is null) \r\n"
				+ "and data_src='W' and cultivator_type is null  and uidupdated is null ";
		if(surveyNo!="" && surveyNo != null  && !surveyNo.isEmpty()){
            qry+=" and cr_sno='"+surveyNo+"'  " ;
         }
           if(khataNo!= "" && khataNo != null   && !khataNo.isEmpty()){
            qry+=" and kh_no="+khataNo+"  " ;
         }
		List<PattadarUpdate> data = new ArrayList<>();
		Query sql = entityManager.createNativeQuery(qry);
		List<Object> objects = sql.getResultList();

		if (objects != null && objects.size() > 0) {

			for (Object patta : objects) {

				Object[] row = (Object[]) patta;

				PattadarUpdate pojos = new PattadarUpdate();
				pojos.setCr_dist_code(row[0].toString());
				pojos.setCr_mand_code(row[1].toString());
				pojos.setDcode(row[2].toString());
				pojos.setMcode(row[3].toString());
				pojos.setCr_vcode(row[4].toString());
				pojos.setOc_name(row[5].toString());
				pojos.setOc_fname(row[6].toString());
				pojos.setKh_no(row[7].toString());
				pojos.setCr_sno(row[8].toString());
				pojos.setRegno(row[9].toString());
				pojos.setSjointoccupant(row[10].toString());
				pojos.setData_src(row[11].toString());
				pojos.setCr_year(row[12].toString());
				pojos.setCr_season(row[13].toString());
				
				
				data.add(pojos);
			}

		}

		return data;

	}

	@Transactional
	public int updateAadhaar(String partitionName, String aadhaar, int regno, int sjointoccupant, int cr_vcode,
			int cr_year, String season, String data_src) {
		
		String qry = " UPDATE " + partitionName + " set cr_farmeruid=? ,uidupdated='Y'  \r\n"
				+ " where regno=? and sjointoccupant=? and cr_vcode=? and uidupdated is null \r\n"
				+ " and cr_year=? and cr_season=?  and cultivator_type is null and data_src=?  \r\n" + " ";

		entityManager.createNativeQuery(qry).setParameter(1, aadhaar).setParameter(2, regno)
				.setParameter(3, sjointoccupant).setParameter(4, cr_vcode).setParameter(5, cr_year)
				.setParameter(6, season).setParameter(7, data_src).executeUpdate();
		return 1;
	}

}
