package com.til.socialapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.til.socialapp.model.Post;
import com.til.socialapp.model.Tag;

@Repository
public interface Tagrepository extends MongoRepository <Tag, Integer>{

	Tag findByEmpId(int empId);

}
