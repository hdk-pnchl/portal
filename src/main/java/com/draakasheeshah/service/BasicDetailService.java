package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.BasicDetailEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface BasicDetailService {
	PatientEntity saveWithPatient(BasicDetailEntity basicDetail);

	BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail);

	BasicDetailEntity get(long basicDetailId);

	List<BasicDetailEntity> getAll();

	void delete(BasicDetailEntity basicDetail);

	void deletePermanently(BasicDetailEntity basicDetail);

	BasicDetailEntity save(BasicDetailEntity basicDetail, long basicDetailId);

}
