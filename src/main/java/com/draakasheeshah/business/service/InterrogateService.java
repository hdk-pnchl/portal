package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.InterrogateEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface InterrogateService {
	// -----Interogate

	PatientEntity saveWithPatient(InterrogateEntity interrogate, long patientId);

	InterrogateEntity save(InterrogateEntity interrogate, long patientId);

	InterrogateEntity saveOrUpdate(InterrogateEntity interrogate);

	InterrogateEntity get(long interrogateId);

	List<InterrogateEntity> loadAll();

	void delete(InterrogateEntity interrogate);

	void deletePermanently(InterrogateEntity interrogate);

	InterrogateEntity update(InterrogateEntity interrogate);
	
	PatientEntity update(InterrogateEntity interrogate, long patientId);

}
