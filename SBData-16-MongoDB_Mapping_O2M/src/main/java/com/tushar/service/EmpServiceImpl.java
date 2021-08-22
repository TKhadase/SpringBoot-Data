package com.tushar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.document.Employee;
import com.tushar.repo.EmpRepo;
import com.tushar.repo.ProjectRepo;

@Service("empService")
public class EmpServiceImpl implements iEmployeeService {
	
	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private ProjectRepo projectRepo;

	@Override
	public String registerEmployee(Employee emp) {
		return "employee:"+emp.getEno()+", details saved with SystemId#"+empRepo.insert(emp);
	}

	@Override
	public List<Employee> showAllEmployees() {
		return  empRepo.findAll();
	}

	@Override
	public Optional<Employee> showEmployeesBySysNo(String _id) {
		return empRepo.findById(_id);
	}

	@Override
	public String updateEmployeeDetails(Employee emp) {
		return  "employee:"+emp.getEno()+", details updated:: "+ empRepo.save(emp);
	}


	@Override
	public String removeEmployeeDetailsBySysNo(String _id) {
		String msg= "";
		Optional<Employee> optEmp = empRepo.findById(_id);
		if(optEmp.isPresent()) {
		empRepo.deleteById(_id);
		msg= "Employee::"+optEmp.get().getEno()+", details deleted";
		}else {
			msg= "Employee  details not found";
		}
		return msg;
	}

}
