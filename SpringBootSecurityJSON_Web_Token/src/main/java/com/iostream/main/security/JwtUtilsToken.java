package com.iostream.main.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtilsToken 
{	
	private final long JWT_EXPIRATION= 1000*60*10;
	
	private final Key secretKey=  Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	
	public String generateToken(UserDetails userDetails)
	{
		
		String jwt_token = Jwts.builder()
		     .setSubject(userDetails.getUsername())
		     .setIssuedAt(new Date (System.currentTimeMillis()))
		     .setExpiration(new Date (System.currentTimeMillis() +JWT_EXPIRATION))
		     .signWith(secretKey)
		     .compact();
		
		
		
		return jwt_token;
	}
}
