package com.til.socialapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.til.socialapp.model.Common;

@Repository
public interface CommonRepository extends MongoRepository<Common, Integer> {

}