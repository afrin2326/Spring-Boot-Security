package com.iostream.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig 
{
	@Bean
	public UserDetailsService userDetailsService()
	{
		
		
		UserDetails adminDetails=User.builder()
									.username("admin")
									.password(passwordEncoder().encode("admin123"))
									.roles("ADMIN")
									.build();
		
		UserDetails userDetails=User.builder()
										.username("afrin")
										.password(passwordEncoder().encode("afrin123"))
										.roles("USER")
										.build();
		
		
		return new InMemoryUserDetailsManager(adminDetails,userDetails);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
			.authorizeHttpRequests()
				.requestMatchers("/guest").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/user").hasRole("USER")
				.anyRequest().authenticated()
				.and()
			.httpBasic();
				
		
		return http.build();
	}

}
