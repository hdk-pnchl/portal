package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.AddressEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.AddressDAO;

@Repository
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public PatientEntity saveWithPatient(AddressEntity address, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		address.setPatient(patient);
		hibernateTemplate.saveOrUpdate(address);
		return patient;
	}
	@Override
	public AddressEntity save(AddressEntity address, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		address.setPatient(patient);
		hibernateTemplate.saveOrUpdate(address);
		return address;
	}

	@Override
	public AddressEntity saveOrUpdate(AddressEntity address) {
		hibernateTemplate.save(address);
		return address;
	}

	@Override
	public AddressEntity get(long addressId) {
		return hibernateTemplate.get(AddressEntity.class, addressId);
	}

	@Override
	public List<AddressEntity> loadAll() {
		return hibernateTemplate.loadAll(AddressEntity.class);
	}

	@Override
	public void delete(AddressEntity address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePermanently(AddressEntity address) {
		hibernateTemplate.delete(address);
	}
}