package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.ObservationDAO;
import com.draakasheeshah.business.service.ObservationService;

@Service
@Transactional
public class ObservationServiceImpl implements ObservationService {
	@Autowired
	ObservationDAO observationDAO;

	@Override
	public PatientEntity saveWithPatient(ObservationEntity observation, long patientId) {
		return observationDAO.saveWithPatient(observation, patientId);
	}

	@Override
	public ObservationEntity save(ObservationEntity observationEntity, long patientId) {
		return observationDAO.save(observationEntity, patientId);
	}

	@Override
	public ObservationEntity saveOrUpdate(ObservationEntity observationEntity) {
		observationEntity = observationDAO.saveOrUpdate(observationEntity);
		return observationEntity;
	}

	@Override
	public ObservationEntity update(ObservationEntity observationEntity) {
		observationEntity = observationDAO.update(observationEntity);
		return observationEntity;
	}

	@Override
	public PatientEntity update(ObservationEntity observationEntity, long patientId) {
		PatientEntity patient = observationDAO.update(observationEntity, patientId);
		return patient;
	}

	
	@Override
	public ObservationEntity get(long observationId) {
		return observationDAO.get(observationId);
	}

	@Override
	public List<ObservationEntity> loadAll() {
		return observationDAO.loadAll();
	}

	@Override
	public void delete(ObservationEntity observationEntity) {
		observationDAO.delete(observationEntity);
	}

	@Override
	public void deletePermanently(ObservationEntity observationEntity) {
		observationDAO.deletePermanently(observationEntity);
	}
}