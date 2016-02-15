package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface BasicDetailDAO {

	// -----basicDetail

	PatientEntity saveWithPatient(BasicDetailEntity basicDetail);

	BasicDetailEntity save(BasicDetailEntity basicDetail, long patientId);

	BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail);

	BasicDetailEntity get(long basicDetailId);

	List<BasicDetailEntity> getAll();

	void delete(BasicDetailEntity basicDetail);

	void deletePermanently(BasicDetailEntity basicDetail);

	BasicDetailEntity update(BasicDetailEntity basicDetail);

	PatientEntity update(BasicDetailEntity basicDetail, long patientId);

}
