package com.til.socialapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.til.socialapp.repository.EmployeeRepository;
import com.til.socialapp.model.Employee;

@Service
public class RecommendationService 
{
	@Autowired
	private EmployeeRepository emp;
	public int count_pairs(String s1[], String s2[], int n1, int n2)
	{
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		// Update the frequencies
		for (int i = 0; i < n1; i++)
			mp.put(s1[i], 0);
		// Update the frequencies
		for (int i = 0; i < n1; i++)
			mp.put(s1[i], mp.get(s1[i]).intValue() + 1);
		// To store the count of pairs
		int cnt = 0;
		// For every string of array s2[]
		for (int i = 0; i < n2; i++)
		{
			if (mp.get(s2[i]) !=null) 
			{
				// Increment the count of pairs
				cnt++;

				// Decrement the frequency of the
				// string as once occurrence has been
				// used in the current pair
				mp.put(s2[i], mp.get(s2[i]).intValue() - 1);
			}
		}
		return cnt;
	}
	public List<Employee> returnlistEmp(int empId)
	{
		List<Employee> el = emp.findAll();
		List<Employee> emplist=new ArrayList<>();
		int n = el.size();
		Employee e = emp.findByEmpId(empId);
		for (int i = 0; i < n; i++)
		{
			Employee tempEmp = el.get(i);
			if (tempEmp.getEmpId() != empId)
			{
				String[] tempInterests = tempEmp.getInterests();
				String[] origEmpInterests = e.getInterests();
				int n1 = tempInterests.length;
				int n2 = origEmpInterests.length;
				int c = count_pairs(tempInterests, origEmpInterests, n1, n2);
				if (c >= 2)
				{
					emplist.add(tempEmp);
				}
			}
		}
		return emplist;
	}
}