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
	
	public String updatePerson(Person person);
	public String  updateContact(ContactDetails  contactDetails);
	
	public String deletePerson_WithLinkedContactById(int id);
	public String  deleteContact_WithLinkedPersonById(int id);
	public String  deleteContactsOnly_WithoutLinkedPersonByPerosnId(int id);
	
}