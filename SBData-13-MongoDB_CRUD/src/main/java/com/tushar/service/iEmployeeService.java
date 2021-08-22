package com.tushar.service;

import java.util.List;
import java.util.Optional;

import com.tushar.document.Employee;

public interface iEmployeeService {

	public String registerEmployee(Employee emp);
	
	public List<Employee> showAllEmployees();
	public Optional<Employee> showEmployeesBySysNo( String string) ;
	
	public String updateEmployeeDetails(Employee emp);
	
	public String removeEmployeeDetailsBySysNo(String _id);
}
