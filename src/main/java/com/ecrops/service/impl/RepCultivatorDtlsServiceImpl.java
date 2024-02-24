package com.ecrops.service.impl;

import com.ecrops.entity.Cultivator;
import com.ecrops.repo.RepCultivatorDtlsRepository;
import com.ecrops.service.RepCultivatorDtlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepCultivatorDtlsServiceImpl implements RepCultivatorDtlsService {

    @Autowired
    private RepCultivatorDtlsRepository repCultivatorDtlsRepository;


    public List<Cultivator> getRepCultivatorsDtlsByAadharNo(String aadharNo, String userId, String tableName) {
        return repCultivatorDtlsRepository.getRepCultivatorsDtlsByAadharNo(aadharNo, userId, tableName);
    }

}
