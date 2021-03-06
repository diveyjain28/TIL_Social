package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Like;
import com.til.socialapp.model.PostResponse;
import com.til.socialapp.service.LikeService;

@CrossOrigin
@RestController
@RequestMapping("/like")
public class LikeController {
	@Autowired
	private LikeService likeserv;
	@PostMapping("/save")
	public PostResponse likePost(@RequestBody Like like) {
		return likeserv.likePostService(like);
	}
}
