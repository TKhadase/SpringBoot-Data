package com.tushar.document;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	private String _id;
	
	@NonNull
	private int eno;
	
	@NonNull
	private String name;
	
	@NonNull
	private String addrs;
	
	@NonNull
	private double salary;
	
	@NonNull
	private long contact;

	private Set<Long> homeNumber;
	
	private List<String> nickNames;
	
	private Map<String, String> family;

	private Properties techProps;
	
	private String[] hobby;

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", eno=" + eno + ", name=" + name + ", addrs=" + addrs + ", salary=" + salary
				+ ", contact=" + contact + ", homeNumber=" + homeNumber + ", nickNames=" + nickNames + ", family="
				+ family + ", techProps=" + techProps + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
	
	
}
