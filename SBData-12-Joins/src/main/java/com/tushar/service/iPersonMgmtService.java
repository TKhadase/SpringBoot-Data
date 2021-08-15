package com.tushar.service;

import java.util.List;

public interface iPersonMgmtService {
	
	public List<Object[]> getPerson_Full_JOIN_ContactDetails();
	public List<Object[]> getPerson_Inner_JOIN_ContactDetails();
	public List<Object[]> getPerson_Right_JOIN_ContactDetails();
	public List<Object[]> getPerson_Left_JOIN_ContactDetails();
	
}