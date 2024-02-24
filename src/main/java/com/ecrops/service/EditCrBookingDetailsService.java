package com.ecrops.service;

import com.ecrops.model.EditCrBookingDtlsEntity;
import com.ecrops.model.EditCropBookingDetailsModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EditCrBookingDetailsService {
    List<EditCrBookingDtlsEntity> geEditCrBookingDetails(EditCropBookingDetailsModel ecbd);
    void updateCrAadharNo(EditCrBookingDtlsEntity ecbd);

}
