package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.document.Employee;
import com.tushar.service.EmpServiceImpl;
import com.tushar.service.iEmployeeService;

@SpringBootApplication
public class SbData17MongoDbQueryMethods {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SbData17MongoDbQueryMethods.class, args);
		iEmployeeService serviceEmp = ctx.getBean("empService", EmpServiceImpl.class);
		
		System.out.println("----------------------findByEnoEquals------------------------------");
		Employee e = serviceEmp.getEmployeeByEnoEquals(1);
		if(e==null)
		{
			System.out.println("Employee not found");
		}else {
			System.out.println(e);
		}
		
		System.out.println("----------------------findBySalaryBetween-----------------------------");
		serviceEmp.getEmployeeBySalaryBetween(1000,50001).forEach(System.out::println);

		System.out.println("----------------------findBySalaryLessThanEqual-----------------------------");
		serviceEmp.getEmployeeBySalaryLessThanEqual(50000).forEach(System.out::println);
		
		System.out.println("----------------------findBySalaryGreaterThanEqual-----------------------------");
		serviceEmp.getEmployeeBySalaryGreaterThanEqual(50000).forEach(System.out::println);
		
		System.out.println("----------------------findByAddrsIn-----------------------------");
		serviceEmp.getEmployeeByAddrsIn(new String[] {"Pune", "Goa"}).forEach(System.out::println);
		
		System.out.println("----------------------findByNameEquals-----------------------------");
		serviceEmp.getEmployeeByNameEquals("Tushar").forEach(System.out::println);
		
		System.out.println("----------------------getBySalaryGreaterThanEqualsAndSalaryLessThanEquals-----------------------------");
		serviceEmp.getBySalaryGreaterThanEqualsAndSalaryLessThanEquals(10000,500001).forEach(System.out::println);
		
		System.out.println("----------------------findByNameStartingWith-----------------------------");
		serviceEmp.getEmployeeByNameRegExpression("^T").forEach(System.out::println);
	
		System.out.println("----------------------findByNameEndSWith-----------------------------");
		serviceEmp.getEmployeeByNameRegExpression("a$").forEach(System.out::println);
		
		System.out.println("----------------------findByNameContains-----------------------------");
		serviceEmp.getEmployeeByNameRegExpression("a").forEach(System.out::println);
		
		System.out.println("----------------------count(*)-----------------------------\nCount::"+serviceEmp.getEmpCountBySalaryBetween(1000,50001));
		
		System.out.println("----------------------Delete-----------------------------\nNO.Of Records Deleted::"+serviceEmp.deleteEmployeeByEnoEquals(4));
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
