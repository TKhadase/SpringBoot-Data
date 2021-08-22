package com.tushar;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.document.Employee;
import com.tushar.document.Project;
import com.tushar.service.EmpServiceImpl;
import com.tushar.service.iEmployeeService;

@SpringBootApplication
public class SbData16MongoDbMappingO2MApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SbData16MongoDbMappingO2MApplication.class, args);
		iEmployeeService serviceEmp = ctx.getBean("empService", EmpServiceImpl.class);
		
		System.out.println("-----------------------INSERT------------------------------");
		/*	Employee emp = new Employee(5,"Edge", "PUNE", 65000, 7798488513L);
			emp.setHomeNumber(  Set.of(123L,456L,789L)   );// Set<Long>
			emp.setNickNames(List.of("ABC", "PQR", "XYZ"));// List<String>
			emp.setFamily(Map.of("Mother", "ABCD", "Father","EFGH", "Sister","IJKL", "brother","MNOP" ));//Map<String, String>
			Properties props = new Properties();
			props.put("c", "Good");
			props.put("ML", "Good");
			props.put("Python", "Better");
			props.put("DATA science", "Good");
			props.put("AI", "Good");
			emp.setTechProps(props);//Properties
			emp.setHobby(  new String[] { "Cooking", "Drawing", "Gardening" });//String [] 
			emp.setProject(  new Project( 11, "marcis", "scb", 98.4, "Manager", "Banking") );//MApping
			System.out.println(serviceEmp.registerEmployee(emp));*/
		
		System.out.println("-----------------------SELECT ALL------------------------------");
		serviceEmp.showAllEmployees().forEach(System.out::println);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
