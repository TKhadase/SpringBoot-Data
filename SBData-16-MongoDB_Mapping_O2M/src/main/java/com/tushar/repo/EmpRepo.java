package com.tushar.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tushar.document.Employee;

public interface EmpRepo extends MongoRepository<Employee, String> {

	
	
}
