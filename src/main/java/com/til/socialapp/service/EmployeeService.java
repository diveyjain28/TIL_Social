package com.til.socialapp.service;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.til.socialapp.model.Employee;
import com.til.socialapp.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	
	@Autowired
	private EmployeeRepository emp;

	public Employee registerService(Employee e) {
		if(emp.findByempId(e.getEmpId())!=null)
		{
			emp.delete(emp.findByempId(e.getEmpId()));
		}
		emp.save(e);
		return e;
	}

	public Employee fetchServiceEmployeeById(int empId) {

		Employee ret = emp.findByempId(empId);

		return ret;
	}

}
