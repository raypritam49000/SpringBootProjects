package com.criteria.query.rest.api.ultility.jwt;

import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.criteria.query.rest.api.dto.UserDTO;

public class JwtUtility {

	public static final String SECRET = "secret";
	public static final String ISSUER = "issuer";

	public static String createToken(UserDTO userDTO) {
		String token = JWT.create().withJWTId(userDTO.getId()).withSubject(userDTO.getUsername())
				.withClaim("id", userDTO.getId()).withClaim("username", userDTO.getUsername())
				.withClaim("email", userDTO.getEmail()).withIssuedAt(new Date(System.currentTimeMillis()))
				.withExpiresAt(new Date(System.currentTimeMillis() + 1000L * 60L * 60L * 24L)).withIssuer(ISSUER)
				.sign(Algorithm.HMAC256(SECRET));
		return token;
	}

	public static UserDTO getUserDtoFromToken(String token) {
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
		DecodedJWT decodedJWT = jwtVerifier.verify(token);
		String id = decodedJWT.getClaim("id").asString();
		String username = decodedJWT.getClaim("username").asString();
		String email = decodedJWT.getClaim("email").asString();
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setEmail(email);
		userDTO.setUsername(username);
		return userDTO;
	}
	
	public static Boolean verifyToken(String token) {
		try {
			JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build().verify(token);
		  return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		  return false;
		}
	}
}
