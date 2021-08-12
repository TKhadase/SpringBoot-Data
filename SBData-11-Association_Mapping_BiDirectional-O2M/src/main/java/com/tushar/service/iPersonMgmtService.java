package com.tushar.service;

import java.util.List;
import java.util.Set;

import com.tushar.entity.ContactDetails;
import com.tushar.entity.Person;

public interface iPersonMgmtService {

	public String registerPerson_withContact(Person  person);
	public String registerContact_withPerson(Iterable<ContactDetails> setContactDetails);
	
	public List<Person>  getAllPerson_withContact();
	public List<ContactDetails> getAllContact_withPerson( );
	
	public Person getPerson_withContactByPID(int pid );
	public ContactDetails getContact_withPersonByCID(int pid );
	
}