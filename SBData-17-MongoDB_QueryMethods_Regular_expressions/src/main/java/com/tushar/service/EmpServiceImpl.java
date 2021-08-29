package com.tushar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.document.Employee;
import com.tushar.repo.EmpRepo;

@Service("empService")
public class EmpServiceImpl implements iEmployeeService {
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee getEmployeeByEnoEquals(int eno) {
		return empRepo.queryByEnoEquals(eno);
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(double min, double max) {
		return empRepo.queryBySalaryBetween(min, max);
	}
	
	@Override
	public List<Employee> getEmployeeBySalaryLessThanEqual(double sal) {
		return  empRepo.queryBySalaryLessThanEqual(sal);
	}

	@Override
	public List<Employee> getEmployeeBySalaryGreaterThanEqual(double sal) {
		return  empRepo.queryBySalaryGreaterThanEqual(sal);
	}

	@Override
	public List<Employee> getEmployeeByAddrsIn(String... strings) {
		return  empRepo.queryByAddrsIn(strings);
	}
	
	@Override
	public List<Employee> getEmployeeByNameEquals(String name) {
		return  empRepo.queryByNameEquals(name);
	}
	
	@Override
	public List<Employee> getBySalaryGreaterThanEqualsAndSalaryLessThanEquals(double min, double max) {
		return  empRepo.queryBySalaryGreaterThanEqualsAndSalaryLessThanEquals(min, max);
	}
	/*
	@Override
	public String newEmp(Employee emp) {
		return  "New Employee registered with ID#"+empRepo.queryInsertEmp(emp).getEno();
	}

	@Override
	public String updateEmp(Employee emp) {
		return   "Employee details updated for EMP ID#"+empRepo.queryUpdateEmp(emp).getEno();
	}

	@Override
	public String deleteEmp(Employee emp) {
		return  "Employee details removed having ID#"+emp.getEno()+". Records Updated:"+empRepo.queryDeleteEmp(emp);
	}
*/

	@Override
	public List<Employee> getEmployeeByNameRegExpression(String name) {
		return  empRepo.queryByNameRegExpression(name);
	}

	@Override
	public int  getEmpCountBySalaryBetween(double min, double max) {
		return  empRepo.queryCountBySalaryBetween(min, max);
	}

	@Override
	public int deleteEmployeeByEnoEquals(int eno) {
		return  empRepo.queryDeleteByEnoEquals(eno);
	}
}
