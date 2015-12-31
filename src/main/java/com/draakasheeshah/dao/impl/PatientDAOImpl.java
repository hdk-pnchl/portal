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
	public PatientEntity save(PatientEntity patient) {
		hibernateTemplate.save(patient);
		return patient;
	}

	@Override
	public PatientEntity saveOrUpdate(PatientEntity patient) {
		hibernateTemplate.saveOrUpdate(patient);
		//patient= hibernateTemplate.merge(patient);
		return patient;
	}

	@Override
	public PatientEntity get(long patientId) {
		PatientEntity patientEntity = hibernateTemplate.get(PatientEntity.class, patientId);
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

	@Override
	public List<PatientEntity> getAll() {
		return hibernateTemplate.loadAll(PatientEntity.class);
	}

	@Override
	public void delete(PatientEntity patient) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(PatientEntity patient) {
		hibernateTemplate.delete(patient);
	}
}
