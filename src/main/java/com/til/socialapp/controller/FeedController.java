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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/post")
@Api(value = "Feed API",description="All APIs related to feed")
public class FeedController {
	
	@Autowired
	private FeedService feedserv;
	@GetMapping("/fetch")
	@ResponseBody
	@ApiOperation(value="It fetches feed based on recency and trending")
	public FeedResponse feedPost(@RequestParam("page") int page, @RequestParam("sortBy") String sorted,
			@RequestParam("empId") int empid, @RequestParam("type") String type,
			@RequestParam(name="tag", required=false) String tag) {

		return feedserv.getFeed(sorted, empid, type, page, tag);
	}
}
