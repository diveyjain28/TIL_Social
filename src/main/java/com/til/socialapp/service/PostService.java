package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;


@Service
public class PostService 
{
	@Autowired
	private PostRepository post;
	@Autowired
	private EmployeeRepository emp;
	
	public Post savePostService(Post p)
	{
		post.save(p);
		Employee e=emp.findByEmpId(p.getEmpId());
		p.setName(e.getName());
		p.setDesignation(e.getDesignation());
		p.setEmpImgUrl(e.getImgUrl());
		return p;
	}
	
}
