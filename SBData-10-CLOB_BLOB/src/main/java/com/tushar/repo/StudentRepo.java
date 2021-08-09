package com.tushar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Entity.StudentDetails;

public interface StudentRepo extends JpaRepository<StudentDetails, Integer> {

}
