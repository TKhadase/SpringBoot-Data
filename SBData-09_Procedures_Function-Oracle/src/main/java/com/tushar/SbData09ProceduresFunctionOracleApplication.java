package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.service.iStudentService;

@SpringBootApplication
public class SbData09ProceduresFunctionOracleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SbData09ProceduresFunctionOracleApplication.class, args);
		iStudentService service = ctx.getBean("studentService",iStudentService.class);
		
		System.out.println("-----------------PROCEDURE returning multiple rows--------------------");
		service.getAllStudentsByMarks_procedure(0, 1000).forEach(System.out::println);
		System.out.println("-----------------PROCEDURE returning single value--------------------");		
		System.out.println(""+service.getStudentAuth_procedure(1, "Tushar"));
		System.out.println("-----------------PROCEDURE returning single rows--------------------");
		System.out.println(service.getStudentByID_procedure(2));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
