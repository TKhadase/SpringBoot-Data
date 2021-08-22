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
		return empRepo.findByEnoEquals(eno);
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween(double min, double max) {
		return empRepo.findBySalaryBetween(min, max);
	}

	@Override
	public List<Employee> getEmployeeBySalaryLessThanEqual(double sal) {
		return  empRepo.findBySalaryLessThanEqual(sal);
	}

	@Override
	public List<Employee> getEmployeeBySalaryGreaterThanEqual(double sal) {
		return  empRepo.findBySalaryGreaterThanEqual(sal);
	}

	@Override
	public List<Employee> getEmployeeByAddrsIn(String... strings) {
		return  empRepo.findByAddrsIn(strings);
	}

	@Override
	public List<Employee> getEmployeeByNameEquals(String name) {
		return  empRepo.findByNameEquals(name);
	}




}
