package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.InterrogateEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface InterrogateService {
	// -----Interogate

	PatientEntity saveWithPatient(InterrogateEntity interrogate, long patientId);

	InterrogateEntity save(InterrogateEntity interrogate, long patientId);

	InterrogateEntity saveOrUpdate(InterrogateEntity interrogate);

	InterrogateEntity get(long interrogateId);

	List<InterrogateEntity> loadAll();

	void delete(InterrogateEntity interrogate);

	void deletePermanently(InterrogateEntity interrogate);

}
