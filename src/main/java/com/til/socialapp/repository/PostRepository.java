package com.til.socialapp.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.til.socialapp.model.Post;

public interface PostRepository extends MongoRepository<Post, ObjectId>{
	

	public Page<Post> findByEmpIdNotAndTagsInOrderByLikesCountDesc(int empId,String[] tags,Pageable pageable);
	public Page<Post> findByEmpIdAndTagsInOrderByLikesCountDesc(int empId,String[] tags,Pageable pageable);
	public Page<Post> findByEmpIdNotAndTagsInOrderByCreatedAtDesc(int empId,String[] tags,Pageable pageable);
	public Page<Post> findByEmpIdAndTagsInOrderByCreatedAtDesc(int empId,String[] tags,Pageable pageable);
	

	public Post findByPostId(String postId);
	public Page<Post> findByEmpIdOrderByCreatedAtDesc(int empId, Pageable pageable);
	public Page<Post> findByTagsInOrderByCreatedAtDesc(String[] interests, Pageable pageable);
	public Page<Post> findByTagsInOrderByLikesCountDesc(String[] interests, Pageable pageable);
	public Page<Post> findByEmpIdOrderByLikesCountDesc(int empId, Pageable pageable);
}