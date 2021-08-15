package com.til.socialapp.service;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Comment;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.CommentRepository;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository cr;
	@Autowired
	private PostRepository pr;
	@Autowired
    private EmployeeRepository emp;
	
	public Comment registerServiceComment(Comment comment) {

		Post p = pr.findByPostId(comment.getPostId());
		Employee e=emp.findByEmpId(comment.getEmpId());
		comment.setName(e.getName());
		comment.setEmpImgUrl(e.getImgUrl());
		cr.save(comment);
		p.setCommentsCount(p.getCommentsCount() + 1);
		pr.save(p);
		return comment;
	}

	public List<Comment> fetchServiceComment(String postId) {
		List<Comment> ret = cr.findByPostId(postId);
		return ret;
	}
}
