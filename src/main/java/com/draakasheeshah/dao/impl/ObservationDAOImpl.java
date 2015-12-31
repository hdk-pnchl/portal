package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.ObservationEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.ObservationDAO;

@Repository
public class ObservationDAOImpl implements ObservationDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public ObservationEntity save(ObservationEntity observation, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		observation.setPatient(patient);
		hibernateTemplate.saveOrUpdate(observation);
		return observation;
	}

	@Override
	public ObservationEntity saveOrUpdate(ObservationEntity observation) {
		hibernateTemplate.save(observation);
		return observation;
	}

	@Override
	public ObservationEntity get(long observationId) {
		return hibernateTemplate.get(ObservationEntity.class, observationId);
	}

	@Override
	public List<ObservationEntity> loadAll() {
		return hibernateTemplate.loadAll(ObservationEntity.class);
	}

	@Override
	public void delete(ObservationEntity observationEntity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(ObservationEntity observationEntity) {
		hibernateTemplate.delete(observationEntity);
	}
}