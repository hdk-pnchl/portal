package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.AddressEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AddressDAO;
import com.draakasheeshah.business.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDAO addressDAO;

	@Override
	public PatientEntity saveWithPatient(AddressEntity address, long patientId) {
		return addressDAO.saveWithPatient(address, patientId);
	}

	@Override
	public AddressEntity save(AddressEntity address, long patientId) {
		return addressDAO.save(address, patientId);
	}

	@Override
	public AddressEntity saveOrUpdate(AddressEntity address) {
		addressDAO.saveOrUpdate(address);
		return address;
	}

	@Override
	public AddressEntity update(AddressEntity address){
		return addressDAO.update(address);
	}

	@Override
	public PatientEntity update(AddressEntity address, long patientId) {
		return addressDAO.update(address, patientId);
	}

	@Override
	public AddressEntity get(long addressId) {
		return addressDAO.get(addressId);
	}

	@Override
	public List<AddressEntity> loadAll() {
		return addressDAO.loadAll();
	}

	@Override
	public void delete(AddressEntity address) {
		addressDAO.delete(address);
	}

	@Override
	public void deletePermanently(AddressEntity address) {
		addressDAO.deletePermanently(address);
	}
}