package com.jwt.rest.api.utility;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.jwt.rest.api.dto.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	public static final String SECRET_KEY = "Pritam Ray";
	public static final String ISSUER = "Issuer";
	public static Key signingKey = new SecretKeySpec(DatatypeConverter.parseBase64Binary(SECRET_KEY),
			SignatureAlgorithm.HS256.getJcaName());

	public static String generateToken(UserDto userDto) {

		return Jwts.builder().setIssuer(ISSUER).setSubject(userDto.getUsername()).claim("id", userDto.getId())
				.claim("username", userDto.getUsername()).claim("email", userDto.getEmail())
				// Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
				.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
				// Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
				.setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				.signWith(SignatureAlgorithm.HS256,signingKey)
				.compact();
	}

	public static UserDto userFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
		UserDto userDto = new UserDto();
		userDto.setId((String) claims.get("id"));
		userDto.setUsername((String) claims.get("username"));
		userDto.setEmail((String) claims.get("email"));
		return userDto;
	}

	public static Boolean verifyToken(String token) {
		try {
			Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}