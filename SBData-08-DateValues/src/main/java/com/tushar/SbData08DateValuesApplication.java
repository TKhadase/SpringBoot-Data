package com.tushar;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tushar.entity.Person;
import com.tushar.service.iServicePersonMgmt;

@SpringBootApplication
public class SbData08DateValuesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(SbData08DateValuesApplication.class, args);
		iServicePersonMgmt Service =	ctx.getBean("personService",iServicePersonMgmt.class);
		
		System.out.println("------Date Value insetion----------");
		Person p = new Person(null,"TusharK", "YTL",33000.0,  24 , 
													LocalDate.of(1997, 03, 28), //DOB
													LocalTime.of(10, 2),  //TOB      //TIME data type not available in ORACLE, works in MySQL
													LocalDateTime.of(2020,  01, 14, 10, 11, 2));//DOJ
		System.out.println( Service.regPerson(p));
		
	}

}
