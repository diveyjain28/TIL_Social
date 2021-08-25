package com.til.socialapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Employee;
import com.til.socialapp.service.RecommendService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/recommend")
@Api(value = "Recommend API",description="All APIs related to recommendation")
public class RecommendController {
	@Autowired
	private RecommendService rs;
	@GetMapping("/fetch/{empId}")
	@ApiOperation(value="It fetches recommended colleague of the user")
	public List<Employee> fetchSimilar(@PathVariable int empId)
	{
		List<Employee> eld=rs.recommendService(empId);
		return eld;
	}
}
