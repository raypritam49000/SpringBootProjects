package com.jwt.rest.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employess")
public class EmployeeController {
	
	@GetMapping
	public String hello() {
		return "This is Hello";
	}

}
