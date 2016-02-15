package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.FamilyEntity;
import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.FamilyDAO;

@Repository
@Transactional
public class FamilyDAOImpl extends AbstractDAO implements FamilyDAO {
	@Override
	public PatientEntity saveWithPatient(FamilyEntity family, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			family.setPatient(patient);
			this.getSession().save(family);
		}
		return patient;
	}

	@Override
	public FamilyEntity save(FamilyEntity family, long patientId) {
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			PatientEntity patient = (PatientEntity) patientObject;
			family.setPatient(patient);
			this.getSession().save(family);
			return family;
		}
		return null;
	}

	@Override
	public FamilyEntity update(FamilyEntity family) {
		this.getSession().update(family);
		return family;
	}

	@Override
	public PatientEntity update(FamilyEntity family, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			patient.setFamily(family);
			family.setPatient(patient);
			this.getSession().merge(patient);
		}
		return patient;
	}

	@Override
	public FamilyEntity saveOrUpdate(FamilyEntity family) {
		this.getSession().saveOrUpdate(family);
		return family;
	}

	@Override
	public FamilyEntity get(long familyId) {
		FamilyEntity family = null;
		Object patientObject = this.getSession().get(FamilyEntity.class, familyId);
		if (patientObject != null) {
			family = (FamilyEntity) patientObject;
		}
		return family;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FamilyEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(FamilyEntity.class);
		return (List<FamilyEntity>) criteria.list();
	}

	@Override
	public void delete(FamilyEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(FamilyEntity family) {
		this.getSession().delete(family);
	}
}