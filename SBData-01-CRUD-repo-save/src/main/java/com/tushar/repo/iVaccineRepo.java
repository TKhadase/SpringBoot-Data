package com.tushar.repo;

import org.springframework.data.repository.CrudRepository;

import com.tushar.entity.Vaccines;

public interface iVaccineRepo extends CrudRepository<Vaccines, Long> {
	

}
