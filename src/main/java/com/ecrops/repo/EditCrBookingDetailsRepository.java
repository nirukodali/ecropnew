package com.ecrops.repo;

import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class EditCrBookingDetailsRepository {

    private final JdbcTemplate jdbcTemplate;

    public EditCrBookingDetailsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EditCrBookingDtlsEntity> geEditCrBookingDetails(EditCropBookingDetailsModel ecbd) {

        String query = "select cropname,varietyname,occupname,occupfname,oc_name,oc_fname,cr_sno,kh_no,cr_vcode,bookingid,cr_crop, cr_no,cr_sow_date,variety,cr_farmeruid " +
                " from ecrop2023.cr_details_r042023 a,cropnames c,cr_variety_master d where  a.cr_crop=c.cropid and a.variety=d.varietycode and  cr_vcode=" + ecbd.getvCode() + " and cr_year=" + ecbd.getCropYear() + " and cr_season='" + ecbd.getSeason() + "' " +
                "and owner_tenant='O' " + getSearchValue(ecbd) + "and vaaauth ='Y' and vroauth='Y' and ekyc is null and bookingid not in " +
                " (select bookingid from ecrop2023.cr_details_org_details where correctiontype='" + ecbd.getCorrectionType() + "' and  cr_vcode=417003) ";

        List<EditCrBookingDtlsEntity> ecbdList = jdbcTemplate.query(query, new EditCrBookingDetailsRowMapper<EditCrBookingDtlsEntity>());

        return ecbdList;
    }

    public void updateCrAadharNo(EditCrBookingDtlsEntity ecbd) {

        Integer cropyear = ecbd.getCropyear();
        String wbdocde = (ecbd.getWbdcode()<=9 ? "0"+ecbd.getWbdcode() : String.valueOf(ecbd.getWbdcode()));
        String tab1 = "cr_booking_partition_" + ecbd.getSeason() + wbdocde + cropyear;
        String tab2 = "cr_details_" + ecbd.getSeason() + wbdocde + cropyear;
        String crdetails_org = "cr_details_org_details";

        tab1 = "ecrop" + cropyear + "." + tab1;
        tab2 = "ecrop" + cropyear + "." + tab2;
        crdetails_org = "ecrop" + cropyear + "." + crdetails_org;

        String crdorg_qry = " INSERT INTO " + crdetails_org + "( " +
                " part_key, bookingid, cr_dist_code, cr_mand_code, cr_vcode, kh_no, cr_sno, cr_year, cr_season, cr_month, cr_sow_type, cr_crop, cr_mix_unmix_ext, cr_no, cr_w_draw, cr_irr_type, cr_1st_ext, cr_2nd_ext, cr_3rd_ext, cr_yield, cr_vaa_remarks, cr_mao_remarks, wtr_tax, regno, cr_sow_date, longitude, latitude, imei, uploaded, updatedby, updateon, ipaddress, dcode, mcode, cropage, nooftrees, cropratio, cropins, ctype, variety, irrmethod, crsowtype, crratio, data_src, sno_notmatch, cropseed_scheme, oldbookingid, croptypebyirr, tarahacode, irrcategory, age, soc_category, dt_ins_reg, ins_reg_status, cr_farmeruid, owner_tenant, occupname, occupfname, email, mobileno, gender, avgbodyweight, harvestqty, stocking_size, tankid,"
                + " harvest_date,  dt_cropins_reg, tot_extent, occupant_extent, sand_extent, erosion_extent, ip_downloaded, qty_produced, qty_available_faq, qty_discolored_nonfaq, qty_sprouted_nonfaq, dt_ipins_reg, dt_change, calamity_id, crpins_family_auth, crpins_family_uid, dt_upd_reg, refbookingid, cr_farmeruid_old, dt_uid_upd, oc_name, oc_fname, anubhavadar_name, landownership_type, cultivator_type, cr_tr_d_ext, cr_tr_i_ext, irr_updatedby, irr_updated_dt, variety_old, dt_varietycd_upd, actual_cultivator, crop_ins_approval, ins_approved_ext, actual_yield, qty_sold, approve_usr_id, ins_approved_dt, ins_cropname_st, crpins_mao_st, crpins_maormks, crpins_jda_st, crpins_jdarmks, uidname_eng, cr_ins_revalidate, reason_non_auth, reauth_ts, auth_date, mismatch, claim_status, ekycname, ekyc_gender, ekyc_add, ekyc_dob, farming_type, seed_production, digitally_signed, ekyc, dt_ekyc, vaaauth, vroauth, dt_vroauth, dt_vaaauth, maocheck, daocheck, jccheck,"
                + "  smsmobileno, ekytxn, farmer_confirm, ekyc_namematch, diff_rec, vaa_txn, vro_txn, vro_verify, dt_vroverify, correctiontype, correction_date, vao_verify) " +
                " SELECT part_key, bookingid, cr_dist_code, cr_mand_code, cr_vcode, kh_no, cr_sno, cr_year, cr_season, cr_month, cr_sow_type, cr_crop, cr_mix_unmix_ext,"
                + "  cr_no, cr_w_draw, cr_irr_type, cr_1st_ext, cr_2nd_ext, cr_3rd_ext, cr_yield, cr_vaa_remarks, cr_mao_remarks, wtr_tax, regno, cr_sow_date, longitude, latitude, imei,"
                + " uploaded, updatedby, updateon, ipaddress, dcode, mcode, cropage, nooftrees, cropratio, cropins, ctype, variety, irrmethod, crsowtype, crratio, data_src, sno_notmatch,"
                + " cropseed_scheme, oldbookingid, croptypebyirr, tarahacode, irrcategory, age, soc_category, dt_ins_reg, ins_reg_status, cr_farmeruid, owner_tenant, occupname, occupfname, "
                + " email, mobileno, gender, avgbodyweight, harvestqty, stocking_size, tankid, harvest_date,  dt_cropins_reg, tot_extent, occupant_extent, sand_extent, erosion_extent,"
                + " ip_downloaded, qty_produced, qty_available_faq, qty_discolored_nonfaq, qty_sprouted_nonfaq, dt_ipins_reg, dt_change, calamity_id, crpins_family_auth, crpins_family_uid, "
                + " dt_upd_reg, refbookingid, cr_farmeruid_old, dt_uid_upd, oc_name, oc_fname, anubhavadar_name, landownership_type, cultivator_type, cr_tr_d_ext, cr_tr_i_ext, irr_updatedby, "
                + " irr_updated_dt, variety_old, dt_varietycd_upd, actual_cultivator, crop_ins_approval, ins_approved_ext, actual_yield, qty_sold, approve_usr_id, ins_approved_dt, ins_cropname_st, "
                + " crpins_mao_st, crpins_maormks, crpins_jda_st, crpins_jdarmks, uidname_eng, cr_ins_revalidate, reason_non_auth, reauth_ts, auth_date, mismatch, claim_status, ekycname, ekyc_gender, "
                + " ekyc_add, ekyc_dob, farming_type, seed_production, digitally_signed, ekyc, dt_ekyc, vaaauth, vroauth, dt_vroauth, dt_vaaauth, maocheck, daocheck, jccheck, smsmobileno, "
                + " ekytxn, farmer_confirm, ekyc_namematch,"
                + " diff_rec, vaa_txn, vro_txn, vro_verify, dt_vroverify,'15',now(), vao_verify  " +
                " FROM "
                + tab2 + " where  bookingid=:bookingid and cr_sow_date=:cr_sow_date and cr_crop=:cr_crop and cr_vcode=:cr_vcode and cr_no=:cr_no and variety=:variety  " +
                "   and cr_year=:cr_year and cr_season=:cr_season ";

        crdorg_qry += getSearchValue(ecbd);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("bookingid", ecbd.getBookingid());
        parameters.put("cr_sow_date", Date.valueOf(ecbd.getCr_sow_date()));
        parameters.put("cr_crop", ecbd.getCr_crop());
        parameters.put("cr_vcode", ecbd.getCr_vcode());
        parameters.put("cr_no", ecbd.getCr_no());
        parameters.put("variety", Integer.parseInt(ecbd.getVariety()));
        parameters.put("cr_year", cropyear);
        parameters.put("cr_season", ecbd.getSeason());

        int result = jdbcTemplate.update(crdorg_qry, parameters);
        System.out.println("Updated : "+result + " Records.");


        /*String updcrbqry = "  UPDATE " + tab1 + " set cr_farmeruid_old=?, cr_farmeruid=? where bookingid=? and cr_vcode=?   and cr_year=?  and cr_season=?  ";
        updcrbqry += getSearchValue(ecbd);

        pst3 = con.prepareStatement(updcrbqry);
        for (int i = 0; i < bkids.length; i++) {
            pst3.setString(1, oldUids[i]);
            pst3.setString(2, newUids[i]);
            pst3.setInt(3, Integer.parseInt(bkids[i]));
            pst3.setInt(4, Integer.parseInt(vcode));
            pst3.setInt(5, Integer.parseInt(cropyear));
            pst3.setString(6, season);

            pst3.addBatch();
        }

        int updCrbres[] = pst3.executeBatch();


        String qry = "  UPDATE " + tab2 + " set  ekyc_uid_mismatch='Y',cr_farmeruid_old=?,cr_farmeruid=? where "
                + " ekyc is null and vaaauth='Y' and vroauth='Y' and bookingid=? and cr_sow_date::date=? and cr_crop=? and cr_vcode=? and cr_no=? and variety=?   and cr_year=?  and cr_season=?  ";
        qry += getSearchValue(ecbd);

        pst = con.prepareStatement(qry);
        for (int i = 0; i < bkids.length; i++) {
            pst.setString(1, oldUids[i]);
            pst.setString(2, newUids[i]);
            pst.setInt(3, Integer.parseInt(bkids[i]));
            pst.setDate(4, Date.valueOf(sowDates[i]));
            pst.setInt(5, Integer.parseInt(crcodes[i]));
            pst.setInt(6, Integer.parseInt(vcode));
            pst.setString(7, crnos[i]);
            pst.setInt(8, Integer.parseInt(varietyCodes[i]));
            pst.setInt(9, Integer.parseInt(cropyear));
            pst.setString(10, season);

            pst.addBatch();
        }

        int res[] = pst.executeBatch();*/


    }

    public String getSearchValue(EditCrBookingDtlsEntity ecbd) {
        String searchValue = "";
        if (ecbd.getCr_sno() != null && !ecbd.getCr_sno().isEmpty()) {
            searchValue += " and cr_sno='" + ecbd.getCr_sno() + "'";
        } else if (ecbd.getKh_no() != null) {
            searchValue += " and kh_no=" + ecbd.getKh_no();
        } else if (ecbd.getCr_farmeruid() != null) {
            searchValue += " and cr_farmeruid='" + ecbd.getCr_farmeruid() + "'";
        }
        return searchValue;
    }

    public String getSearchValue(EditCropBookingDetailsModel ecbd) {
        String searchValue = "";
        if ("1".equalsIgnoreCase(ecbd.getSearchType())) {
            searchValue = "and cr_sno='" + ecbd.getSurveyNo() + "' ";
        } else if ("2".equalsIgnoreCase(ecbd.getSearchType())) {
            searchValue = "and kh_no = " + ecbd.getKathaNo();
        } else if ("3".equalsIgnoreCase(ecbd.getSearchType())) {
            searchValue = "and cr_farmeruid='" + ecbd.getAadharNo() + "' ";
        }
        return searchValue;
    }

    public static class EditCrBookingDetailsRowMapper<E> implements RowMapper<EditCrBookingDtlsEntity> {

        public EditCrBookingDtlsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            EditCrBookingDtlsEntity ecbd = new EditCrBookingDtlsEntity();
            ecbd.setOccupname(rs.getString("occupname"));
            ecbd.setOccupfname(rs.getString("occupfname"));
            ecbd.setCr_sno(rs.getString("cr_sno"));
            ecbd.setKh_no(rs.getInt("kh_no"));
            ecbd.setCr_vcode(rs.getInt("cr_vcode"));
            ecbd.setBookingid(rs.getInt("bookingid"));
            ecbd.setCr_crop(rs.getInt("cr_crop"));
            ecbd.setCr_no(rs.getString("cr_no"));
            ecbd.setCr_sow_date(rs.getString("cr_sow_date"));
            ecbd.setVariety(rs.getString("variety"));
            ecbd.setCr_farmeruid(rs.getString("cr_farmeruid"));
            ecbd.setOc_name(rs.getString("oc_name"));
            ecbd.setOc_fname(rs.getString("oc_fname"));
            ecbd.setCropname(rs.getString("cropname"));
            ecbd.setVareityname(rs.getString("varietyname"));
            
            return ecbd;
        }
    }
}
