package com.tushar;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.document.Employee;
import com.tushar.service.EmpServiceImpl;
import com.tushar.service.iEmployeeService;

@SpringBootApplication
public class SbData13MongoDbCrudApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SbData13MongoDbCrudApplication.class, args);
		iEmployeeService serviceEmp = ctx.getBean("empService", EmpServiceImpl.class);
		
		System.out.println("-----------------------INSERT------------------------------");
		Employee emp = new Employee(2,"abcd", "Pune", 50000, 7798488513L);
		System.out.println(serviceEmp.registerEmployee(emp));
		
		System.out.println("-----------------------SELECT ALL------------------------------");
		serviceEmp.showAllEmployees().forEach(System.out::println);
		
		System.out.println("-----------------------UPDATE------------------------------");
		Employee empUpdate = new Employee(3,"abcd", "Pune", 60000, 7798488514L);
		empUpdate.set_id("6119e162589e854f687f827d");
		System.out.println(serviceEmp.updateEmployeeDetails(empUpdate));
		
		System.out.println("-----------------------SELECT by ID------------------------------");
		Optional<Employee> optEmp =serviceEmp.showEmployeesBySysNo("6119e162589e854f687f827d");
		if(optEmp.isPresent())
		{
			System.out.println("Employee:: "+optEmp.get());
		}else{
			System.out.println("Employee:: details not found");
		}
		System.out.println("-----------------------DELETE------------------------------");
		System.out.println(serviceEmp.removeEmployeeDetailsBySysNo("6119eb18dddd8c55175aaf8d"));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
