package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.AddressEntity;
import com.draakasheeshah.business.bo.FamilyEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.AddressDAO;

@Repository
@Transactional
public class AddressDAOImpl extends AbstractDAO implements AddressDAO {
	@Override
	public PatientEntity saveWithPatient(AddressEntity address, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			address.setPatient(patient);
			this.getSession().save(address);
		}
		return patient;
	}

	@Override
	public AddressEntity save(AddressEntity address, long patientId) {
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			PatientEntity patient = (PatientEntity) patientObject;
			address.setPatient(patient);
			this.getSession().save(address);
			return address;
		}
		return null;
	}

	@Override
	public AddressEntity update(AddressEntity address) {
		this.getSession().update(address);
		return address;
	}

	@Override
	public PatientEntity update(AddressEntity address, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			patient.setAddress(address);
			address.setPatient(patient);
			this.getSession().merge(patient);
		}
		return patient;
	}
	
	@Override
	public AddressEntity saveOrUpdate(AddressEntity address) {
		this.getSession().saveOrUpdate(address);
		return address;
	}

	@Override
	public AddressEntity get(long addressId) {
		AddressEntity address = null;
		Object patientObject = this.getSession().get(AddressEntity.class, addressId);
		if (patientObject != null) {
			address = (AddressEntity) patientObject;
		}
		return address;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(AddressEntity.class);
		return (List<AddressEntity>) criteria.list();
	}

	@Override
	public void delete(AddressEntity address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePermanently(AddressEntity address) {
		this.getSession().delete(address);
	}
}