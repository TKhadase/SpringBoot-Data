package com.tushar.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor	
@RequiredArgsConstructor
@Entity
public class Person  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@NonNull
	private String fName;
	@NonNull
	private String lName;
	@NonNull
	private String addrs;
	
	@OneToMany(targetEntity =ContactDetails.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn(name = "pid", referencedColumnName = "pid")
	private Set<ContactDetails> numbers;
	
	public Person()
	{
		System.out.println("Person ::"+this.hashCode());
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", fName=" + fName + ", lName=" + lName + ", addrs=" + addrs + "]";
	}
	
	
}
