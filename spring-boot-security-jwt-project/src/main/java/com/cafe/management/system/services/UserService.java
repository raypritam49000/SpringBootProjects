package com.cafe.management.system.services;

import java.util.Optional;

import com.cafe.management.system.dto.UserDto;

public interface UserService {
	 public Optional<UserDto> findByEmail(String email);
	 public UserDto createUser(UserDto userDto);
}
