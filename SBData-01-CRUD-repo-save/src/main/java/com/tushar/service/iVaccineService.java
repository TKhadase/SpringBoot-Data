package com.tushar.service;

import java.util.Optional;

import com.tushar.entity.Vaccines;

public interface iVaccineService {
	
	//count
	public int Vaccines_Count();
	
	//delete
	public String deRegVaccine_deleteById(Long id);
	public String deRegVaccine_deleteByObject(Vaccines vaccine);
	public String deRegVaccine_deleteByIds(Iterable<Long> Ids);
	public String deRegVaccine_deleteByObjects(Iterable<Vaccines> Vaccines);
	public String deReg_deleteAll();
	
	//save + Update
	public String Vaccine_save(Vaccines vaccine);
	public String Vaccine_saveAll(Iterable<Vaccines> Vaccines);
	
	//select
	public Iterable<Vaccines>  Vaccine_FindAllByIds(Iterable<Long> Ids);
	public Optional<Vaccines>  Vaccine_FindById(Long id);
	public Iterable<Vaccines> Vaccine_FindAll();
	public boolean Vaccine_existByid(Long id);
}
