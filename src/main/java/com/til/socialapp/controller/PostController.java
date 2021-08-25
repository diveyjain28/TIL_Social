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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/post")
@Api(value = "Post API",description="All APIs related to post")
public class PostController {
	@Autowired
	private PostService postserv;
	
	@PostMapping("/save")
	@ApiOperation(value="It saves the post")
	public PostResponse savePost(@RequestBody Post post) {
		// Post ret=postserv.savePostService(post);
		return postserv.savePostService(post);
	}
}
