package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.service.EmpServiceImpl;
import com.tushar.service.iEmployeeService;

@SpringBootApplication
public class SbData17MongoDbQueryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SbData17MongoDbQueryMethodsApplication.class, args);
		iEmployeeService serviceEmp = ctx.getBean("empService", EmpServiceImpl.class);
		
		System.out.println("----------------------findByEnoEquals-----------------------------");
		System.out.println(serviceEmp.getEmployeeByEnoEquals(1));
		System.out.println("----------------------findBySalaryBetween-----------------------------");
		serviceEmp.getEmployeeBySalaryBetween(1000,50001).forEach(System.out::println);
		System.out.println("----------------------findBySalaryLessThanEqual-----------------------------");
		serviceEmp.getEmployeeBySalaryLessThanEqual(50000).forEach(System.out::println);
		System.out.println("----------------------findBySalaryGreaterThanEqual-----------------------------");
		serviceEmp.getEmployeeBySalaryGreaterThanEqual(50000).forEach(System.out::println);
		System.out.println("----------------------findByAddrsIn-----------------------------");
		serviceEmp.getEmployeeByAddrsIn(new String[] {"Pune", "GOA"}).forEach(System.out::println);
		System.out.println("----------------------findByNameEquals-----------------------------");
		serviceEmp.getEmployeeByNameEquals("Tushar").forEach(System.out::println);
		
		
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}

