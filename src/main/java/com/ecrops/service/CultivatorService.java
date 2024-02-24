package com.ecrops.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecrops.entity.Cultivator;

@Service
public interface CultivatorService {

	public List<Cultivator> listAll();

	public List<Cultivator> getCultivatorsByKathaNo(Integer fromkhno, Integer crVcode, Integer cryear,String crSeason);
	
	public List<Cultivator> getCultivatorsByKathaNo(Cultivator cultivator);
	
	public List<Cultivator> getCcrcDetailsByKathaNo(Integer fromkhno, Integer crVcode, Integer cryear,String crSeason);

	public int updateOwnerOrEnjoerDetails(Cultivator cultivator);
	
	public int updateCcrcDetails(Cultivator cultivator);

	public Cultivator saveCultivatorsData(Cultivator cultivator);

	public int updateCultivatorDetails(Cultivator cultivator);

	public void deleteCultivatorDetails(Cultivator cultivator);

	public Float getAnubhavadarExtent(Cultivator cultivator);

	public Float getTotalOccupantExtent(Cultivator cultivator);

}
