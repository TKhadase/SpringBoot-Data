package com.tushar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tushar.entity.Vaccines;

public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {

	
}
