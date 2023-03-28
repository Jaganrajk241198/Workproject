package com.projectincedoplay.jwtutils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class Jwtutils {

	private static String secret = "This is secret";
	
	public String generateJwt(UserPojo pojo) {
		
		Date issuedat = new Date();
		
		//claims
		Claims claims = Jwts.claims()
				.setIssuer(pojo.toString()).setIssuedAt(issuedat);
		
		//generate jwt using claims
		return Jwts.builder().setClaims(claims).compact();
		
		
	}
	
	
}
