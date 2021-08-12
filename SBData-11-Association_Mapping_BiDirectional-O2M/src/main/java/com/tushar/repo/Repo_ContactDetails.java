package com.tushar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.entity.ContactDetails;

public interface Repo_ContactDetails extends JpaRepository<ContactDetails, Integer> {

	
}
