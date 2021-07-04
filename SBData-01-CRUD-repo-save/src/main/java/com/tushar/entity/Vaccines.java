package com.tushar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Vaccines implements Serializable {
	
	@Id 														 //to make PK column
	@GeneratedValue(strategy = GenerationType.AUTO) //Increemental
	private Long vid;
	@Column(length = 20)
	private String vname;
	@Column(length = 20)
	private String manufacturer;
	private double price;
	private int doseCount;
	
}
