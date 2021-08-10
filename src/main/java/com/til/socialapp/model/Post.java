package com.til.socialapp.model;


import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post {
	// empImgUrl,images,videos not used
	@Id
	private ObjectId postId;
	private int empId;
	private String name;
	private int likesCount;
	private int commentsCount;
	private boolean hasLiked;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String content;
	private String[] tags;

	// Constructor
	public Post(ObjectId postId,int empId, String name, int likesCount, int commentsCount, boolean hasLiked, LocalDateTime createdAt,
			LocalDateTime updatedAt, String content, String[] tags) {
		
		super();
		this.postId=postId;
		this.empId = empId;
		this.name = name;
		this.likesCount = likesCount;
		this.commentsCount = commentsCount;
		this.hasLiked = hasLiked;
		this.createdAt =  java.time.LocalDateTime.now();
		this.updatedAt = java.time.LocalDateTime.now();
		this.content = content;
		this.tags = tags;
	}

	// Getters and Setters
	public ObjectId getPostId() {
		return postId;
	}

	public void setPostId(ObjectId postId) {
		this.postId = postId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public boolean isHasLiked() {
		return hasLiked;
	}

	public void setHasLiked(boolean hasLiked) {
		this.hasLiked = hasLiked;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
