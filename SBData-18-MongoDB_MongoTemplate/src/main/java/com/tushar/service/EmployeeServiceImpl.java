package com.tushar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.tushar.document.Employee;

@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements iEmployeeService {

	@Autowired
	private MongoTemplate template;

	@Override
	public String saveEmployeeDetails(Employee emp) {
		//Employee employee = template.save(emp, "Worker");//saves with 'Worker' name
		Employee employee = template.save(emp);//saves with Document class name
		return "Employee details saved with SysId#"+employee.get_id()+", EMPID#"+employee.getEno();
	}

	@Override
	public String insertEmployeeDetails(Employee emp) {
		Employee employee = template.insert(emp);//saves with Document class name
		return "Employee details saved with SysId#"+employee.get_id()+", EMPID#"+employee.getEno();
	}
	
	@Override
	public String saveAllEmployeeDetails(List<Employee> emp) {
		return emp.size()+" No. Of Employee details"+ template.insertAll(emp);
	}

	@Override
	public String updateEmployeeDetails(Employee emp) {
		Employee employee = template.save(emp);
		return "Employee details updated with SysId#"+employee.get_id()+", EMPID#"+employee.getEno();
	}

	@Override
	public String upsertEmployeeDetails(Employee emp) {
		return "";
	}

	@Override
	public String updateMultiEmployeeDetails(String key, Object keyVal, Object newVal) {
		Query query = new Query().addCriteria(Criteria.where(key).is(keyVal));
		Update update = new Update();
		update.set(key, newVal);
		UpdateResult result = template.updateMulti(query, update, Employee.class);
		return result.getModifiedCount()+" No. of records modified";
	}

	@Override
	public String getAndUpdateEmployeeDetailsByEno(String id, String key, Object val) {
		Employee emp =	template.findById(id, Employee.class);
		if(emp!=null)
		{
			Query query = new Query().addCriteria(Criteria.where("_id").is(id));
			Update update = new Update();
			update.set(key, val);
			return "-Employee details updated:: "+template.findAndModify(query, update, Employee.class);
		}
		else
			return id+"-Employee details not found to update";
	}

	@Override
	public Employee getEmployeeDetailsByEno(String eno) {
		return  template.findById(eno, Employee.class);
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return template.findAll(Employee.class);
	}

	@Override
	public List<Employee> getAllEmployeeDetailsByEmpName(String Name) {
		Query query = new Query().addCriteria(Criteria.where("name").is(Name));
		return template.find(query, Employee.class);
	}

	@Override
	public String getAndRemoveEmployeeDetailsByEno(String id) {
		
		Employee emp =	template.findById(id, Employee.class);
		if(emp!=null)
		{
			Query query = new Query().addCriteria(Criteria.where("_id").is(id));
			template.findAndRemove(query, Employee.class);
			return id+"-Employee details removed";
		}
		else
			return id+"-Employee details not found";
	}

	@Override
	public String getAllAndRemoveAllEmployeeDetailsByEno(String key, Object val) {
		Query query = new Query().addCriteria(Criteria.where(key).is(val));
		List<Employee> list = template.findAllAndRemove(query, Employee.class);
		return list.size()+" No. of Employees removed";
	}

}
