package com.tushar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.Entity.StudentDetails;
import com.tushar.repo.StudentRepo;

@Service("studentService")
public class StudentServiceImpl implements iStudentService {

	@Autowired	
	private StudentRepo studentRepo;
	
	@Override
	public int registerStudent(StudentDetails s) {
		return studentRepo.save(s).getSID();
	}

	@Override
	public Optional<StudentDetails>  getStudentById(int id) {
		return studentRepo.findById(id);
	}

}
