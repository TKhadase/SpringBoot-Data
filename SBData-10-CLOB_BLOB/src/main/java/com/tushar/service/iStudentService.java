package com.tushar.service;

import java.util.Optional;

import com.tushar.Entity.StudentDetails;

public interface iStudentService {

	public int registerStudent(StudentDetails s);
	public Optional<StudentDetails> getStudentById(int id);
	
}
