package com.tushar.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class Person implements Serializable {
	
	@Id 														 //to make PK column
	@GeneratedValue(strategy = GenerationType.AUTO) //Incremental
	private Long pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 20)
	private String city;
	@Column
	private double salary;
	@Column
	private int age;
	private LocalDate dob;
	private LocalTime tob;//TIME data type not available in ORACLE, works in MySQL
	private LocalDateTime doj;
	
}
