package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.AddressEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface AddressDAO {

	// -----Address

	AddressEntity saveOrUpdate(AddressEntity address);

	AddressEntity get(long addressId);

	List<AddressEntity> loadAll();

	void delete(AddressEntity address);

	void deletePermanently(AddressEntity address);

	AddressEntity save(AddressEntity address, long patentId);

	PatientEntity saveWithPatient(AddressEntity address, long patientId);
}
