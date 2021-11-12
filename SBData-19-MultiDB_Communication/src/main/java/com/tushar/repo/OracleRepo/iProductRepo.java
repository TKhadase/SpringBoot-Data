package com.tushar.repo.OracleRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.model.oracle.Product;

public interface iProductRepo extends JpaRepository<Product, Integer> {

}
