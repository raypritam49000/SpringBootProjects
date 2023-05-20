package com.criteria.query.rest.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criteria.query.rest.api.dto.PersonDTO;
import com.criteria.query.rest.api.repository.PesronRepository;
import com.criteria.query.rest.api.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

	private PesronRepository pesronRepository;
	private ModelMapper mapper;

	@Autowired
	public void setPesronRepository(PesronRepository pesronRepository) {
		this.pesronRepository = pesronRepository;
	}

	@Autowired
	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		return pesronRepository.findAll().stream().map(person -> this.mapper.map(person, PersonDTO.class))
				.collect(Collectors.toList());
	}

}
