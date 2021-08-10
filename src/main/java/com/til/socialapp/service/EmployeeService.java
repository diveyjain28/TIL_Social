package com.til.socialapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.til.socialapp.model.Employee;
import com.til.socialapp.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	
	@Autowired
	private EmployeeRepository emp;

	public void registerService(Employee e) {
		emp.save(e);
	}

	public Employee fetchServiceEmployeeById(int empId) {

		Employee ret = emp.findByempId(empId);

		return ret;
	}

}
