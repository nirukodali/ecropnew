package com.ecrops.repo;

import com.ecrops.entity.Cultivator;
import com.ecrops.entity.RepCultivatorDtlsEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RepCultivatorDtlsRepository{

	JdbcTemplate jdbcTemplate;

	public List<Cultivator> getRepCultivatorsDtlsByAadharNo(String cr_farmeruid, String userId, String tableName){
		String dtlsQuery = "select to_char(DT_EKYC::date,'dd/mm/yyyy') as dt_ekyc,ekytxn,smsmobileno,cr_no,cultdesc_loclang,varietyname,occupname,ekycname,occupfname,"
				+ " cr_dist_code,cr_mand_code,cr_vcode,wbdname,wbmname,wbvname,'XXXXXXXX'||substr(cr_farmeruid,9) as cr_farmeruid,kh_no,bookingid,"
				+ " cr_sno,cr_mix_unmix_ext,cr_crop,ekyc_dob,cropins,cropname,wsrcdesc, cr_season||'harif,'||cr_year as cropduration, ins_scheme,pmfbycode, "
				+ " to_char(cr_sow_date::date,'dd-mm-yyyy') as sow_date,cr_sow_date from " + tableName + " where cr_farmeruid= '"+cr_farmeruid+"' and updatedby= '"+userId+"'";
		//Query query = jdbcTemplate.
		//List list = query.getResultList();
		return null;
	}

	private static class RepCultivatorDtlsRowMapper implements RowMapper<RepCultivatorDtlsEntity>{

		@Override
		public RepCultivatorDtlsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			/*return new RepCultivatorDtlsEntity(rs.getString(""), rs.getString(""),
					rs.getString(""), rs.getString(""), rs.getString(""),
					rs.getString(""), rs.getString(""), rs.getString(""),
					rs.getString(""), rs.getString(""),rs.getString("") );*/
			return null;
		}
	}

}
