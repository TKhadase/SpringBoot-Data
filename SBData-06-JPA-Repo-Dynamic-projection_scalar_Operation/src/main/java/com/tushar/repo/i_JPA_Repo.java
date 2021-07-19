package com.tushar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.TypeInterfaces.*;
import com.tushar.entity.Vaccines;


public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {

	public <T extends vaccineResult_Marker> List<T>  findByVnameEquals(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  findByVnameAndPrice(String name, Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  findByVnameOrPrice(String name, Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  findByPriceBetween(Double min, Double max, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByPriceLessThanEqual(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByPriceGreaterThanEqual(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByVnameLike(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByVnameNotLike(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByManufacturerStartingWith(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByManufacturerEndingWith(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByVnameContaining(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByPriceOrderByVidAsc(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByVnameNot(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> findByVnameNotIn(List<String> name, Class<T> clazz);
	
}

