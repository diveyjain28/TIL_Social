package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;

@Service
public class FeedService {
	@Autowired
	private PostRepository post;
	@Autowired
	private EmployeeRepository emp;
	public Page<Post> getFeed(String sorted, int empId, String type, int page) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<Post> feed = null;
		Employee e=emp.findByempId(empId);
		if (type.equals("feed")) {
			if (sorted.equals("recency")) {
				feed = post.findByEmpIdNotAndTagsInOrderByCreatedAtDesc(empId,e.getInterests(), pageable);
			} else {
				feed = post.findByEmpIdNotAndTagsInOrderByLikesCountDesc(empId,e.getInterests(), pageable);
			}
		} else if (type.equals("self")) {
			if (sorted.equals("recency")) {
				feed = post.findByEmpIdAndTagsInOrderByCreatedAtDesc( empId,e.getInterests(), pageable);
			} else {
				feed = post.findByEmpIdAndTagsInOrderByLikesCountDesc(empId,e.getInterests(), pageable);
			}
		}
		return feed;
	}
}