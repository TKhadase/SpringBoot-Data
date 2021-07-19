package com.tushar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.TypeInterfaces.VaccineResult1;
import com.tushar.entity.Vaccines;


public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {

	public List<VaccineResult1> findByVnameEquals(String name);
	public List<VaccineResult1>  findByVnameAndPrice(String name, Double price);
	public List<VaccineResult1>  findByVnameOrPrice(String name, Double price);
	public List<VaccineResult1>  findByPriceBetween(Double min, Double max);
	public List<VaccineResult1> findByPriceLessThanEqual(Double price);
	public List<VaccineResult1> findByPriceGreaterThanEqual(Double price);
	public List<VaccineResult1> findByVnameLike(String name);
	public List<VaccineResult1> findByVnameNotLike(String name);
	public List<VaccineResult1> findByManufacturerStartingWith(String name);
	public List<VaccineResult1> findByManufacturerEndingWith(String name);
	public List<VaccineResult1> findByVnameContaining(String name);
	public List<VaccineResult1> findByPriceOrderByVidAsc(Double price);
	public List<VaccineResult1> findByVnameNot(String name);
	public List<VaccineResult1> findByVnameNotIn(List<String> name);
	
}

