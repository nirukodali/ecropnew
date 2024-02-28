package com.ecrops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(requests -> requests.antMatchers("/registration/**", "/custom/**", "/js/**", "/css/**",
				"/img/**", "/images/**", "/home/**", "/cultivator/**", "/cultivator/kathaNo/**", "/bootstrap/**",
				"/customCSS/**", "/customJS/**", "/fonts/**", "/sass/**", "/login-auth/**", "/cultivator/owner/update",
				"/cultivator/save", "/cultivator/update", "/cultivator/delete", "cultivator/extent",
				"/weblandCropEntry/**", "/fetch-crop-data/", "/ccrcCropEntry/**", "/fetch-ccrc-crop-data/**",
				"/rest/api/Ccrc-Crop/**", "/rest/api/webland-crop/villages","/allocOfSurveyNo/**","/getPattaDetails/**","/saveSelectionInRBK/**",
				"/getRevenueVillage/**","/getEmployeeByRevenue/**","/getDetails/**","/getSurveyNoDetails/**","/saveSrnoinCrbooking/**","/selectionOfSurveyNo/**","/VroRejectReasons/**","/saveSelection/**",
				"/nonweblandfarmersdata/**","/surveyno/**","/postdata/**", "/repCultivatorDtls/**", "/editCropBookingDtls/**", "/editCropBookingDtls/updateUid/**","/DeviceRegistration/**","/SaveDeviceRegistration/**",
				"/unsurveyed/**","/UnsurveyedSearch/**","/saveUnsurveyedData/**","/aadhaarSearch/**","/aadhaarupdation/**","/updated/**","./datadownload/**","/saveDatadownload**/",
				"/getEfishDataEntry/**","/efishFormEntryData/**","/rest/api/efish/**",
				"/villseclist","/vaadet","/supchkra","/supchk","/crpwiseextent","/crpwiseextent1","/statewsrc").permitAll().anyRequest().permitAll())
	
		
		
				.formLogin(login -> login.loginPage("/login").permitAll().defaultSuccessUrl("/", true)) //h
				
				.logout(logout -> {
					try {
						logout.invalidateHttpSession(true).clearAuthentication(true)
								.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								.logoutSuccessUrl("/login?logout").
						       logoutUrl("/logout")
						       .and().csrf().disable().cors();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
