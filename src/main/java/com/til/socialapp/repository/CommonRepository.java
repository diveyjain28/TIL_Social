package com.til.socialapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Common;




public interface CommonRepository extends MongoRepository<Common, Integer> {
	

}