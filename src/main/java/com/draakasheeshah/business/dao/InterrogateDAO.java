package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.InterrogateEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface InterrogateDAO {

	// -----Interogate

	InterrogateEntity save(InterrogateEntity interrogate, long patientId);

	InterrogateEntity saveOrUpdate(InterrogateEntity interrogate);

	InterrogateEntity get(long interrogateId);

	List<InterrogateEntity> loadAll();

	void delete(InterrogateEntity interrogate);

	void deletePermanently(InterrogateEntity interrogate);

	PatientEntity saveWithPatient(InterrogateEntity observation, long patientId);

	InterrogateEntity update(InterrogateEntity interrogate);

	PatientEntity update(InterrogateEntity interrogate, long patientId);
}
