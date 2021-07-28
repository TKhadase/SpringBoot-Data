package com.tushar.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tushar.entity.Person;
import com.tushar.repo.i_JPA_Repo;

@Service("personService")
public class ServicePersonMgmt_Impl implements iServicePersonMgmt {

	@Autowired
	private i_JPA_Repo personRepo;

	@Override
	public Person regPerson(Person p) {
		return personRepo.save(p);
	}

	
}
