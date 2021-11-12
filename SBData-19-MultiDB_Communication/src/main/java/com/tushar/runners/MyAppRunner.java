package com.tushar.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tushar.model.mysql.Orders;
import com.tushar.model.oracle.Product;
import com.tushar.repo.MySqlRepo.iOrdersRepo;
import com.tushar.repo.OracleRepo.iProductRepo;

@Component
public class MyAppRunner implements CommandLineRunner {

	@Autowired
	private iOrdersRepo orderRepo;
	
	@Autowired
	private iProductRepo prodRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		prodRepo.save(new Product("PEN", 20.0, 10, LocalDate.of(2021,11, 10)));
		System.out.println("----------------------Product details saved in Oracle DB--------------------------");

		orderRepo.save(new Orders("101", 555.5,"ytl", LocalDate.now()));
		System.out.println("----------------------Orders details saved in MySQL DB--------------------------");
		
		System.out.println("----------------------Product details from Oracle DB:::");
		prodRepo.findAll().forEach(System.out::println);
		System.out.println("----------------------Orders details from MySQL DB:::");
		orderRepo.findAll().forEach(System.out::println);
	}

}
