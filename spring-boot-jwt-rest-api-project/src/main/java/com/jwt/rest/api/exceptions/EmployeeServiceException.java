package com.jwt.rest.api.exceptions;

public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = 5776681206288518465L;

	public EmployeeServiceException(String message) {
		super(message);
	}

}