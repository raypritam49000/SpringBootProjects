package com.criteria.query.rest.api.service;

import java.util.List;

import com.criteria.query.rest.api.dto.PersonDTO;

public interface IPersonService {
	public List<PersonDTO> getAllPersons();
}
