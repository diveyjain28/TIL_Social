package com.til.socialapp.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection = "comment")
public class Comment {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId commentId;
	private String postId;
	private String name;
	private int empId;
	private String comment;
	private LocalDateTime createdAt;

	
	
	public Comment(ObjectId commentId, String postId, String name, int empId, String comment, LocalDateTime createdAt) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.name = name;
		this.empId = empId;
		this.comment = comment;
		this.createdAt = java.time.LocalDateTime.now();

	}

	public ObjectId getCommentId() {
		return commentId;
	}

	public void setCommentId(ObjectId commentId) {
		this.commentId = commentId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
