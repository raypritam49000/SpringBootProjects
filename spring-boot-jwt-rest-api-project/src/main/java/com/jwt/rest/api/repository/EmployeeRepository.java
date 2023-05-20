package com.jwt.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.rest.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
