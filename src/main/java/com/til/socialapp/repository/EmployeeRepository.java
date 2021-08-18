package com.til.socialapp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.til.socialapp.model.*;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>
{

	//Employee findByempId(int empId);

	Employee findByEmpId(int empId);
}
