package com.ecrops.service.impl;

import com.ecrops.entity.Cultivator;
import com.ecrops.entity.VillageSecRevEntity;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.repo.RepCultivatorDtlsRepository;
import com.ecrops.repo.VillageSecRevRepository;
import com.ecrops.service.RepCultivatorDtlsService;
import com.ecrops.service.VillageSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageSecServiceImpl implements VillageSecService {

    @Autowired
    VillageSecRevRepository villageSecRevRepository;

    public List<ActiveSeasonProjection> getVillageListByRbk(Integer vsCode) {
        return villageSecRevRepository.getVillageListByRbk(vsCode);
    }

}
