package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.til.socialapp.model.Post;
import com.til.socialapp.repository.PostRepository;


@Service
public class PostService 
{
	@Autowired
	private PostRepository post;
	
	public void savePostService(Post p)
	{
		post.save(p);
	}
}
