package com.tushar.service;

import java.util.List;

import com.tushar.entity.Student;

public interface iStudentService {

	public List<Student> getAllStudentsByMarks_procedure(double min, double max);
	public String getStudentAuth_procedure(int id, String pass);
	public Student getStudentByID_procedure(int id);
	
	public Object getStudentByID_functions(int id);
	
}
