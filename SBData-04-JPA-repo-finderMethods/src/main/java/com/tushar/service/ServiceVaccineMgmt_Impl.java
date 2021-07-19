package com.tushar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tushar.entity.Vaccines;
import com.tushar.repo.i_JPA_Repo;

@Service("vaccineService")
public class ServiceVaccineMgmt_Impl implements iServiceVaccineMgmt {

	@Autowired
	private i_JPA_Repo vaccineRepo;

	@Override
	public List<Vaccines> search_findBy_nameEquals(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameEquals(name);
		return vaccines;
	}

	@Override
	public List<Vaccines> search_findBy_nameAndPrice(String name, Double price) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameAndPrice(name, price);
		return vaccines;
	}

	@Override
	public List<Vaccines> search_findBy_nameOrPrice(String name, Double price) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameOrPrice(name, price);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_PriceBetween(Double min, Double max) {
		List<Vaccines> vaccines = vaccineRepo.findByPriceBetween(min, max);
		return vaccines;
	}

	@Override
	public List<Vaccines> search_findBy_PriceLessThanEqual(Double price) {
		List<Vaccines> vaccines = vaccineRepo.findByPriceLessThanEqual(price);
		return vaccines;
	}

	@Override
	public List<Vaccines> search_findBy_PriceGreaterThanEqual(Double price) {
		List<Vaccines> vaccines = vaccineRepo.findByPriceGreaterThanEqual(price);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_NameLike(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameLike(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_NameNotLike(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameNotLike(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_manufacturerStartingWith(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByManufacturerStartingWith(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_manufacturerEndingWith(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByManufacturerEndingWith(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_NameContaining(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameContaining(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_PriceOrderByVidAsc(Double Price) {
		List<Vaccines> vaccines = vaccineRepo.findByPriceOrderByVidAsc(Price);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_NameNot(String name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameNot(name);
		return vaccines;
	}
	
	@Override
	public List<Vaccines> search_findBy_NameNotIn(List<String> name) {
		List<Vaccines> vaccines = vaccineRepo.findByVnameNotIn(name);
		return vaccines;
	}

}
