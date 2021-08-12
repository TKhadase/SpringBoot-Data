package com.tushar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.entity.Person;

public interface Repo_Person extends JpaRepository<Person, Integer> {

}
