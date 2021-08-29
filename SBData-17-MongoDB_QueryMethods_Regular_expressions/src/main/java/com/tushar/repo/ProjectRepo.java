package com.tushar.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tushar.document.Project;

public interface ProjectRepo extends MongoRepository<Project, String> {

}
