package com.multi.server.dependency.repository;

import org.springframework.data.repository.CrudRepository;

import com.multi.server.dependency.domain.MSDEntity;

public interface MSDRepository extends CrudRepository<MSDEntity, String> {

	  // additional custom finder methods go here
	}