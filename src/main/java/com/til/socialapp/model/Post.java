package com.til.socialapp.model;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Component
@Document(collection = "post")
public class Post {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId postId;
	private int empId;
	private int likesCount = 0;
	private int commentsCount = 0;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	private String content;
	private String[] tags;
	private String[] images;
	private String[] videos;

	// Constructors
	public Post() {
	}

	public Post(ObjectId postId, int empId, int likesCount, int commentsCount, LocalDateTime createdAt,
			LocalDateTime updatedAt, String content, String[] tags, String[] images, String[] videos) {
		super();
		this.postId = postId;
		this.empId = empId;
		this.likesCount = likesCount;
		this.commentsCount = commentsCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.content = content;
		this.tags = tags;
		this.images = images;
		this.videos = videos;

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

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String[] getVideos() {
		return videos;
	}

	public void setVideos(String[] videos) {
		this.videos = videos;
	}

}
