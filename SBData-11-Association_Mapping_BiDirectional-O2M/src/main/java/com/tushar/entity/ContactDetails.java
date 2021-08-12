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
import javax.persistence.ManyToOne;


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
public class ContactDetails  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	@NonNull
	private String numType;
	@NonNull
	private String provider;
	@NonNull
	private String mobileNumber;
	
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", referencedColumnName = "pid")
	private Person person;
	
	public ContactDetails(){
		System.out.println("ContactDetails ::"+this.hashCode());
	}

	@Override
	public String toString() {
		return "ContactDetails [cid=" + cid + ", numType=" + numType + ", provider=" + provider + ", mobileNumber=" + mobileNumber
				+ "]";
	}

	
}
