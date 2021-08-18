package com.til.socialapp.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection = "comment")
public class Comment {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId commentId;
	@Indexed
	private String postId;
	// private String name;
	private int empId;
	private String comment;
	// private String empImgUrl;
	private LocalDateTime createdAt = LocalDateTime.now();

	public Comment() {
		super();
	}

	public Comment(ObjectId commentId, String postId, int empId, String comment, LocalDateTime createdAt) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.empId = empId;
		this.comment = comment;
		this.createdAt = createdAt;
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
