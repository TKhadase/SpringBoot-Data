package com.tushar.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.TypeInterfaces.*;
import com.tushar.entity.Vaccines;
import com.tushar.repo.i_JPA_Repo;

@Service("vaccineService")
public class ServiceVaccineMgmt_Impl implements iServiceVaccineMgmt {

	@Autowired
	private i_JPA_Repo vaccineRepo;

	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_nameEquals(String name, Class<T> clazz){
		return vaccineRepo.findByVnameEquals(name,clazz);
		
	}

	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_nameAndPrice(String name, Double price, Class<T> clazz){
		return vaccineRepo.findByVnameAndPrice(name, price,clazz);
		
	}

	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_nameOrPrice(String name, Double price, Class<T> clazz){
		return vaccineRepo.findByVnameOrPrice(name, price,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceBetween(Double min, Double max, Class<T> clazz){
		return vaccineRepo.findByPriceBetween(min, max,clazz);
		
	}

	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceLessThanEqual(Double price, Class<T> clazz){
		return vaccineRepo.findByPriceLessThanEqual(price,clazz);
		
	}

	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceGreaterThanEqual(Double price, Class<T> clazz){
		return vaccineRepo.findByPriceGreaterThanEqual(price,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameLike(String name, Class<T> clazz){
		return vaccineRepo.findByVnameLike(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNotLike(String name, Class<T> clazz){
		return vaccineRepo.findByVnameNotLike(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_manufacturerStartingWith(String name, Class<T> clazz){
		return vaccineRepo.findByManufacturerStartingWith(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_manufacturerEndingWith(String name, Class<T> clazz){
		return vaccineRepo.findByManufacturerEndingWith(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameContaining(String name, Class<T> clazz){
		return vaccineRepo.findByVnameContaining(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceOrderByVidAsc(Double Price, Class<T> clazz){
		return vaccineRepo.findByPriceOrderByVidAsc(Price,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNot(String name, Class<T> clazz){
		return vaccineRepo.findByVnameNot(name,clazz);
		
	}
	
	@Override
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNotIn(List<String> name, Class<T> clazz){
		return vaccineRepo.findByVnameNotIn(name ,clazz);
		
	}

}
