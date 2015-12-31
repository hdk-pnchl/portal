package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.ObservationEntity;
import com.draakasheeshah.dao.ObservationDAO;
import com.draakasheeshah.service.ObservationService;

@Service
public class ObservationServiceImpl implements ObservationService {
	@Autowired
	ObservationDAO observationDAO;

	@Override
	public ObservationEntity save(ObservationEntity  observationEntity, long patientId) {
		return observationDAO.save(observationEntity, patientId);
	}

	@Override
	public ObservationEntity saveOrUpdate(ObservationEntity observationEntity) {
		observationEntity = observationDAO.saveOrUpdate(observationEntity);
		return observationEntity;
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