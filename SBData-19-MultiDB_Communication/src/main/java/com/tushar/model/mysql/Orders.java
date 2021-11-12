package com.tushar.model.mysql;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="ORDERS_SB")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Orders implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	
	@NonNull
	private String custid;
	
	@NonNull
	private Double billAmt;
	
	@NonNull
	private String addrs;
	
	@NonNull
	private LocalDate orderdate;
	
}
