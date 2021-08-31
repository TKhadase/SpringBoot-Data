package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.document.Employee;
import com.tushar.service.EmployeeServiceImpl;
import com.tushar.service.iEmployeeService;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SbData18MongoDbMongoTemplate {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbData18MongoDbMongoTemplate.class, args);
		iEmployeeService service = ctx.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
		
			System.out.println("----------------------------------save---------------------------------------------");
			Employee emp1 = new Employee(101, "Tushar", "Ytl", 55452.0, 7798488512L);
			System.out.println(service.saveEmployeeDetails(emp1));
		
			System.out.println("----------------------------------insert---------------------------------------------");
			Employee emp2 = new Employee(103, "ABCD", "XYZ", 532452.0, 1238488234L);
			emp2.set_id("103");
			System.out.println(service.insertEmployeeDetails(emp2));
			
			System.out.println("----------------------------------find with criteria--------------------------------");
			service.getAllEmployeeDetailsByEmpName("Tushar").forEach(System.out::println);
			
			System.out.println("----------------------------------findById-------------------------------------------");
			Employee emp3 =service.getEmployeeDetailsByEno("103");
			System.out.println("Employee Details:: "+emp3);
			
			 System.out.println("----------------------------------update--------------------------------------------");
			 emp3.setContact(1234L);
			 System.out.println( service.updateEmployeeDetails(emp3));

			System.out.println("----------------------------------findAndRemove----------------------------------");
			System.out.println(service.getAndRemoveEmployeeDetailsByEno("103"));
			
			System.out.println("----------------------------------findAndModify-----------------------------------");
			System.out.println(service.getAndUpdateEmployeeDetailsByEno("612e59b0cb21b80bba0d9bef", "salary", "123.456"));
			
			System.out.println("----------------------------------findAllAndRemove------------------------------");
			System.out.println(service.getAllAndRemoveAllEmployeeDetailsByEno("name", "ABCD"));
		
			System.out.println("----------------------------------select---------------------------------------------");
			service.getAllEmployeeDetails().forEach(System.out::println);
		
			System.out.println("----------------------------------updateMulti--------------------------------------");
			System.out.println(service.updateMultiEmployeeDetails("addrs", "Goa", "Pune"));
		
			System.out.println("----------------------------------insertAll------------------------------------------");
			System.out.println("----------------------------------upsert----------------------------------------------");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
