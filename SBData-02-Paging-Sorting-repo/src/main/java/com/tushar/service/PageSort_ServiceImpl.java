package com.tushar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tushar.entity.Vaccines;
import com.tushar.repo.PageSort_Repositary;

@Service("vaccinePageSort_Service")
public class PageSort_ServiceImpl implements IPageSortVaccine {
	
	@Autowired
	private PageSort_Repositary  vaccineRepo;

	@Override
	public Iterable<Vaccines> Sorted_FindAll(boolean asc, String... Props) {
		System.out.println("PageSort_ServiceImpl.Sorted_FindAll()");
	   Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, Props);
	   Iterable<Vaccines> soetedVaccine = vaccineRepo.findAll(sort);
		return soetedVaccine;
	}

	@Override
	public Iterable<Vaccines> paged_FindAll(int pageNum, int pageSize, boolean asc, String... Props) {
	    System.out.println("PageSort_ServiceImpl.paged_FindAll()");
	    Pageable pageable= PageRequest.of(pageNum, pageSize, asc?Direction.ASC:Direction.DESC, Props);
	    Page<Vaccines> vaccinePage = vaccineRepo.findAll(pageable);
		return vaccinePage.getContent();
	 }

	@Override
	public void  getMyPagedData(int pageSize, boolean asc, String... Props) {
		int availbleDataCount = (int) vaccineRepo.count();
		int totalPagesAvaialble = availbleDataCount/pageSize;
		totalPagesAvaialble = (availbleDataCount%pageSize) ==0? totalPagesAvaialble: ++totalPagesAvaialble;
		System.out.println("availbleDataCount:"+availbleDataCount);
		System.out.println("totalPagesAvaialble:"+totalPagesAvaialble);
		
		for(int i =0; i<totalPagesAvaialble;++i)  
		{
			   Pageable pageable= PageRequest.of(i, pageSize, asc?Direction.ASC:Direction.DESC, Props);
			    Page<Vaccines> vaccinePage = vaccineRepo.findAll(pageable);
			    System.out.println("::::::::::::::::::Page:"+(i+1)+" of "+vaccinePage.getTotalPages()+"::::::::::::::::::::");
			    vaccinePage.getContent().forEach(System.out::println);
		}
		  System.out.println("-------------------------------------------------");
	}
	
}


