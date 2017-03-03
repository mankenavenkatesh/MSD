package com.multi.server.dependency.controller;

import org.springframework.web.bind.annotation.RestController;

import com.multi.server.dependency.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
    @RequestMapping("/")
    public String index() {
    	return helloService.getHelloText();
        // return "Welcome to MSD";
    }

}