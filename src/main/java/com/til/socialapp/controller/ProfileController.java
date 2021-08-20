package com.til.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Tag;
import com.til.socialapp.service.EmployeeService;
import com.til.socialapp.service.TagService;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private EmployeeService empserv;
	@Autowired
	private TagService tagsserv;
	@PostMapping("/save")
	public Employee register(@RequestBody Employee emp) {
		Employee ret = empserv.registerService(emp);
		return ret;
	}

	@GetMapping("/fetch/{empId}")
	public Employee fetchEmployeeById(@PathVariable("empId") int empId) {
		Employee ret = empserv.fetchServiceEmployeeById(empId);
		return ret;
	}
	
	@PostMapping("/tag/save")
	public Tag updateTag(@RequestBody Tag t1) {
		Tag ret = tagsserv.updateserviceTag(t1);
		return ret;
	}
}
