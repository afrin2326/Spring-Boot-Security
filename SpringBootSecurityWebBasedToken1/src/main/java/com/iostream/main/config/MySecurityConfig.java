package com.iostream.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig 
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
			.authorizeHttpRequests()
				.requestMatchers("/guest").permitAll()
				.requestMatchers("/admin").authenticated()
				.and()
			.httpBasic();
				
		
		return http.build();
	}

}
