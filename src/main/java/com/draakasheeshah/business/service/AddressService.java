package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.AddressEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface AddressService {

	PatientEntity saveWithPatient(AddressEntity address, long patientId);

	AddressEntity saveOrUpdate(AddressEntity address);

	AddressEntity get(long addressId);

	List<AddressEntity> loadAll();

	void delete(AddressEntity address);

	void deletePermanently(AddressEntity address);

	AddressEntity save(AddressEntity address, long patientId);

	AddressEntity update(AddressEntity address);
	
	PatientEntity update(AddressEntity address, long patientId);


}
