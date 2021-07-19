package com.tushar.service;

import java.util.List;

import com.tushar.entity.Vaccines;

public interface iServiceVaccineMgmt {
	
	public List<Vaccines> searchVacccineByPrice_named(Double min, Double max);
	public List<Vaccines> searchVacccineByPrice_ordinal(Double min, Double max);
	
}
