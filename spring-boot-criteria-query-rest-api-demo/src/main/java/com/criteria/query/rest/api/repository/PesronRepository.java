package com.criteria.query.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criteria.query.rest.api.entity.Person;

public interface PesronRepository extends JpaRepository<Person, String> {

}
