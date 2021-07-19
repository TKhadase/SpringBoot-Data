package com.tushar;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.TypeInterfaces.VaccineResultManufacturer_DoseCount;
import com.tushar.TypeInterfaces.VaccineResultNamePrice;
import com.tushar.TypeInterfaces.VaccineResult_vid_name_manufacturer;
import com.tushar.service.iServiceVaccineMgmt;

@SpringBootApplication
public class SbData06JpaRepoDynamicProjectionScalarOperationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SbData06JpaRepoDynamicProjectionScalarOperationApplication.class, args);
		iServiceVaccineMgmt Service =	ctx.getBean("vaccineService",iServiceVaccineMgmt.class);
		
		System.out.println("-----------------Equals---------------------");
		List<VaccineResult_vid_name_manufacturer>  list1 = Service.search_findBy_nameEquals("Moderna1", VaccineResult_vid_name_manufacturer.class);
		list1.forEach(list->System.out.println("id# "+list.getVid()+", "+list.getVname()+", "+list.getManufacturer()));
		
		System.out.println("-------------------And---------------------");
		List<VaccineResult_vid_name_manufacturer>  list2 =Service.search_findBy_nameAndPrice("Phizer", 700.0, VaccineResult_vid_name_manufacturer.class);
		list2.forEach(list->System.out.println("id# "+list.getVid()+", "+list.getVname()+", "+list.getManufacturer()));
	
		
		System.out.println("-------------------OR---------------------");
		List<VaccineResult_vid_name_manufacturer>  list3 =Service.search_findBy_nameOrPrice("CoviShield", 800.0, VaccineResult_vid_name_manufacturer.class);
		list3.forEach(list->System.out.println("id# "+list.getVid()+", "+list.getVname()+", "+list.getManufacturer()));	
	
		
		System.out.println("-------------------Between---------------------");
		List<VaccineResult_vid_name_manufacturer>  list4 =Service.search_findBy_PriceBetween(400.0, 800.0, VaccineResult_vid_name_manufacturer.class);
		list4.forEach(list->System.out.println("id# "+list.getVid()+", "+list.getVname()+", "+list.getManufacturer()));
	
		
		System.out.println("-------------------LessThanEqual---------------------");
		List<VaccineResult_vid_name_manufacturer>  list5  =Service.search_findBy_PriceLessThanEqual(700.0, VaccineResult_vid_name_manufacturer.class);
		list5.forEach(list->System.out.println("id# "+list.getVid()+", "+list.getVname()+", "+list.getManufacturer()));
	
		
		System.out.println("-------------------GreaterThanEqual---------------------");
		List<VaccineResultManufacturer_DoseCount>  list6 =Service.search_findBy_PriceGreaterThanEqual(5000.0, VaccineResultManufacturer_DoseCount.class);
		list6.forEach(list->System.out.println("company# "+list.getManufacturer()+", "+list.getDoseCount()));	
	
		
		System.out.println("-------------------Like---------------------");
		List<VaccineResultManufacturer_DoseCount>  list7 =Service.search_findBy_NameLike("%er%", VaccineResultManufacturer_DoseCount.class);
		list7.forEach(list->System.out.println("company# "+list.getManufacturer()+", "+list.getDoseCount()));	
	
		
		System.out.println("-------------------NotLike---------------------");
		List<VaccineResultManufacturer_DoseCount>  list8 =Service.search_findBy_NameNotLike("%er%", VaccineResultManufacturer_DoseCount.class);
		list8.forEach(list->System.out.println("company# "+list.getManufacturer()+", "+list.getDoseCount()));		
	
		
		System.out.println("-------------------StartingWith---------------------");
		List<VaccineResultManufacturer_DoseCount>  list9 =Service.search_findBy_manufacturerStartingWith("phi", VaccineResultManufacturer_DoseCount.class);
		list9.forEach(list->System.out.println("company# "+list.getManufacturer()+", "+list.getDoseCount()));	
	
		
		System.out.println("-------------------EndingWith---------------------");
		List<VaccineResultManufacturer_DoseCount>  list10 =Service.search_findBy_manufacturerEndingWith("1", VaccineResultManufacturer_DoseCount.class);
		list10.forEach(list->System.out.println("company# "+list.getManufacturer()+", "+list.getDoseCount()));	
	
		
		System.out.println("-------------------Containing---------------------");
		List<VaccineResultNamePrice>  list11 =Service.search_findBy_NameContaining("Cov", VaccineResultNamePrice.class);
		list11.forEach(list->System.out.println("name# "+list.getVname()+", "+list.getPrice()));			
	
		
		System.out.println("-------------------OrderBy---------------------");
		List<VaccineResultNamePrice>  list12 =Service.search_findBy_PriceOrderByVidAsc(7891.0, VaccineResultNamePrice.class);
		list12.forEach(list->System.out.println("name# "+list.getVname()+", "+list.getPrice()));	
	
		
		System.out.println("-------------------Not---------------------");
		List<VaccineResultNamePrice>  list13 =Service.search_findBy_NameNot("Phizer", VaccineResultNamePrice.class);
		list13.forEach(list->System.out.println("name# "+list.getVname()+", "+list.getPrice()));	
	
		
		System.out.println("-------------------NotIn---------------------");
		List<VaccineResultNamePrice>  list14  =Service.search_findBy_NameNotIn(List.of("Moderna1","Phizer"), VaccineResultNamePrice.class);
		list14.forEach(list->System.out.println("name# "+list.getVname()+", "+list.getPrice()));		
	
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
