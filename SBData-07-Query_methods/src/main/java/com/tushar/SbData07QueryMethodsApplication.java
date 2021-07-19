package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.service.iServiceVaccineMgmt;

@SpringBootApplication
public class SbData07QueryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbData07QueryMethodsApplication.class, args);
		iServiceVaccineMgmt Service =	ctx.getBean("vaccineService",iServiceVaccineMgmt.class);
		
		System.out.println("---------------findByPriceLessThanEqualAndGreaterThanEqual_named--------------");
		Service.searchVacccineByPrice_named(100.0, 1000.0).forEach(System.out::println);
		
		System.out.println("---------------findByPriceLessThanEqualAndGreaterThanEqual_ordinal--------------");
		Service.searchVacccineByPrice_ordinal(100.0, 1000.0).forEach(System.out::println);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
