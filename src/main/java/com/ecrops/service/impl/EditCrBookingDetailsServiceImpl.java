package com.ecrops.service.impl;

import com.ecrops.dto.UserRegistrationDto;
import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import com.ecrops.projection.ActiveSeasonProjection;
import com.ecrops.repo.EditCrBookingDetailsRepository;
import com.ecrops.repo.VillageSecRevRepository;
import com.ecrops.service.EditCrBookingDetailsService;
import com.ecrops.service.VillageSecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditCrBookingDetailsServiceImpl implements EditCrBookingDetailsService {

    EditCrBookingDetailsRepository editCrBookingDetailsRepository;

    public EditCrBookingDetailsServiceImpl(EditCrBookingDetailsRepository editCrBookingDetailsRepository) {
        this.editCrBookingDetailsRepository = editCrBookingDetailsRepository;
    }

    public List<EditCrBookingDtlsEntity> geEditCrBookingDetails(EditCropBookingDetailsModel ecbd) {
        return editCrBookingDetailsRepository.geEditCrBookingDetails(ecbd);
    }
    public void updateCrAadharNo(EditCrBookingDtlsEntity ecbd){
        editCrBookingDetailsRepository.updateCrAadharNo(ecbd);
    }

}
