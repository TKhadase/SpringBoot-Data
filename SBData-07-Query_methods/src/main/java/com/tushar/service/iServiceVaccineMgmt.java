package com.tushar.service;

import java.util.Date;
import java.util.List;

import com.tushar.entity.Vaccines;

public interface iServiceVaccineMgmt {
	
	public List<Vaccines> searchVacccineByPrice_named(Double min, Double max);
	public List<Vaccines> searchVacccineByPrice_ordinal(Double min, Double max);	
	public String searchVacccineNameByid_ordincal(Long id);
	public Object searchVacccineAggregateDetailsByPrice_named(Double min, Double max);
	public Object searchVacccineDetailsByid_ordincal(Long id);
	public int updateVacccineDetailsByid_ordincal(Long id, String name, Double newPrice, String newManufacturer, int doses);
	public int deleteVacccineDetailsByid_ordincal(Long id);
	public Date  getSystemDate();
	public int createNewTable();
	public int dropTable();
	public int newVaccine(int id, String name, double price,  String manufacterName, int  doses);
	
}
