package com.ecrops.partitions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.CropwiseExtBookedMaoIntf;

@Repository
@Transactional
public class CropwiseExtBookedMaoIntfPartition {

	@PersistenceContext
	private EntityManager entityManager;

	public List<CropwiseExtBookedMaoIntf> getCrpExt(String dcode, String mcode, String cr_crop, String cropyear,
			String cropgrpid) {

		String[] season = cropyear.split("@");

		String cseason = season[0];
		System.out.println("cseason=========" + cseason);
		Integer Year = Integer.parseInt(season[1]);
		System.out.println("Year=========" + Year);

		String part_key1 = cseason + Year;

		System.out.println("part_key1==========>" + part_key1);

		String tableName = "ecrop" + Year + "." + "rep_vill_wise_cropwise_ext_v_" + part_key1;

		System.out.println("tableName---------------->" + tableName);
		String qry = "";

		if (cropgrpid.isEmpty() && cr_crop.trim().isEmpty()) {
			qry = " select wbvname,sum(totextent) as totext ,wbvcode from " + tableName + " "
					+ " where dcode=? and mcode=? and cr_year=? and cr_season=? group by wbvcode,wbvname  ";
			Query insertQuery = (Query) entityManager.createNativeQuery(qry);
			insertQuery.setParameter(1, Integer.parseInt(dcode));
			insertQuery.setParameter(2, Integer.parseInt(mcode));
			insertQuery.setParameter(4, Year);
			insertQuery.setParameter(5, cseason);
			List<Object[]> detailsEntities1 = insertQuery.getResultList();
			// System.out.println("detailsEntities1=>"+detailsEntities1.size());
			// System.out.println("detailsEntities1=>"+detailsEntities1.toString());
			List<CropwiseExtBookedMaoIntf> detailsEntities = new ArrayList<CropwiseExtBookedMaoIntf>();

			for (Object[] row : detailsEntities1) {

				CropwiseExtBookedMaoIntf entity = new CropwiseExtBookedMaoIntf();

				entity.setWbvname((String) row[0]);
				entity.setTotext((BigDecimal) row[1]);
				entity.setWbvcode((Integer) row[2]);
				detailsEntities.add(entity);

			}

			return detailsEntities;

		} else if (!cropgrpid.isEmpty() && cr_crop.isEmpty()) {
			qry = " select wbvname,sum(totextent) as totext,wbvcode from " + tableName + " where"
					+ " dcode=? and mcode=? and grpcode=? and cr_year=? and cr_season=? "
					+ "group by wbvcode,wbvname  ";

			Query insertQuery = (Query) entityManager.createNativeQuery(qry);
			insertQuery.setParameter(1, Integer.parseInt(dcode));
			insertQuery.setParameter(2, Integer.parseInt(mcode));
			insertQuery.setParameter(2, Integer.parseInt(cropgrpid));
			insertQuery.setParameter(4, Year);
			insertQuery.setParameter(5, cseason);
			List<Object[]> detailsEntities1 = insertQuery.getResultList();
			// System.out.println("detailsEntities1=>"+detailsEntities1.size());
			// System.out.println("detailsEntities1=>"+detailsEntities1.toString());
			List<CropwiseExtBookedMaoIntf> detailsEntities = new ArrayList<CropwiseExtBookedMaoIntf>();

			for (Object[] row : detailsEntities1) {

				CropwiseExtBookedMaoIntf entity = new CropwiseExtBookedMaoIntf();

				entity.setWbvname((String) row[0]);
				entity.setTotext((BigDecimal) row[1]);
				entity.setWbvcode((Integer) row[2]);
				detailsEntities.add(entity);

			}

			return detailsEntities;

		} else if (cr_crop != null && !cr_crop.isEmpty()) {
			qry = " select wbvname,sum(totextent) as totext,wbvcode from " + tableName + "  where "
					+ "dcode=? and mcode=? and cr_crop=? and cr_year=? and cr_season=? group by wbvcode,wbvname  ";
			Query insertQuery = (Query) entityManager.createNativeQuery(qry);
			insertQuery.setParameter(1, Integer.parseInt(dcode));
			insertQuery.setParameter(2, Integer.parseInt(mcode));
			insertQuery.setParameter(3, Integer.parseInt(cr_crop));
			insertQuery.setParameter(4, Year);
			insertQuery.setParameter(5, cseason);

			List<Object[]> detailsEntities1 = insertQuery.getResultList();
			// System.out.println("detailsEntities1=>"+detailsEntities1.size());
			// System.out.println("detailsEntities1=>"+detailsEntities1.toString());
			List<CropwiseExtBookedMaoIntf> detailsEntities = new ArrayList<CropwiseExtBookedMaoIntf>();

			for (Object[] row : detailsEntities1) {

				CropwiseExtBookedMaoIntf entity = new CropwiseExtBookedMaoIntf();

				entity.setWbvname((String) row[0]);
				entity.setTotext((BigDecimal) row[1]);
				entity.setWbvcode((Integer) row[2]);
				detailsEntities.add(entity);

			}

			return detailsEntities;

		}

		return null;

	}

}
