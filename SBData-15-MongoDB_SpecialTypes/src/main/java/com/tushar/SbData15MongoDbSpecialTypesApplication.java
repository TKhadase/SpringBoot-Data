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
import com.tushar.service.EmpServiceImpl;
import com.tushar.service.iEmployeeService;

@SpringBootApplication
public class SbData15MongoDbSpecialTypesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SbData15MongoDbSpecialTypesApplication.class, args);
		iEmployeeService serviceEmp = ctx.getBean("empService", EmpServiceImpl.class);
		
		System.out.println("-----------------------INSERT------------------------------");
		Employee emp = new Employee(4,"XYZ", "Bhor", 65000, 7798488513L);
		emp.setHomeNumber(  Set.of(123L,456L,789L)   );// Set<Long>
		emp.setNickNames(List.of("ABC", "PQR", "XYZ"));// List<String>
		emp.setFamily(Map.of("Mother", "ABCD", "Father","EFGH", "Sister","IJKJL", "brother","MNOP" ));//Map<String, String>
		Properties props = new Properties();
		props.put("c", "Good");
		props.put("ML", "Good");
		props.put("Python", "Better");
		props.put("DATA science", "Good");
		props.put("AI", "Good");
		emp.setTechProps(props);//Properties
		emp.setHobby(  new String[] { "Cooking", "Drawing", "Gardening" });//String [] 
		System.out.println(serviceEmp.registerEmployee(emp));
		
		System.out.println("-----------------------SELECT ALL------------------------------");
		serviceEmp.showAllEmployees().forEach(System.out::println);
		
		System.out.println("-----------------------UPDATE------------------------------");
		Employee empUpdate = new Employee(4,"XYZ", "Pune", 62000, 7798488514L);
		empUpdate.set_id("611b3c4c2ca1885db2bd404a");
		System.out.println(serviceEmp.updateEmployeeDetails(empUpdate));
		
		System.out.println("-----------------------SELECT by ID------------------------------");
		Optional<Employee> optEmp =serviceEmp.showEmployeesBySysNo("6119e0b843cbd1426d963158");
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
