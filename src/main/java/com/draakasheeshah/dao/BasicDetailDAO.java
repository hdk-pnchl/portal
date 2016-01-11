package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.BasicDetailEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface BasicDetailDAO {

	// -----basicDetail

	PatientEntity saveWithPatient(BasicDetailEntity basicDetail);

	BasicDetailEntity save(BasicDetailEntity basicDetail, long patientId);

	BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail);

	BasicDetailEntity get(long basicDetailId);

	List<BasicDetailEntity> getAll();

	void delete(BasicDetailEntity basicDetail);

	void deletePermanently(BasicDetailEntity basicDetail);

}
