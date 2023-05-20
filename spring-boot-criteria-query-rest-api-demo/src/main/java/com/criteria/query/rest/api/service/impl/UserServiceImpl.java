package com.criteria.query.rest.api.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.criteria.query.rest.api.dto.UserDTO;
import com.criteria.query.rest.api.entity.User;
import com.criteria.query.rest.api.exceptions.ResourceNotFoundException;
import com.criteria.query.rest.api.repository.UserRepository;
import com.criteria.query.rest.api.service.IUserService;
import com.criteria.query.rest.api.ultility.jwt.PasswordEncoder;

@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public Boolean isExistsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public UserDTO findByUsername(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found with :" + username));
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		userDTO.setPassword(PasswordEncoder.hashPassword(userDTO.getPassword()));
		User user = modelMapper.map(userDTO, User.class);
		User createUser = userRepository.save(user);
		return modelMapper.map(createUser, UserDTO.class);
	}

}
