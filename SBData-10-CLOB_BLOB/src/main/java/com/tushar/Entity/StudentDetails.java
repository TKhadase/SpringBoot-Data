package com.tushar.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SID;
	
	@NonNull
	private String SNAME;
	@NonNull
	@Lob
	private byte[] PHOTO;
	@NonNull
	@Lob
	private char[] RESUME;
	
}
