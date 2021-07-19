package com.tushar.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.entity.Vaccines;
import com.tushar.repo.i_JPA_Repo;

@Service("vaccineService")
public class ServiceVaccineMgmt_Impl implements iServiceVaccineMgmt {

	@Autowired
	private i_JPA_Repo vaccineRepo;

	@Override
	public List<Vaccines> searchVacccineByPrice_named(Double min, Double max) {
		return vaccineRepo.VacccineByPrice_named(min, max);
	}
	
	@Override
	public List<Vaccines> searchVacccineByPrice_ordinal(Double min, Double max) {
		return vaccineRepo.VacccineByPrice_ordincal(min, max);
	}

}
