package com.tushar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.entity.ContactDetails;
import com.tushar.entity.Person;
import com.tushar.repo.Repo_ContactDetails;
import com.tushar.repo.Repo_Person;

@Service("PersonService")
public class PersonMgmtServiceImpl implements iPersonMgmtService {

	@Autowired
	private Repo_Person personRepo;
	
	@Autowired
	private Repo_ContactDetails contactRepo;
	
	@Override
	public String registerPerson_withContact(Person person) {
		return "Person details registered with ID#"+personRepo.save(person).getPid();
	}

	@Override
	public String registerContact_withPerson(Iterable<ContactDetails>  setContactDetails) {
		for(ContactDetails cd : setContactDetails) {
			contactRepo.save(cd);
		}
		return ( (Set<ContactDetails>) setContactDetails).size()+" no.of phoneNumbers are saved";
	}

	@Override
	public List<Person>  getAllPerson_withContact() {
		return personRepo.findAll();
	}

	@Override
	public List<ContactDetails> getAllContact_withPerson() {
		return contactRepo.findAll();
	}

	@Override
	public Person getPerson_withContactByPID(int pid) {
		return null;
	}

	@Override
	public ContactDetails getContact_withPersonByCID(int pid) {
		return null;
	}

}
