package com.tushar.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tushar.document.Employee;

public interface EmpRepo extends MongoRepository<Employee, String> {

}
