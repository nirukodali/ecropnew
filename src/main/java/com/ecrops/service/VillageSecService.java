package com.ecrops.service;

import com.ecrops.projection.ActiveSeasonProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VillageSecService {
    public List<ActiveSeasonProjection> getVillageListByRbk(Integer vsCode);

}
