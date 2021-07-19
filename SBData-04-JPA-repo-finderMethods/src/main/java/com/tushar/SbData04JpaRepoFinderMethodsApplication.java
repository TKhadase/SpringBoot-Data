package com.tushar;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.service.iServiceVaccineMgmt;

@SpringBootApplication
public class SbData04JpaRepoFinderMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbData04JpaRepoFinderMethodsApplication.class, args);
		iServiceVaccineMgmt Service =	ctx.getBean("vaccineService",iServiceVaccineMgmt.class);
		
		System.out.println("-----------------Equals---------------------");
		Service.search_findBy_nameEquals("Moderna1").forEach(System.out::println);
		
		System.out.println("-------------------And---------------------");
		Service.search_findBy_nameAndPrice("Phizer", 700.0).forEach(System.out::println);
		
		System.out.println("-------------------OR---------------------");
		Service.search_findBy_nameOrPrice("CoviShield", 800.0).forEach(System.out::println);
		
		System.out.println("-------------------Between---------------------");
		Service.search_findBy_PriceBetween(400.0, 800.0).forEach(System.out::println);
		
		System.out.println("-------------------LessThanEqual---------------------");
		Service.search_findBy_PriceLessThanEqual(700.0).forEach(System.out::println);
		
		System.out.println("-------------------GreaterThanEqual---------------------");
		Service.search_findBy_PriceGreaterThanEqual(5000.0).forEach(System.out::println);
		
		System.out.println("-------------------Like---------------------");
		Service.search_findBy_NameLike("%er%").forEach(System.out::println);
		
		System.out.println("-------------------NotLike---------------------");
		Service.search_findBy_NameNotLike("%er%").forEach(System.out::println);
		
		System.out.println("-------------------StartingWith---------------------");
		Service.search_findBy_manufacturerStartingWith("phi").forEach(System.out::println);
		
		System.out.println("-------------------EndingWith---------------------");
		Service.search_findBy_manufacturerEndingWith("1").forEach(System.out::println);
		
		System.out.println("-------------------Containing---------------------");
		Service.search_findBy_NameContaining("Cov").forEach(System.out::println);
		
		System.out.println("-------------------OrderBy---------------------");
		Service.search_findBy_PriceOrderByVidAsc(7891.0).forEach(System.out::println);
		
		System.out.println("-------------------Not---------------------");
		Service.search_findBy_NameNot("Phizer").forEach(System.out::println);
		
		System.out.println("-------------------NotIn---------------------");
		Service.search_findBy_NameNotIn(List.of("Moderna1","Phizer")).forEach(System.out::println);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
