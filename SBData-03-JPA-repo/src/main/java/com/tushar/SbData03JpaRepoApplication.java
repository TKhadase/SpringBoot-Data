package com.tushar;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.LazyInitializationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.entity.Vaccines;
import com.tushar.service.iServiceVaccineMgmt;

@SpringBootApplication
public class SbData03JpaRepoApplication {

	public static void main(String[] args) {
		System.out.println("SbData03JpaRepoApplication.main()::: started");
		ApplicationContext ctx = SpringApplication.run(SbData03JpaRepoApplication.class, args);
		
		iServiceVaccineMgmt Service =	ctx.getBean("vaccineService",iServiceVaccineMgmt.class);
		
		System.out.println("------------FindAll with Exampl & Sort object----------");
		boolean isAsc =true;
		Vaccines v = new Vaccines();
		v.setDoseCount(2);
		v.setVname("Moderna1");
		v.setManufacturer("moderna1");
		v.setPrice(7891.0);
		//Service.search_findAll_exampl_sort(v, isAsc, "vid").forEach(System.out::println);;
		System.out.println("------------getById--(add additional prop in application.properties:: spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true)-----");
		Long vid=(long) 11;
		Vaccines resultVaccine = Service.search_getById_id(vid);
		try {
			System.out.println(resultVaccine);
		} 
		catch (LazyInitializationException le) {
			System.out.println("Record not available with ID#" + vid);
		}

		System.out.println("------------deleteAll in batch----------");
		System.out.println(Service.delete_deleteAllByIdInBatch_longIds(List.of(12L,13L)));
		
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("SbData03JpaRepoApplication.main()::: end");
	}

}
