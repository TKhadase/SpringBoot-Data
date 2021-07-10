package com.tushar.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tushar.entity.Vaccines;

public interface PageSort_Repositary extends PagingAndSortingRepository<Vaccines, Long> {

	
	
}
