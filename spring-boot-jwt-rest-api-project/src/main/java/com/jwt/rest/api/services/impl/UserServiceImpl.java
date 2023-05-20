package com.jwt.rest.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.entity.User;
import com.jwt.rest.api.exceptions.NotFoundException;
import com.jwt.rest.api.repository.UserRepository;
import com.jwt.rest.api.services.IUserService;
import com.jwt.rest.api.utility.PasswordEncoder;

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
	public  UserDto findByUsername(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("User Not Found with :" + username));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto createUser(UserDto userDTO) {
		userDTO.setPassword(PasswordEncoder.encode(userDTO.getPassword()));
		User user = modelMapper.map(userDTO, User.class);
		User createUser = userRepository.save(user);
		return modelMapper.map(createUser, UserDto.class);
	}

}
