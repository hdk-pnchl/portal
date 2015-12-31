package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.AddressEntity;

public interface AddressDAO {

	// -----Address

	AddressEntity saveOrUpdate(AddressEntity address);

	AddressEntity get(long addressId);

	List<AddressEntity> loadAll();

	void delete(AddressEntity address);

	void deletePermanently(AddressEntity address);

	AddressEntity save(AddressEntity address, long patentId);
}
