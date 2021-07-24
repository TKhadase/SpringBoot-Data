package com.tushar.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public String searchVacccineNameByid_ordincal(Long id) {
		return vaccineRepo.VacccineNameByid_ordincal(id);
	}

	@Override
	public Object searchVacccineAggregateDetailsByPrice_named(Double min, Double max) {
		return vaccineRepo.VacccineAggregateDetailsByPrice(min, max);
	}

	@Override
	public Object searchVacccineDetailsByid_ordincal(Long id) {
		return vaccineRepo.VacccineDetailsById(id);
	}

	@Override
	public int updateVacccineDetailsByid_ordincal(Long id, String name, Double newPrice, String newManufacturer, int doses) {
		return vaccineRepo.updateVacccineDetailsById(id, name, newPrice, newManufacturer, doses);
	}
	
	@Override
	public int deleteVacccineDetailsByid_ordincal(Long id) {
		return vaccineRepo.deleteVacccineDetailsById(id);
	}

	@Override
	public Date getSystemDate() {
		return vaccineRepo.getSysDate();
	}

	@Override
	public int createNewTable() {
		return vaccineRepo.craeteTable();
	}
	
	@Override
	public int dropTable() {
		return vaccineRepo.dropTable();
	}

	@Override
	public int newVaccine(int id, String name, double price, String manufacterName, int doses) {
		return vaccineRepo.insertVaccine(id, name, price, manufacterName, doses);
	}

	
}
