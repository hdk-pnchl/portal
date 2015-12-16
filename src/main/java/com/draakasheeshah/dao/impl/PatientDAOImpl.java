package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.PatientDAO;

@Repository
@Transactional(readOnly = false)
public class PatientDAOImpl implements PatientDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public PatientEntity savePatient(PatientEntity patient) {
		hibernateTemplate.save(patient);
		return patient;
	}

	@Override
	public PatientEntity saveOrUpdatePatient(PatientEntity patient) {
		patient= hibernateTemplate.merge(patient);
		hibernateTemplate.saveOrUpdate(patient);
		return patient;
	}

	@Override
	public PatientEntity getPatient(long patientId) {
		PatientEntity patientEntity = hibernateTemplate.get(PatientEntity.class, patientId);
		return patientEntity;
	}

	@Override
	public PatientEntity getFullPatient(long patientId) {
		PatientEntity patientEntity = this.getPatient(patientId);
		patientEntity.getAddress();
		patientEntity.getFamily();
		patientEntity.getInterrogate();
		patientEntity.getObservation();
		return patientEntity;
	}

	@Override
	public List<PatientEntity> getAllPatients() {
		return hibernateTemplate.loadAll(PatientEntity.class);
	}

	@Override
	public void deletePatient(PatientEntity patient) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePatientPermanently(PatientEntity patient) {
		hibernateTemplate.delete(patient);
	}
}
