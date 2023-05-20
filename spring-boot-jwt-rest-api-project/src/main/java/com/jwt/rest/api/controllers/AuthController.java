package com.jwt.rest.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.services.IUserService;
import com.jwt.rest.api.utility.JwtUtils;
import com.jwt.rest.api.utility.PasswordEncoder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDto userDTO) {
		try {

			Boolean isExistsUser = userService.isExistsByUsername(userDTO.getUsername());

			if (isExistsUser) {
				return new ResponseEntity<>(Map.of("success", false, "message", "User already register", "status",
						"CONFLICT", "statusCode", 409), HttpStatus.CONFLICT);
			} else {
				UserDto createUser = userService.createUser(userDTO);
				return new ResponseEntity<>(Map.of("success", true, "status", "CREATED", "message",
						"User has been register successfully", "statusCode", 201, "user", createUser),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(Map.of("success", false, "status", "message", "Server Error",
					"INTERNAL_SERVER_ERROR", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDTO) {
		try {

			UserDto existsUser = userService.findByUsername(userDTO.getUsername());

			if (existsUser != null) {

				if (PasswordEncoder.isMatch(userDTO.getPassword(), existsUser.getPassword())) {
					String token = JwtUtils.generateToken(existsUser);

					return new ResponseEntity<>(Map.of("success", true, "status", "OK", "statusCode", 200, "message",
							"User has been login successfully", "token", token), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(Map.of("success", false, "status", "FORBIDDEN", "statusCode", 401,
							"message", "Password does not match!!"), HttpStatus.FORBIDDEN);
				}

			} else {
				return new ResponseEntity<>(Map.of("success", false, "status", "NOT_FOUND", "statusCode", 404,
						"message", "User Not Found!!"), HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<>(Map.of("success", false, "status", "INTERNAL_SERVER_ERROR", "message",
					"Server Error", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
