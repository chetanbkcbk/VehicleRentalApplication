package com.example.vehiclerentingapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(csrf->csrf.disable())   //cross site request forgery->a token that is issued to client side and are one time use only
		.authorizeHttpRequests(authorize->authorize.requestMatchers("/customer/register","/renting-partner/register","/vehicles")
				.permitAll().anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.build();
		
	}
	
}