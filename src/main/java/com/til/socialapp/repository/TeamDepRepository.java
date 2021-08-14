package com.til.socialapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.TeamDep;


public interface TeamDepRepository extends MongoRepository<TeamDep, Integer> {
	

}