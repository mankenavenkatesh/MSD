package com.multi.server.dependency.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Value("${name}")
	private String name;
	
	public String getHelloText(){
		return "Hello"+name;
	}
}
