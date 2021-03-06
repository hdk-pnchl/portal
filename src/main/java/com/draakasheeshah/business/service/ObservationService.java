package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface ObservationService {
	// -----Observation

	public PatientEntity saveWithPatient(ObservationEntity observation, long patientId);

	ObservationEntity save(ObservationEntity observation, long patientId);

	ObservationEntity saveOrUpdate(ObservationEntity observation);

	ObservationEntity get(long observationId);

	List<ObservationEntity> loadAll();

	void delete(ObservationEntity observation);

	void deletePermanently(ObservationEntity observation);

	ObservationEntity update(ObservationEntity observationEntity);

	PatientEntity update(ObservationEntity observationEntity, long patientId);

}
