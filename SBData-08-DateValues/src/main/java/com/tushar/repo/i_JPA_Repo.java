package com.tushar.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tushar.entity.Person;

public interface i_JPA_Repo extends JpaRepository<Person, Long> {

	
}

