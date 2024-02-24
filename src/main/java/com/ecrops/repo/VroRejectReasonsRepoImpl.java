package com.ecrops.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ecrops.entity.VroRejectReasonsEntity;

@Repository
public class VroRejectReasonsRepoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VroRejectReasonsEntity> findDynamicTableData(Integer vscode, String tableName) {
        String queryStr = "SELECT bookingid, kh_no, cr_sno, tot_extent, cropname, oc_name, oc_fname, cr_no, varietyname, cr_farmeruid, cr_crop, cr_sow_date, variety FROM " + tableName + " WHERE cr_vcode = :vscode and vroauth='N' and vro_verify is null limit 100";
        Query query = entityManager.createNativeQuery(queryStr, VroRejectReasonsEntity.class);
        query.setParameter("vscode", vscode);
        return query.getResultList();
    }
}

