package com.ecrops.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ecrops.dto.UserRegistrationDto;
import com.ecrops.entity.AppUser;


public interface UserService extends UserDetailsService{
	
	AppUser save(UserRegistrationDto userRegistrationDto);

}
