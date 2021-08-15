package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.socialapp.model.Employee;
import com.til.socialapp.model.Tag;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.repository.Tagrepository;


@Service
public class TagService {
	
	@Autowired
	private Tagrepository tag;
	@Autowired
	private EmployeeRepository emp;

	public Tag updateserviceTag(Tag t1)
	{
		Employee e=emp.findByEmpId(t1.getEmpId());
		
		e.setInterests(t1.getTags());
		emp.save(e);
		
		return t1;
	}
}
