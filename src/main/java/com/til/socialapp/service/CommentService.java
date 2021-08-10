package com.til.socialapp.service;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.til.socialapp.model.Comment;
import com.til.socialapp.repository.CommentRepository;
@Service
public class CommentService {
	@Autowired
	CommentRepository cr;

	public void registerServiceComment(Comment comment) {

		cr.save(comment);

	}

	public List<Comment> fetchServiceComment(String postId) {
		List<Comment> ret = cr.findByPostId(postId);
		return ret;
	}
}
