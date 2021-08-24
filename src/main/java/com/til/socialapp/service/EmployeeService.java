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
	@Autowired
	private ValidationService vs;
	
	public Employee registerService(Employee e) {
		vs.checkEmpId(e.getEmpId());
		emp.save(e);
		return e;
	}

	public Employee fetchServiceEmployeeById(int empId) {

		Employee ret = null;
		ret = emp.findByEmpId(empId);
		vs.checkEmpIdExists(empId);
		return ret;
	}

}
