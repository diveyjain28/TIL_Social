package com.til.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.til.socialapp.exception.UserNotFoundException;
import com.til.socialapp.model.Employee;
import com.til.socialapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emp;

	public Employee registerService(Employee e) {
		emp.save(e);
		return e;
	}

	public Employee fetchServiceEmployeeById(int empId) {

		Employee ret = null;
		ret = emp.findByEmpId(empId);
		if (null == ret) {
			throw new UserNotFoundException("Employee ID " + empId + " doesn't exist");
		}
		return ret;
	}

}
