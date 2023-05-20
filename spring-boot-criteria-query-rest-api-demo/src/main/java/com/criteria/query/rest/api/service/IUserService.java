package com.criteria.query.rest.api.service;

import com.criteria.query.rest.api.dto.UserDTO;

public interface IUserService {
	public Boolean isExistsByUsername(String username);
	public UserDTO findByUsername(String username);
	public UserDTO createUser(UserDTO userDTO);
}
