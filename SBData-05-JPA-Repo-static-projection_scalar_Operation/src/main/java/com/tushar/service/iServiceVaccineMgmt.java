package com.tushar.service;

import java.util.List;

import com.tushar.TypeInterfaces.VaccineResult1;
import com.tushar.entity.Vaccines;

public interface iServiceVaccineMgmt {
	
	public List<VaccineResult1> search_findBy_nameEquals(String name);
	public List<VaccineResult1>  search_findBy_nameAndPrice(String name, Double price);
	public List<VaccineResult1>  search_findBy_nameOrPrice(String name, Double price);
	public List<VaccineResult1>  search_findBy_PriceBetween(Double min, Double max);
	public List<VaccineResult1> search_findBy_PriceLessThanEqual(Double price);
	public List<VaccineResult1> search_findBy_PriceGreaterThanEqual(Double price);
	public List<VaccineResult1> search_findBy_NameLike(String name);
	public List<VaccineResult1> search_findBy_NameNotLike(String name);
	public List<VaccineResult1> search_findBy_manufacturerStartingWith(String name);
	public List<VaccineResult1> search_findBy_manufacturerEndingWith(String name);
	public List<VaccineResult1> search_findBy_NameContaining(String name);
	public List<VaccineResult1> search_findBy_PriceOrderByVidAsc(Double price);
	public List<VaccineResult1> search_findBy_NameNot(String name);
	public List<VaccineResult1> search_findBy_NameNotIn(List<String> name);
}
