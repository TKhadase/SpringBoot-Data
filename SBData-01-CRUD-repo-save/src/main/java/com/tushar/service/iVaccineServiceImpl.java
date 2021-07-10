package com.tushar.service;

import java.util.List;
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
	public int Vaccines_Count() {
		System.out.println("iVaccineServiceImpl.Vaccines_Count()");
		return (int) vaccineRepo.count();
	}

	@Override
	public String deRegVaccine_deleteById(Long id) {
		System.out.println("iVaccineServiceImpl.deRegVaccine_deleteById()");
		Optional<Vaccines> oVaccine= vaccineRepo.findById(id);
		
		if(oVaccine.isPresent()) {
			vaccineRepo.deleteById(id);
			return "vaccine ID:"+id+" deleted";
		}else
		return "vaccine ID:"+id+"not  exist";
		
		/*if(id!= null && vaccineRepo.existsById(id) ) {
			vaccineRepo.deleteById(id);
			return "vaccine "+id+" deleted";
		}
		return "vaccine "+id+"not  exist";
		*/
	}

	@Override
	public String deRegVaccine_deleteByObject(Vaccines vaccine) {
		System.out.println("iVaccineServiceImpl.deRegVaccine_deleteByObject()");
		Optional<Vaccines> oVaccine= vaccineRepo.findById(vaccine.getVid());
		
		if(oVaccine.isPresent()) {
			vaccineRepo.delete(vaccine);
			return "vaccine ID:"+vaccine.getVid()+" deleted";
		}else
		return "vaccine does not  exist";
		
		/*	if(vaccine!= null && vaccineRepo.existsById(vaccine.getVid()) ) {
			vaccineRepo.delete(vaccine);
			return "vaccine "+vaccine.getVid()+" deleted";
		}
		return "vaccine not  exist";
		*/
	}

	@Override
	public String deRegVaccine_deleteByIds(Iterable<Long> Ids) {
		System.out.println("iVaccineServiceImpl.deRegVaccine_deleteByIds()");
		Iterable <Vaccines> listVaccines= vaccineRepo.findAllById(Ids);
	  int count_Ids = ((List) Ids).size();
	  int count_listVaccines =((List) listVaccines).size();
	  if(count_Ids==count_listVaccines) {
			vaccineRepo.deleteAllById(Ids);
			return count_Ids+" vaccine  deleted";
	  }else {
		  return " vaccine not  deleted";
	  }
	}

	@Override
	public String deRegVaccine_deleteByObjects(Iterable<Vaccines> Vaccines) {
		System.out.println("iVaccineServiceImpl.deRegVaccine_deleteByObjects()");
		  int count_listVaccines =((List) Vaccines).size();
		  int existCount = (int) vaccineRepo.count();
		vaccineRepo.deleteAll(Vaccines);
		return (existCount-count_listVaccines)+" vaccines  deleted";
	}

	@Override
	public String deReg_deleteAll() {
		System.out.println("iVaccineServiceImpl.deReg_deleteAll()");
		int count = (int) vaccineRepo.count();
		if(count>0) {
			vaccineRepo.deleteAll();
			}
		return count+" vaccines deleted.";
	}
	
	@Override
	public String Vaccine_save(Vaccines vaccine) {
		System.out.println("iVaccineServiceImpl.Vaccine_save()");
		Vaccines savedVaccine = null;
		System.out.println("iVaccineServiceImpl.regVaccine()");
		if(vaccine != null) {
			savedVaccine = vaccineRepo.save(vaccine);
		}
		return savedVaccine!=null? "vaccine registration/updation sucessful: "+savedVaccine.toString() : "vaccine registration/updation failed" ;
	}

	@Override
	public String Vaccine_saveAll(Iterable<Vaccines> Vaccines) {
		System.out.println("iVaccineServiceImpl.Vaccine_saveAll()");
		Iterable<Vaccines>  savedVaccines =null;
		if(Vaccines != null) {
			savedVaccines	= vaccineRepo.saveAll(Vaccines);
		}
		return savedVaccines!=null? "vaccine registration/updation sucessful: " : "vaccine registration/updation failed" ;
	}

	@Override
	public Iterable<Vaccines> Vaccine_FindAllByIds(Iterable<Long> Ids) {
		System.out.println("iVaccineServiceImpl.Vaccine_FindAllByIds()");
		return vaccineRepo.findAllById(Ids);
	}

	@Override
	public Optional<Vaccines> Vaccine_FindById(Long id) {
		System.out.println("iVaccineServiceImpl.Vaccine_FindById()");
		return vaccineRepo.findById(id);
	}

	@Override
	public Iterable<Vaccines> Vaccine_FindAll() {
		System.out.println("iVaccineServiceImpl.Vaccine_FindAll()");
		return vaccineRepo.findAll();
	}

	@Override
	public boolean Vaccine_existByid(Long id) {
		System.out.println("iVaccineServiceImpl.Vaccine_existByid()");
		return vaccineRepo.existsById(id);
	}

}
