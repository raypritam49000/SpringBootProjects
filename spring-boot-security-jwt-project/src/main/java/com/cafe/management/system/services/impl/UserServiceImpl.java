package com.cafe.management.system.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cafe.management.system.dto.UserDto;
import com.cafe.management.system.entity.User;
import com.cafe.management.system.repository.UserRepository;
import com.cafe.management.system.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private ModelMapper modelMapper;

	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<UserDto> findByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isPresent()) {
			return Optional.of(modelMapper.map(optionalUser.get(), UserDto.class));
		}
		return Optional.empty();
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return modelMapper.map(userRepository.save(modelMapper.map(userDto, User.class)), UserDto.class);
	}

}
