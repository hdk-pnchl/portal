package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.AddressEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface AddressService {

	PatientEntity saveWithPatient(AddressEntity address, long patientId);

	AddressEntity saveOrUpdate(AddressEntity address);

	AddressEntity get(long addressId);

	List<AddressEntity> loadAll();

	void delete(AddressEntity address);

	void deletePermanently(AddressEntity address);

	AddressEntity save(AddressEntity address, long patientId);

}
