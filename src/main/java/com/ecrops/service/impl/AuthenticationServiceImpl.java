package com.ecrops.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Roles;
import com.ecrops.repo.UserRegRepo;
import com.ecrops.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRegRepo repo1;

	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		List<Object[]> bean = repo1.find(user);
		if (!bean.isEmpty()) {
			Object[] userBeanArr = bean.get(0);
			String userName = ((String) userBeanArr[0]).trim();
			String pwd = (String) userBeanArr[1];
			String role = (String) userBeanArr[2];
			List<Roles> resultList = Arrays.asList();
			return new User(userName, pwd, mapRolesToAuthorities(resultList));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + user);
		}
	}

	public Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Roles> roles) {
		Collection<? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return mapRoles;
	}
}
