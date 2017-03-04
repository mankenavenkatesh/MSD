package com.multi.server.dependency.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.server.dependency.domain.MSDEntity;
import com.multi.server.dependency.repository.MSDRepository;

@Component
public class MSDDao {

	@Autowired
	MSDRepository msdRepository;
	
	public MSDEntity getMSDEntity(String id){		
		return msdRepository.findOne(id);
	}
}
