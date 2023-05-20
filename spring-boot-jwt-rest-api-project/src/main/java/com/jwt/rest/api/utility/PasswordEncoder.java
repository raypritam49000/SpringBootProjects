package com.jwt.rest.api.utility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	public static String encode(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(10));
	}

	public static boolean isMatch(String password, String hashPassword) {
		return BCrypt.checkpw(password, hashPassword);
	}
}