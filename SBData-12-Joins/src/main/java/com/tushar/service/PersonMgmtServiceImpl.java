package com.tushar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.repo.Repo_Person;

@Service("PersonService")
public class PersonMgmtServiceImpl implements iPersonMgmtService {

	@Autowired
	private Repo_Person personRepo;

	@Override
	public List<Object[]> getPerson_Full_JOIN_ContactDetails() {
		return personRepo.fetchPerson_Full_JOIN_ContactDetails();
	}

	@Override
	public List<Object[]> getPerson_Inner_JOIN_ContactDetails() {
		return personRepo.fetchPerson_Inner_JOIN_ContactDetails();
	}

	@Override
	public List<Object[]> getPerson_Right_JOIN_ContactDetails() {
		return personRepo.fetchPerson_Right_JOIN_ContactDetails();
	}

	@Override
	public List<Object[]> getPerson_Left_JOIN_ContactDetails() {
		return personRepo.fetchPerson_Left_JOIN_ContactDetails();
	}
	
}
