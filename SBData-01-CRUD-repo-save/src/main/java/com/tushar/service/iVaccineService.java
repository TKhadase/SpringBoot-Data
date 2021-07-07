package com.tushar.service;

import java.util.Optional;

import com.tushar.entity.Vaccines;

public interface iVaccineService {
	
	public String regVaccine(Vaccines vaccine);
	public String deRegVaccine(Vaccines vaccine);
	public String deRegAllVaccine();
	public Optional<Vaccines>  FindAllByIds(Iterable Long);
	public Optional<Vaccines>  FindById(Long id);
	public int Count();
	public boolean existByid();
	
	
}
