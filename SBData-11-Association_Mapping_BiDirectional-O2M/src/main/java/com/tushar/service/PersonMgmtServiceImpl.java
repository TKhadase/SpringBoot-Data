package com.tushar.service;

import java.util.List;
import java.util.Optional;
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
	public String updatePerson(Person person) {
		return  "Person Details updated:\n"+personRepo.save(person);
	}

	@Override
	public String updateContact(ContactDetails contactDetails) {
		return "Contact Details updated:\n"+contactRepo.save(contactDetails);
	}

	@Override
	public String deletePerson_WithLinkedContactById(int id) {
		String msg="";
		Optional opt= personRepo.findById(id);
		if(opt.isPresent()) {
			personRepo.deleteById(id);
			msg ="person "+id+" Record deleted";
		}else {
			msg ="person "+id+" Record not found to delete";
		}
		return msg;
	}

	@Override
	public String deleteContact_WithLinkedPersonById(int id) {
		String msg="";
		Optional opt= contactRepo.findById(id);
		if(opt.isPresent()) {
			contactRepo.deleteById(id);
			msg ="contact "+id+" Record deleted";
		}else {
			msg ="contact "+id+" Record not found to delete";
		}
		return msg;
	}
	
	@Override
	public String deleteContactsOnly_WithoutLinkedPersonByPerosnId(int id) {
		Optional opt= personRepo.findById(id);
		String msg="";
		
		if(opt.isPresent()) {
			Set<ContactDetails> contacts =((Person) opt.get()).getNumbers();
			contacts.forEach(numers->{
				numers.setPerson(null);
			});
			contactRepo.deleteAll(contacts);
			msg ="person "+id+" Record  found & delete "+contacts.size()+" contacts";
		}
		else {
			msg ="person "+id+" Record not found to delete contacts";
		}
		
		return msg;
	}
	
	
}
