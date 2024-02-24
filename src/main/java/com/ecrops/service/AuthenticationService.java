package com.ecrops.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Roles;

@Service
public interface AuthenticationService {

	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException;

	public Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Roles> roles);
}
