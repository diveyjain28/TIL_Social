package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

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
		if (type.equals("feed")) {
			if (sorted.equals("recency")) {
				feed = post.findByEmpIdNotOrderByCreatedAtDesc(empId, pageable);
			} else {
				feed = post.findByEmpIdNotOrderByLikesCountDesc(empId, pageable);
			}
		} else if (type.equals("self")) {
			if (sorted.equals("recency")) {
				feed = post.findByEmpIdOrderByCreatedAtDesc(empId, pageable);
			} else {
				feed = post.findByEmpIdOrderByLikesCountDesc(empId, pageable);
			}
		}
		for(int i=0;i<feed.getNumberOfElements();i++)
		{
			Post p=feed.getContent().get(i);
			p.setDesignation(emp.findByempId(p.getEmpId()).getDesignation());
			p.setName(emp.findByempId(p.getEmpId()).getName());
			p.setEmpImgUrl(emp.findByempId(p.getEmpId()).getImgUrl());
		}
		return feed;
	}
}