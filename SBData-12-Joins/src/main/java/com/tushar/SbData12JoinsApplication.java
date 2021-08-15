package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.service.PersonMgmtServiceImpl;
import com.tushar.service.iPersonMgmtService;

@SpringBootApplication
public class SbData12JoinsApplication {

	public static void main(String[] args) {
	ApplicationContext ctx= 	SpringApplication.run(SbData12JoinsApplication.class, args);
	iPersonMgmtService service = ctx.getBean("PersonService",PersonMgmtServiceImpl.class);
	
	System.out.println("---------------------FULL JOIN---------------------");
	service.getPerson_Full_JOIN_ContactDetails().forEach(row -> {
		for(Object val :row) {
			System.out.print(val+"  ");
		}
		System.out.println();
	});
	
	System.out.println("---------------------Inner JOIN---------------------");
	service.getPerson_Inner_JOIN_ContactDetails().forEach(row -> {
		for(Object val :row) {
			System.out.print(val+"  ");
		}
		System.out.println();
	});
	
	System.out.println("---------------------Right JOIN---------------------");
	service.getPerson_Right_JOIN_ContactDetails().forEach(row -> {
		for(Object val :row) {
			System.out.print(val+"  ");
		}
		System.out.println();
	});
	
	System.out.println("---------------------Left JOIN---------------------");
	service.getPerson_Left_JOIN_ContactDetails().forEach(row -> {
		for(Object val :row) {
			System.out.print(val+"  ");
		}
		System.out.println();
	});
	
	((ConfigurableApplicationContext) ctx).close();
	}

}
