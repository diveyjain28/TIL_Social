package com.til.socialapp.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.til.socialapp.model.Post;

public interface PostRepository extends MongoRepository<Post, ObjectId>{
	
	public Page<Post> findByEmpIdOrderByLikesCountDesc(int empId,Pageable pageable);
	public Page<Post> findByEmpIdNotOrderByLikesCountDesc(int empId,Pageable pageable);
	public Page<Post> findByEmpIdNotOrderByCreatedAtDesc(int empId,Pageable pageable);
	public Page<Post> findByEmpIdOrderByCreatedAtDesc(int empId,Pageable pageable);
	public Post[] findByEmpIdNotOrderByCreatedAtDesc(int empId);
	public Post findBypostId(ObjectId objectId);
	public Post findByPostId(String postId);
	
}
