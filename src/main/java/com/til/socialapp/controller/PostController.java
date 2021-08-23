package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Post;
import com.til.socialapp.model.PostResponse;
import com.til.socialapp.service.PostService;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postserv;
	
	@PostMapping("/save")
	public PostResponse savePost(@RequestBody Post post) {
		// Post ret=postserv.savePostService(post);
		return postserv.savePostService(post);
	}
}
