package com.ecrops.service;

import org.springframework.stereotype.Service;

import com.ecrops.entity.UserRegEntity;

@Service
public interface UserRegService {

	UserRegEntity getSessionValues(String userId);

}
