package com.tushar.service;

import java.util.List;

import com.tushar.entity.Vaccines;

public interface iServiceVaccineMgmt {
	
	public List<Vaccines> search_findAll_exampl_sort(Vaccines v, Boolean isAsc, String...properties);
	public Vaccines search_getById_id(Long vid);
	public String delete_deleteAllByIdInBatch_longIds(Iterable<Long>ids);

}
