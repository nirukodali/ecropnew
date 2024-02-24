package com.ecrops.service.impl;

import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecrops.dto.VillageNormalAreasDTO;
import com.ecrops.entity.RegularExpressionclassMethod;
import com.ecrops.repo.UpdationRepo;
import com.ecrops.service.UpdationService;

@Service
public class UpdationServiceImpl implements UpdationService {

	@Autowired
	UpdationRepo updationRepo;

//private static final Logger logger = LoggerFactory.getLogger(UpdationServiceImpl.class);

	@Transactional

	public void updateNormalAreas(List<VillageNormalAreasDTO> villageNormalAreasDTOList, int mcode, int dcode,
			int selectedCrop, String user, int type) {
		RegularExpressionclassMethod method = new RegularExpressionclassMethod();

		for (VillageNormalAreasDTO dto : villageNormalAreasDTOList) {
			String area = dto.getNormalarea().toString();
			Boolean ext = method.checkExtent(area);
			try {
				if (ext) {
					System.out.println("Updating normalarea for wbdcode: " + dcode + ", wbmcode: " + mcode + ", vcode: "
							+ dto.getVcode() + ", Cropcode():" + " nrmlarea: " + dto.getNormalarea());
					if (type == 5)
						updationRepo.updateNormalArea(dto.getNormalarea(), dcode, mcode, dto.getVcode(), selectedCrop,
								user);
					if (type == 22)
						updationRepo.updateNormalAreaHo(dto.getNormalarea(), dcode, dto.getVcode(), selectedCrop, user);
				}
			} catch (Exception e) {
				//System.out.println("Exception while updating normalarea: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
