package com.ecrops.service.impl;

import org.springframework.stereotype.Service;

import com.ecrops.repo.crop.WbMasterRepository;

@Service
public class WbMasterServiceCcrc {

    private WbMasterRepository wbMasterRepository;


    public WbMasterServiceCcrc(WbMasterRepository wbMasterRepository) {
        this.wbMasterRepository = wbMasterRepository;
    }

    public String getVillageNameByCode(Integer wbvcode) {
        return wbMasterRepository.findVillageNameByWbvcode(wbvcode);
    }
}