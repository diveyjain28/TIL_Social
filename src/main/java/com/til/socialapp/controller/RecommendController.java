package com.til.socialapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Employee;
import com.til.socialapp.service.RecommendationService;

@CrossOrigin
@RestController
@RequestMapping("/recommend")
public class RecommendController {
	@Autowired
	private RecommendationService rs;
	@GetMapping("/fetch/{empId}")
	public List<Employee> fetchSimilar(@PathVariable int empId)
	{
		List<Employee> eld=rs.returnlistEmp(empId);
		return eld;
	}
}
