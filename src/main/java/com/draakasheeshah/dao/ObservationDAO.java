package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.ObservationEntity;

public interface ObservationDAO {

	// -----Observation

	ObservationEntity save(ObservationEntity observationEntity, long patientId);

	ObservationEntity saveOrUpdate(ObservationEntity observationEntity);

	ObservationEntity get(long observationId);

	List<ObservationEntity> loadAll();

	void delete(ObservationEntity observationEntity);

	void deletePermanently(ObservationEntity observationEntity);
}
