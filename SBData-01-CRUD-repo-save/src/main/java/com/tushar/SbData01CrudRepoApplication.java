package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.tushar.entity.Vaccines;
import com.tushar.service.iVaccineService;

@SpringBootApplication
public class SbData01CrudRepoApplication {

	public static void main(String[] args) {
		System.out.println("------------------------SbData01CrudRepoApplication.main() start------------------------");
		ApplicationContext ctx =  SpringApplication.run(SbData01CrudRepoApplication.class, args);
		try {
		//delete
			
		//insert
		Vaccines vaccine = new Vaccines(null,"CoviShield", "Serum IND", 400.0, 2 ) ;
		System.out.println("vaccine ready");
		iVaccineService vService = ctx.getBean("VaccineService",iVaccineService.class);
		System.out.println(vService.regVaccine(vaccine));
		
		//update
		
		//select
		
		
		
		}catch(DataAccessException a) {
			a.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("-----------------------------SbData01CrudRepoApplication.main() end-----------------------------");
	}

}
