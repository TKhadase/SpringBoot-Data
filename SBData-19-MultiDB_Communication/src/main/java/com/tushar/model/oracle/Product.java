package com.tushar.model.oracle;

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

@Table(name="PROD_SB")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@NonNull
	private String prodname;
	
	@NonNull
	private Double price;
	
	@NonNull
	private int qty;
	
	@NonNull
	private LocalDate expdate;
	
}
