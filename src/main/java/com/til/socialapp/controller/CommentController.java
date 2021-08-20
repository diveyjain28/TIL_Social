package com.til.socialapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Comment;
import com.til.socialapp.model.CommentResponse;
import com.til.socialapp.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService comserv;
	@PostMapping("/save")
	public CommentResponse registerComment(@RequestBody Comment comment) {
		
		return comserv.registerServiceComment(comment);
	}

	@GetMapping("/fetch/{postId}")
	public List<CommentResponse> fetchComment(@PathVariable("postId") String postId) {
		
		return comserv.fetchServiceComment(postId);
	}
}
