package com.multi.server.dependency.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.server.dependency.domain.Person;
import com.multi.server.dependency.repository.PersonRepository;

@Component
public class PersonDao {

	@Autowired
	PersonRepository personRepository;
	
	public Person getPerson(String id){
		return personRepository.findOne(id);
	}
}
