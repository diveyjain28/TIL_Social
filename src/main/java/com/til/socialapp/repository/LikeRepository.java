package com.til.socialapp.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Like;
public interface LikeRepository extends MongoRepository<Like, ObjectId>{

	

	
	public List<Like> findByEmpId(int empId);

	public Like findByPostId(String postId);

	public List<Like> findByempId(int empId);

	

}
