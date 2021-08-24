package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.adaptor.PostAdaptor;
import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository pr;
	@Autowired
	private EmployeeRepository emp;
	 @Autowired
	    private ValidationService vs;

	public PostResponse savePostService(Post post) {
		vs.checkPostData(post.getContent(), post.getImages(), post.getVideos());
		vs.checkEmpIdExists(post.getEmpId());
		
		Employee employee = emp.findByEmpId(post.getEmpId());
		pr.save(post);
		PostAdaptor postadaptor = new PostAdaptor();
		PostResponse ret = postadaptor.convert(post, employee);
		return ret;
	}

}