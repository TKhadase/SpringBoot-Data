package com.tushar.document;

import java.io.Serializable;

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
public class Project implements Serializable {
	
	@Id
	private String _id;
	
	@NonNull
	private Integer pno;
	
	@NonNull
	private String name;
	
	@NonNull
	private String client;
	
	@NonNull
	private Double cost;
	
	@NonNull
	private String roll;
	
	@NonNull
	private String domain;

	@Override
	public String toString() {
		return "Project [_id=" + _id + ", pno=" + pno + ", name=" + name + ", client=" + client + ", cost=" + cost
				+ ", roll=" + roll + ", domain=" + domain + "]";
	}
	
}
