package com.multi.server.dependency.controller;

import org.springframework.web.bind.annotation.RestController;

import com.multi.server.dependency.service.MSDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MSDController {

	@Autowired
	MSDService msdService;
	
    @RequestMapping("/")
    public String index() {
    	return "Welcome to" +msdService.getName();
        // return "Welcome to MSD";
    }

}