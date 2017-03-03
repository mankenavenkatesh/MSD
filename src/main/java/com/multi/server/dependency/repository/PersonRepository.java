package com.multi.server.dependency.repository;

import org.springframework.data.repository.CrudRepository;

import com.multi.server.dependency.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

	  // additional custom finder methods go here
	}