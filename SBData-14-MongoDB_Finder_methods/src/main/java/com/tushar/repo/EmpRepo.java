package com.tushar.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tushar.document.Employee;

public interface EmpRepo extends MongoRepository<Employee, String> {

	public Employee findByEnoEquals(int eno);
	public List<Employee> findBySalaryBetween(double min, double max);
	public List<Employee> findBySalaryLessThanEqual(double sal);
	public List<Employee> findBySalaryGreaterThanEqual(double sal);
	public List<Employee> findByAddrsIn(String...strings);
	public List<Employee> findByNameEquals(String name);
	
}
