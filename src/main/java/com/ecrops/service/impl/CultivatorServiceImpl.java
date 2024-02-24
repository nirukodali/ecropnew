package com.ecrops.service.impl;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.dto.CultivatorDto;
import com.ecrops.dto.CultivatorEmbedableDto;
import com.ecrops.entity.Cultivator;
import com.ecrops.repo.CultivatorCompositeRepository;
import com.ecrops.repo.CultivatorRepository;
import com.ecrops.service.CultivatorService;

@Service
public class CultivatorServiceImpl implements CultivatorService {

	@Autowired
	private CultivatorRepository repo;

	@Autowired
	CultivatorCompositeRepository cultivatorCompositeRepository;

	public List<Cultivator> listAll() {

		return repo.findAll();
	}

	public List<Cultivator> getCultivatorsByKathaNo(Integer fromkhno, Integer crVcode, Integer cryear,	String crSeason) {
		Cultivator cultivator=new Cultivator();
		cultivator.setKhNo(fromkhno);
		cultivator.setCr_vcode(crVcode);
		cultivator.setCr_year(cryear);
		cultivator.setCr_season(crSeason);
		
		
		return repo.getCultivatorDetailsByKathaNo(cultivator.getKhNo(), cultivator.getCr_vcode(),cultivator.getCr_year(),cultivator.getCr_season());
	}
	
	public List<Cultivator> getCultivatorsByKathaNo(Cultivator cultivator) {
		
		
		return repo.getCultivatorDetailsByKathaNo(cultivator.getKhNo(), cultivator.getCr_vcode(),cultivator.getCr_year(),cultivator.getCr_season());
	}

	@Override
	public int updateOwnerOrEnjoerDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		if (cultivator.getCultivatorType() != null && cultivator.getCultivatorType().equalsIgnoreCase("L")) {
			cultivatorDto.setAadharNo(cultivator.getAadharNo());
		}

		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		System.out.println("aadhaar-------->"+cultivator.getAadharNo());
		cultivatorDto.setAadharNo(cultivator.getAadharNo());
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
		cultivatorDto.setUpdatedby(cultivator.getUpdatedby());
		cultivatorDto.setCult_updatedby(cultivator.getUpdatedby());
		cultivatorDto.setCult_updateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		cultivatorDto.setPeri_status("N");
		cultivatorDto.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		CultivatorDto cDtoResult = cultivatorCompositeRepository.saveAndFlush(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}
	
	@Override
	public int updateCcrcDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		if (cultivator.getCultivatorType() != null && cultivator.getCultivatorType().equalsIgnoreCase("L")) {
			cultivatorDto.setAadharNo(cultivator.getAadharNo());
		}

		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
		cultivatorDto.setUpdatedby(cultivator.getUpdatedby());
		cultivatorDto.setCult_updatedby(cultivator.getUpdatedby());
		cultivatorDto.setCult_updateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		cultivatorDto.setPeri_status("N");
		cultivatorDto.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		CultivatorDto cDtoResult = cultivatorCompositeRepository.saveAndFlush(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}

//	public Cultivator saveCultivatorsData(Cultivator cultivator) {
//		cultivator.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
//		cultivator.setCult_updatedby(cultivator.getUpdatedby());
//		cultivator.setCult_updateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
//		cultivator.setSrno_userid(cultivator.getUpdatedby());
//
//		return repo.save(cultivator);
//	}
	
	public Cultivator saveCultivatorsData(Cultivator cultivator) {
		System.out.println("cultivator--->"+cultivator.getData_src());
		Optional<CultivatorDto> ownerRecord = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getRefBookingId(), cultivator.getPart_key()));
		CultivatorDto ownerData = ownerRecord.get();

		cultivator.setRegno(ownerData.getRegno());
		cultivator.setTotalExtent(ownerData.getTotalExtent());
		cultivator.setCr_wsno(ownerData.getCr_wsno());
		cultivator.setGeo_reffered(ownerData.getGeo_reffered());
		cultivator.setRec_id(ownerData.getRec_id());
		cultivator.setVs_sel(ownerData.getVs_sel());
		cultivator.setPeri_status("N");
		cultivator.setAnubhavadar_name(ownerData.getAnubhavadar_name());
//		cultivator.setOccupname(ownerData.getOccupname());
//		cultivator.setOccupfname(ownerData.getOccupfname());
		cultivator.setOcName(ownerData.getOcName());
		cultivator.setFatherName(ownerData.getFatherName());
		cultivator.setCult_updateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		cultivator.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		
		cultivator.setData_src(ownerData.getData_src());
		cultivator.setCr_tr_d_ext(ownerData.getCr_tr_d_ext());
		cultivator.setCr_tr_i_ext(ownerData.getCr_tr_i_ext()); 
		cultivator.setEmp_code(ownerData.getEmp_code());
		cultivator.setMobileno(ownerData.getMobileno());
		cultivator.setSjointoccupant(ownerData.getSjointoccupant());
		cultivator.setAnubhavadarExtent(ownerData.getAnubhavadarExtent());
		
		return repo.save(cultivator);
	}



	@Override
	public int updateCultivatorDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		CultivatorDto cultivatorDto = optionalDto.get();
		cultivatorDto.setOcName(cultivator.getOcName());
		cultivatorDto.setFatherName(cultivator.getFatherName());
		cultivatorDto.setOccupantExtent(cultivator.getOccupantExtent());
		cultivatorDto.setAadharNo(cultivator.getAadharNo());
		cultivatorDto.setCultivatorType(cultivator.getCultivatorType());
		cultivatorDto.setUpdatedby(cultivator.getUpdatedby());
		cultivatorDto.setUpdateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		cultivatorDto.setCult_updatedby(cultivator.getUpdatedby());
		cultivatorDto.setCult_updateon(Timestamp.from(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).toInstant()));
		
		CultivatorDto cDtoResult = cultivatorCompositeRepository.save(cultivatorDto);

		return cDtoResult != null ? 1 : 0;
	}

	@Override
	public void deleteCultivatorDetails(Cultivator cultivator) {

		Optional<CultivatorDto> optionalDto = cultivatorCompositeRepository
				.findById(new CultivatorEmbedableDto(cultivator.getBookingId(), cultivator.getPart_key()));
		cultivatorCompositeRepository.delete(optionalDto.get());

	}

	public Float getAnubhavadarExtent(Cultivator cultivator) {
		Float anubhavadarExtent = repo.getAnubhavadarExtent(cultivator.getPart_key(), cultivator.getKhNo(),
				cultivator.getCr_vcode(), cultivator.getCrSno());
		anubhavadarExtent = anubhavadarExtent == null ? 0.0f : anubhavadarExtent;
		return anubhavadarExtent;
	}
	
//	public Float getTotalOccupantExtent(Cultivator cultivator) {
//		Float totalOccupantExtent = repo.getTotalOccupantExtent(cultivator.getPart_key(), cultivator.getKhNo(),
//				cultivator.getCr_vcode(), cultivator.getCrSno());
//		totalOccupantExtent = totalOccupantExtent == null ? 0.0f : totalOccupantExtent;
//		return totalOccupantExtent;
//	}

	
	
	public Float getTotalOccupantExtent(Cultivator cultivator) {
		Float totalOccupantExtent = repo.getTotalOccupantExtent(cultivator.getPart_key(), cultivator.getKhNo(),
				cultivator.getCr_vcode(), cultivator.getCrSno());
		totalOccupantExtent = totalOccupantExtent == null ? 0.0f : totalOccupantExtent;
		return totalOccupantExtent;
	}

	@Override
	public List<Cultivator> getCcrcDetailsByKathaNo(Integer fromkhno, Integer crVcode, Integer cryear,	String crSeason) {
		Cultivator cultivator=new Cultivator();
		cultivator.setKhNo(fromkhno);
		cultivator.setCr_vcode(crVcode);
		cultivator.setCr_year(cryear);
		cultivator.setCr_season(crSeason);
		
		
		return repo.getCcrcDetailsByKathaNo(cultivator.getKhNo(), cultivator.getCr_vcode(),cultivator.getCr_year(),cultivator.getCr_season());
	}


}
