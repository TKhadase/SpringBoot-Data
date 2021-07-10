package com.tushar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tushar.entity.Vaccines;

public interface IPageSortVaccine {
	
	//only sort
	public Iterable<Vaccines> Sorted_FindAll(boolean asc, String... Props);
	
	//Paging +  sort for specific pages
	public Iterable<Vaccines> paged_FindAll(int pageNum, int pageSize, boolean asc, String... Props);
	
	//Paging +  sort for All pages
		public void  getMyPagedData(int pageSize, boolean asc, String... Props);
	
	
}
