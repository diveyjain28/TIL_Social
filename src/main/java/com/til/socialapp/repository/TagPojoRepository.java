package com.til.socialapp.repository;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.til.socialapp.model.TagPojo;



public interface TagPojoRepository extends MongoRepository<TagPojo, ObjectId> {

}