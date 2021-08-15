package com.til.socialapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Post;
import com.til.socialapp.model.Tag;


public interface Tagrepository extends MongoRepository <Tag, Integer>{

	Tag findByEmpId(int empId);

}
