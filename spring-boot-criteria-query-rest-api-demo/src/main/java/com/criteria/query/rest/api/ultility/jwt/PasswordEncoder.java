package com.criteria.query.rest.api.ultility.jwt;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static Boolean isMatchPassword(String plainPassword, String hashPassword) {
		return BCrypt.checkpw(plainPassword, hashPassword);
	}
}
