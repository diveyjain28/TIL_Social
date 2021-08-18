package com.til.socialapp.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.til.socialapp.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {

	public List<Comment> findByPostId(String postId);

}
