package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.FamilyEntity;

public interface FamilyService {
	FamilyEntity save(FamilyEntity  address, long patientId);

	FamilyEntity saveOrUpdate(FamilyEntity family);

	FamilyEntity get(long familyId);

	List<FamilyEntity> loadAll();

	void delete(FamilyEntity family);

	void deletePermanently(FamilyEntity family);

}
