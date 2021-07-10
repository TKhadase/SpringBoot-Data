package com.tushar.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.tushar.entity.Vaccines;
import com.tushar.service.PageSort_ServiceImpl;

@Component
public class MyRunner implements ApplicationRunner {

	@Autowired
	private PageSort_ServiceImpl page_sort;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	System.out.println("--------------------MyRunner.run() started---------------------");
	
	System.out.println("--------------------Sorting---------------------");
	boolean ascending=true;
	Iterable<Vaccines>  sortedVaccine= page_sort.Sorted_FindAll(ascending, "vid");
	sortedVaccine.forEach(System.out::println);
	
	System.out.println("--------------------Paging + Sorting--------------------------");
	int pageSize =4;
	page_sort.paged_FindAll(1, pageSize, ascending,  "vid").forEach(System.out::println);
	page_sort.getMyPagedData(pageSize , ascending, "vid");
	}

}
