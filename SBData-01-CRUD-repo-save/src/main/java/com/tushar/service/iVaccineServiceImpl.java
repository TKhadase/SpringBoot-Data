package com.tushar.service;

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
	

}
