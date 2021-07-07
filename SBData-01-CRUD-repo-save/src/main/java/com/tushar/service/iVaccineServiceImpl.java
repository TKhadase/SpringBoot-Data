package com.tushar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.entity.Vaccines;
import com.tushar.repo.iVaccineRepo;

@Service("VaccineService")
public class iVaccineServiceImpl implements iVaccineService{

	@Autowired
	private iVaccineRepo vaccineRepo;
	
	@Override
	public String regVaccine(Vaccines vaccine) {
		Vaccines savedVaccine = null;
		System.out.println("iVaccineServiceImpl.regVaccine()");
		if(vaccine != null) {
			savedVaccine = vaccineRepo.save(vaccine);
		}
		return savedVaccine!=null? "vaccine registration/updation sucessful: "+savedVaccine.toString() : "vaccine registration/updation failed" ;
	}

	@Override
	public String deRegVaccine(Vaccines vaccine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deRegAllVaccine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vaccines> FindAllByIds(Iterable Long) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vaccines> FindById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existByid() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
