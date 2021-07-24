package com.tushar;

import java.util.Iterator;

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
		
		System.out.println("---------------Single column--------------");
		System.out.println("Name:"+Service.searchVacccineNameByid_ordincal(14L));
		
		System.out.println("---------------multi column--------------");
		Object[] objVaccineDetails = (Object[]) Service.searchVacccineDetailsByid_ordincal(14L);
		for (Object v : objVaccineDetails) {
			System.out.println("VacccineDetails:: "+v);
		}
		
		System.out.println("---------------Aggregate functions--------------");
		Object[] objVaccine = (Object[]) Service.searchVacccineAggregateDetailsByPrice_named(100.0, 1000.0);
		System.out.println("count*:: "+objVaccine[0]);
		System.out.println("min*:: "+objVaccine[1]);
		System.out.println("max*:: "+objVaccine[2]);
		System.out.println("avg*:: "+objVaccine[3]);
		System.out.println("sum*:: "+objVaccine[4]);
		
		System.out.println("---------------Update--------------");
		int i_Update= Service.updateVacccineDetailsByid_ordincal(14L, "CoviJIVAN",451.0, "TK", 1);
		System.out.println(i_Update+" Record updated");
		 
		  System.out.println("---------------native SQL Query: SYSDATE--------------"); 
		  System.out.println("SYSDATE::"+Service.getSystemDate());
		  
		  System.out.println("---------------native SQL Query: CREATE--------------"); 
		  int i_create = Service.createNewTable();
		  if(i_create==0) {
		  System.out.println(" table created");
		  }
		  else {
			  System.out.println("table not created");
		  }
		  
		  System.out.println("---------------native SQL Query: DROP--------------"); 
		  int i_drop = Service.dropTable();
		  if(i_drop==0) {
		  System.out.println(" table dropped");
		  }
		  else {
			  System.out.println("table not dropped");
		  }
		  
		  System.out.println("---------------native SQL Query: INSERT--------------"); 
		  int i_insert = Service.newVaccine(1, "Sanjivani",940.0, "IND-TECH",1);
		  System.out.println(i_insert+" record inserted");
		  
		  System.out.println("---------------delete--------------"); 
		  int i_delete= Service.deleteVacccineDetailsByid_ordincal(1L);
		  System.out.println(i_delete+" Record deleted");
				
		((ConfigurableApplicationContext) ctx).close();
	}

}
