package com.til.socialapp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.til.socialapp.model.*;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>
{

	Employee findByempId(int empId);
}
