package com.tushar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tushar.entity.Vaccines;


public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {
	
	@Query("FROM Vaccines WHERE price>=:min  AND price<=:max")
	public List<Vaccines> VacccineByPrice_named(Double min, Double max);
	
	@Query("FROM Vaccines WHERE price>=?1  AND price<=?2")
	public List<Vaccines> VacccineByPrice_ordincal(Double min, Double max);
	
}

