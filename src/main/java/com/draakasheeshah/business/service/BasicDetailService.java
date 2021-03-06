package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.util.SearchInput;

public interface BasicDetailService {
	PatientEntity saveWithPatient(BasicDetailEntity basicDetail);

	BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail);

	BasicDetailEntity get(long basicDetailId);

	List<BasicDetailEntity> getAll();

	void delete(BasicDetailEntity basicDetail);

	void deletePermanently(BasicDetailEntity basicDetail);

	BasicDetailEntity save(BasicDetailEntity basicDetail, long basicDetailId);

	BasicDetailEntity update(BasicDetailEntity basicDetail);

	PatientEntity update(BasicDetailEntity basicDetail, long basicDetailId);

	BasicDetailEntity get(String emailId);

	List<BasicDetailEntity> getAll(SearchInput searchInput);

	Long getTotalRowCount(SearchInput searchInput);

}
