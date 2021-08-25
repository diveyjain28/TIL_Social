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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/comment")
@Api(value = "Comment API",description="All APIs related to comment")
public class CommentController {
	@Autowired
	private CommentService comserv;
	@PostMapping("/save")
	@ApiOperation(value="It saves comment")
	public CommentResponse registerComment(@RequestBody Comment comment) {
		
		return comserv.registerServiceComment(comment);
	}

	@GetMapping("/fetch/{postId}")
	@ApiOperation(value="It fetches all the comments on a given postId")
	public List<CommentResponse> fetchComment(@PathVariable("postId") String postId) {
		
		return comserv.fetchServiceComment(postId);
	}
}
