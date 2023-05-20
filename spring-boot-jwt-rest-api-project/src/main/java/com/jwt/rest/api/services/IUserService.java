package com.jwt.rest.api.services;

import com.jwt.rest.api.dto.UserDto;

public interface IUserService {
	public Boolean isExistsByUsername(String username);

	public UserDto findByUsername(String username);

	public UserDto createUser(UserDto userDTO);
}