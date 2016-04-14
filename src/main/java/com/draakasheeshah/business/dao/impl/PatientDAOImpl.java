package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.PatientDAO;

@Repository
@Transactional
public class PatientDAOImpl extends AbstractDAO implements PatientDAO {
	@Override
	public PatientEntity save(PatientEntity patient) {
		this.getSession().save(patient);
		return patient;
	}

	@Override
	public PatientEntity update(PatientEntity patient) {
		this.getSession().update(patient);
		return patient;
	}

	@Override
	public PatientEntity get(long patientId) {
		PatientEntity patientEntity = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patientEntity = (PatientEntity) patientObject;
		}
		return patientEntity;
	}

	@Override
	public PatientEntity getFull(long patientId) {
		PatientEntity patientEntity = this.get(patientId);
		patientEntity.getAddress();
		patientEntity.getFamily();
		patientEntity.getInterrogate();
		patientEntity.getObservation();
		return patientEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(PatientEntity.class);
		return (List<PatientEntity>) criteria.list();
	}

	@Override
	public void delete(PatientEntity patient) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(PatientEntity patient) {
		this.getSession().delete(patient);
	}
}