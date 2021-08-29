package com.tushar.service;

import java.util.List;
import com.tushar.document.Employee;

public interface iEmployeeService {
	
	public Employee getEmployeeByEnoEquals(int eno);
	public List<Employee> getEmployeeBySalaryBetween(double min, double max);
	public List<Employee> getEmployeeBySalaryLessThanEqual(double sal);
	public List<Employee> getEmployeeBySalaryGreaterThanEqual(double sal);
	public List<Employee> getEmployeeByAddrsIn(String...strings);
	public List<Employee> getEmployeeByNameEquals(String name);
	public List<Employee> getBySalaryGreaterThanEqualsAndSalaryLessThanEquals(double min, double max);
	public List<Employee> getEmployeeByNameRegExpression(String name);
	public int  getEmpCountBySalaryBetween(double min, double max);
	
	public int  deleteEmployeeByEnoEquals(int eno);
	
	/*public String newEmp(Employee emp);
	public String updateEmp(Employee emp);
	public String deleteEmp(Employee emp);
	*/
	
}
