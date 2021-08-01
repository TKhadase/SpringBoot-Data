package com.tushar.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.entity.Student;

@Service("studentService")
public class StudentServiceImpl implements iStudentService {
	
	@Autowired
	private EntityManager studentEnttyMgr;
	
	@Override
	public List<Student> getAllStudentsByMarks_procedure(double min, double max) {
		StoredProcedureQuery query = studentEnttyMgr.createStoredProcedureQuery("PRC_GET_STUDENT_BY_MARKS", Student.class);
		query.registerStoredProcedureParameter(1, double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Student.class, ParameterMode.REF_CURSOR);
		
		query.setParameter(1, min);
		query.setParameter(2, max);
		
		List<Student> students = query.getResultList();
		
		return students;
	}

	@Override
	public String getStudentAuth_procedure(int id, String pass) {
		StoredProcedureQuery query = studentEnttyMgr.createStoredProcedureQuery("PRC_IS_USER_VALID");
		query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		
		query.setParameter(1, id);
		query.setParameter(2, pass);
		
		String  isValid = (String) query.getOutputParameterValue(3);
		return isValid;
	}

	@Override
	public Student getStudentByID_procedure(int id) {
		StoredProcedureQuery query = studentEnttyMgr.createStoredProcedureQuery("PRC_GET_STUDENT_BY_ROLL",Student.class);
		query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Student.class, ParameterMode.REF_CURSOR);
		
		query.setParameter(1, id);
		
		Student s = (Student) query.getSingleResult();
		return s;
	}

	@Override
	public Object getStudentByID_functions(int id) {
		return null;
	}

}
