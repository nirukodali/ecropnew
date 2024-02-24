package com.ecrops;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ecrops.config.CustomPasswordEncoder;

@SpringBootApplication
public class EcropApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EcropApplication.class);

	}

	public static void main(String[] args) {
		SpringApplication.run(EcropApplication.class, args);
	}

}
