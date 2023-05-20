package com.criteria.query.rest.api.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.query.rest.api.dto.PersonDTO;
import com.criteria.query.rest.api.service.IPersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private IPersonService personService;

	@GetMapping
	public String hello(HttpServletRequest request) {
		System.out.println(request.getAttribute("user"));
		return "Hello Pritam Ray";
	}
	
	@GetMapping("/personsList")
	public ResponseEntity<?> getPersons(){
		try {
			List<PersonDTO> persons = personService.getAllPersons();
			if(persons.isEmpty()) {
				return new ResponseEntity<>(Map.of("success", true, "status", "NOT_FOUND", "statusCode", 404,
						"message", "Person Not Found!!","data", persons), HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(Map.of("success", true, "status", "SUCCESS", "message",
						"Person List", "statusCode", 200, "data", persons),
						HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(Map.of("success", false, "status", "message", "Server Error",
					"INTERNAL_SERVER_ERROR", "statusCode", 501), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
