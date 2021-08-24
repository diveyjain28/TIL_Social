package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;
import com.til.socialapp.model.Employee;
import com.til.socialapp.repository.EmployeeRepository;

@Service
public class RecommendService {

	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	EmployeeRepository emp;

	public List<Employee> recommendService(int empId)
	{
		String arr[]=emp.findByEmpId(empId).getInterests();
		String temp="[";
		for(int i=0;i<arr.length;i++)
		{
			temp+="\"";
			temp+=arr[i];
			temp+="\"";
			if(i<arr.length-1)
				temp+=",";
		}
		temp+="]";
		AggregationOperation unwind = Aggregation.unwind("empId");

		String query1 = "{ \"$redact\": { \r\n" + "            \"$cond\": [ \r\n" + "                { \"$gte\": [ \r\n"
				+ "                    { \"$size\": { \"$setIntersection\": [ \"$interests\", "+temp +" ] } }, \r\n"
				+ "                    2\r\n" + "                ]},\r\n" + "                \"$$KEEP\", \r\n"
				+ "                \"$$PRUNE\" \r\n" + "            ]\r\n" + "        }}";
		TypedAggregation<Employee> aggregation = Aggregation.newAggregation(Employee.class, unwind,
				new CustomAggregationOperation(query1));

		AggregationResults<Employee> results = mongoTemplate.aggregate(aggregation, Employee.class);
		List<Employee> list=new ArrayList<>();
		for(int i=0;i<results.getMappedResults().size();i++)
		{
			if(results.getMappedResults().get(i).getEmpId()!=empId)
				list.add(results.getMappedResults().get(i));
		}
		return list;
	}
}
