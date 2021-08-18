package com.til.socialapp.model;

import java.time.LocalDateTime;

public class CommentResponse {
	private String commentId;
	private String postId;
	private String name;
	private int empId;
	private String comment;
	private String empImgUrl;
	private LocalDateTime createdAt;
	private String designation;

	public CommentResponse() {

	}

	public CommentResponse(String commentId, String postId, String name, int empId, String comment, String empImgUrl,
			LocalDateTime createdAt, String designation) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.name = name;
		this.empId = empId;
		this.comment = comment;
		this.empImgUrl = empImgUrl;
		this.createdAt = createdAt;
		this.designation = designation;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
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

	public String getEmpImgUrl() {
		return empImgUrl;
	}

	public void setEmpImgUrl(String empImgUrl) {
		this.empImgUrl = empImgUrl;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
