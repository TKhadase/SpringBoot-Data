package com.tushar.service;

import java.util.List;

import com.tushar.TypeInterfaces.*;
import com.tushar.entity.Vaccines;

public interface iServiceVaccineMgmt {
	
	public <T extends vaccineResult_Marker> List<T> search_findBy_nameEquals(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  search_findBy_nameAndPrice(String name, Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  search_findBy_nameOrPrice(String name, Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T>  search_findBy_PriceBetween(Double min, Double max, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceLessThanEqual(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceGreaterThanEqual(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameLike(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNotLike(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_manufacturerStartingWith(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_manufacturerEndingWith(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameContaining(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_PriceOrderByVidAsc(Double price, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNot(String name, Class<T> clazz);
	public <T extends vaccineResult_Marker> List<T> search_findBy_NameNotIn(List<String> name, Class<T> clazz);
}
