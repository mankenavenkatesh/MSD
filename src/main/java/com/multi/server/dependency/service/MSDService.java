package com.multi.server.dependency.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.multi.server.dependency.dao.MSDDao;
import com.multi.server.dependency.domain.MSDEntity;

@Service
public class MSDService {

	
	
	@Autowired
	private MSDDao msdDao;
	
	public String getName(){
		MSDEntity msd=msdDao.getMSDEntity("eeeff630-92c3-4115-8ee8-b4258f673fcd");
		return msd.getName();
	}
}
