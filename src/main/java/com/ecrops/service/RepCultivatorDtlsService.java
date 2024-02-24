package com.ecrops.service;

import com.ecrops.entity.Cultivator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepCultivatorDtlsService {
    public List<Cultivator> getRepCultivatorsDtlsByAadharNo(String aadharNo, String userId, String tableName);

}
