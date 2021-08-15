package com.tushar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tushar.entity.Person;

public interface Repo_Person extends JpaRepository<Person, Integer> {

	@Query("SELECT p.pid,   p.fName, p.lName, p.addrs, c.cid,  c.numType, c.provider,  c.mobileNumber FROM Person p full join p.numbers c")
	public List<Object[]> fetchPerson_Full_JOIN_ContactDetails();
	
	@Query("SELECT p.pid,   p.fName, p.lName, p.addrs, c.cid,  c.numType, c.provider,  c.mobileNumber FROM Person p inner join p.numbers c")
	public List<Object[]> fetchPerson_Inner_JOIN_ContactDetails();

	@Query("SELECT p.pid,   p.fName, p.lName, p.addrs, c.cid,  c.numType, c.provider,  c.mobileNumber FROM Person p right join p.numbers c")
	public List<Object[]> fetchPerson_Right_JOIN_ContactDetails();
	
	@Query("SELECT p.pid,   p.fName, p.lName, p.addrs, c.cid,  c.numType, c.provider,  c.mobileNumber FROM Person p left join p.numbers c")
	public List<Object[]> fetchPerson_Left_JOIN_ContactDetails();
	
}
