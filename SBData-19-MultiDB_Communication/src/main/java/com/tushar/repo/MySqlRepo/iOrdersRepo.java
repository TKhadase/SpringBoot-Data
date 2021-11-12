package com.tushar.repo.MySqlRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.model.mysql.Orders;

public interface iOrdersRepo extends JpaRepository<Orders, Integer> {

}
