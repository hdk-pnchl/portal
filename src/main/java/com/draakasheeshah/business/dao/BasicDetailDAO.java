package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.util.SearchInput;

public interface BasicDetailDAO {

	// -----basicDetail

	PatientEntity saveWithPatient(BasicDetailEntity basicDetail);

	BasicDetailEntity save(BasicDetailEntity basicDetail, long patientId);

	BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail);

	BasicDetailEntity get(long basicDetailId);

	List<BasicDetailEntity> loadAll();

	void delete(BasicDetailEntity basicDetail);

	void deletePermanently(BasicDetailEntity basicDetail);

	BasicDetailEntity update(BasicDetailEntity basicDetail);

	PatientEntity update(BasicDetailEntity basicDetail, long patientId);

	BasicDetailEntity get(String emailId);

	List<BasicDetailEntity> loadAll(SearchInput searchInput);

	Long getTotalRowCount(SearchInput searchInput);

}
