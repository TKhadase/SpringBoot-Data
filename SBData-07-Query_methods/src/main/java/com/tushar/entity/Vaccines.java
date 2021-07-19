package com.tushar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vaccines implements Serializable {
	
	@Id 														 //to make PK column
	@GeneratedValue(strategy = GenerationType.AUTO) //Incremental
	private Long vid;
	@Column(length = 20)
	private String vname;
	@Column(length = 20)
	private String manufacturer;
	@Column
	private double price;
	@Column
	private int doseCount;
	
}
