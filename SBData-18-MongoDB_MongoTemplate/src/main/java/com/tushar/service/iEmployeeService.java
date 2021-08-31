package com.tushar.service;

import java.util.List;

import com.tushar.document.Employee;

public interface iEmployeeService {
	
	public String saveEmployeeDetails(Employee emp);
	public String insertEmployeeDetails(Employee emp);
	public String saveAllEmployeeDetails(List<Employee> emp);
	public String updateEmployeeDetails(Employee emp);
	public String upsertEmployeeDetails(Employee emp);
	public String updateMultiEmployeeDetails(String key, Object keyVal, Object newVal);
	public String  getAndUpdateEmployeeDetailsByEno(String id, String key, Object val);
	
	public Employee getEmployeeDetailsByEno(String eno);
	public List<Employee> getAllEmployeeDetails();
	public List<Employee> getAllEmployeeDetailsByEmpName(String Name);
	
	public String  getAndRemoveEmployeeDetailsByEno(String id);
	public String  getAllAndRemoveAllEmployeeDetailsByEno(String key, Object val);
	
}
