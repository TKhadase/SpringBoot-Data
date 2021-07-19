package com.tushar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.entity.Vaccines;

public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {

	public List<Vaccines> findByVnameEquals(String name);
	public List<Vaccines>  findByVnameAndPrice(String name, Double price);
	public List<Vaccines>  findByVnameOrPrice(String name, Double price);
	public List<Vaccines>  findByPriceBetween(Double min, Double max);
	public List<Vaccines> findByPriceLessThanEqual(Double price);
	public List<Vaccines> findByPriceGreaterThanEqual(Double price);
	public List<Vaccines> findByVnameLike(String name);
	public List<Vaccines> findByVnameNotLike(String name);
	public List<Vaccines> findByManufacturerStartingWith(String name);
	public List<Vaccines> findByManufacturerEndingWith(String name);
	public List<Vaccines> findByVnameContaining(String name);
	public List<Vaccines> findByPriceOrderByVidAsc(Double price);
	public List<Vaccines> findByVnameNot(String name);
	public List<Vaccines> findByVnameNotIn(List<String> name);
	
}

