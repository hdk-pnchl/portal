package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.ObservationDAO;

@Repository
@Transactional
public class ObservationDAOImpl extends AbstractDAO implements ObservationDAO {
	@Override
	public PatientEntity saveWithPatient(ObservationEntity observation, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			observation.setPatient(patient);
			this.getSession().save(observation);
		}
		return patient;
	}

	@Override
	public ObservationEntity save(ObservationEntity observation, long patientId) {
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			PatientEntity patient = (PatientEntity) patientObject;
			observation.setPatient(patient);
			this.getSession().save(observation);
		}
		return observation;
	}

	@Override
	public ObservationEntity update(ObservationEntity observation) {
		this.getSession().update(observation);
		return observation;
	}

	@Override
	public PatientEntity update(ObservationEntity observation, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			patient.setObservation(observation);
			observation.setPatient(patient);
			this.getSession().merge(patient);
		}
		return patient;
	}
	
	@Override
	public ObservationEntity saveOrUpdate(ObservationEntity observation) {
		this.getSession().saveOrUpdate(observation);
		return observation;
	}

	@Override
	public ObservationEntity get(long observationId) {
		ObservationEntity observation = null;
		Object patientObject = this.getSession().get(ObservationEntity.class, observationId);
		if (patientObject != null) {
			observation = (ObservationEntity) patientObject;
		}
		return observation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ObservationEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(ObservationEntity.class);
		return (List<ObservationEntity>) criteria.list();
	}

	@Override
	public void delete(ObservationEntity observationEntity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(ObservationEntity observationEntity) {
		this.getSession().delete(observationEntity);
	}
}