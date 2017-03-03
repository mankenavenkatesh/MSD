package com.multi.server.dependency.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.multi.server.dependency.dao.PersonDao;
import com.multi.server.dependency.domain.Person;

@Service
public class PersonService {

	@Value("${name}")
	private String name;
	
	@Autowired
	private PersonDao personDao;
	
	public String getHelloText(){
		Person person=personDao.getPerson("cba6d0e2-6198-4e75-be0c-081afbf5458a");
		return "Hello"+person.getName();
	}
}
