package com.tushar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tushar.entity.Vaccines;
import com.tushar.repo.i_JPA_Repo;

@Service("vaccineService")
public class ServiceVaccineMgmt_Impl implements iServiceVaccineMgmt {

	@Autowired
	private i_JPA_Repo vaccineRepo;

	@Override
	public List<Vaccines> search_findAll_exampl_sort(Vaccines v, Boolean isAsc, String... properties) {
		Example ex = Example.of(v);
		Sort sort = Sort.by(isAsc ? Direction.ASC : Direction.DESC, properties);
		List<Vaccines> listVaccine = vaccineRepo.findAll(ex, sort);
		return listVaccine;
	}

	@Override
	public Vaccines search_getById_id(Long vid) {
		Vaccines vaccine = vaccineRepo.getById(vid);
		return vaccine;
	}

	@Override
	public String delete_deleteAllByIdInBatch_longIds(Iterable<Long> ids) {
		Iterable<Vaccines> v = vaccineRepo.findAllById(ids);
		if (((List) v).size() > 0) {
			vaccineRepo.deleteAllByIdInBatch(ids);
			return ((List) v).size() + " no.of records deleted";
		}
		return  "records not deleted";
	}

}
