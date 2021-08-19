package com.til.socialapp.repository;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Post;
import com.til.socialapp.model.Tag;
import com.til.socialapp.model.Teams;

public interface TeamsRepository extends MongoRepository<Teams, ObjectId>{

}