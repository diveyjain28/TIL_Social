package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.FeedResponse;
import com.til.socialapp.service.FeedService;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class FeedController {
	
	@Autowired
	private FeedService feedserv;
	@GetMapping("/fetch")
	@ResponseBody

	public FeedResponse feedPost(@RequestParam("page") int page, @RequestParam("sortBy") String sorted,
			@RequestParam("empId") int empid, @RequestParam("type") String type,
			@RequestParam(name="tag", required=false) String tag) {

		return feedserv.getFeed(sorted, empid, type, page, tag);
	}
}
