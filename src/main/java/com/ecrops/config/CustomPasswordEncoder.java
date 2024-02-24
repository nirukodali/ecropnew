package com.ecrops.config;


import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
//		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		
	//	return DigestUtils.sha256Hex(DigestUtils.sha256Hex(rawPassword.toString().getBytes()));
	
		//System.out.println("puli------------------------->"+ DigestUtils.sha256Hex((rawPassword.toString().getBytes())));
		return DigestUtils.sha256Hex((rawPassword.toString().getBytes()));

		
		
		//return DigestUtils.md5Hex(DigestUtils.md5Hex(rawPassword.toString().getBytes()).getBytes());
	//	return rawPassword.toString();
//		return Sha512DigestUtils.shaHex(rawPassword.toString().getBytes());
	}

	 @Override
	    public boolean matches(CharSequence rawPassword, String encodedPassword) {
		 
//		 System.out.println("rawPassword >>>>"+rawPassword);
////	        String rawEncoded = encode(rawPassword);
//	        
//	        System.out.println("rawEncoded >>>>"+rawPassword +" >>> "+encodedPassword);
	        return Objects.equals(rawPassword.toString().split("_")[1], encodedPassword.toString());
	        
	    }
	 
}

	 
	 
	

	 	 
