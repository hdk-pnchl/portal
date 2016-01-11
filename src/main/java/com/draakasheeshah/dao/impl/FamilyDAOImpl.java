package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.FamilyEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.FamilyDAO;

@Repository
public class FamilyDAOImpl implements FamilyDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public PatientEntity saveWithPatient(FamilyEntity family, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		family.setPatient(patient);
		hibernateTemplate.saveOrUpdate(family);
		return patient;
	}

	@Override
	public FamilyEntity save(FamilyEntity family, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		family.setPatient(patient);
		hibernateTemplate.saveOrUpdate(family);
		return family;
	}

	@Override
	public FamilyEntity saveOrUpdate(FamilyEntity family) {
		hibernateTemplate.saveOrUpdate(family);
		return family;
	}

	@Override
	public FamilyEntity get(long familyId) {
		return hibernateTemplate.get(FamilyEntity.class, familyId);
	}

	@Override
	public List<FamilyEntity> loadAll() {
		return hibernateTemplate.loadAll(FamilyEntity.class);
	}

	@Override
	public void delete(FamilyEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(FamilyEntity family) {
		hibernateTemplate.delete(family);
	}

}
