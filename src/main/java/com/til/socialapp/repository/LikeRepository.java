package com.til.socialapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Like;
public interface LikeRepository extends MongoRepository<Like, ObjectId>{

}
