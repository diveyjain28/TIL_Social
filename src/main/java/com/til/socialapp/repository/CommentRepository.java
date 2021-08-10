package com.til.socialapp.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, ObjectId>
{

	public List<Comment> findByPostId(String postId);
	
}
