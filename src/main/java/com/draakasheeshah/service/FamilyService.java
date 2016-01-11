package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.FamilyEntity;
import com.draakasheeshah.bo.PatientEntity;

public interface FamilyService {

	public PatientEntity saveWithPatient(FamilyEntity family, long patientId);

	FamilyEntity save(FamilyEntity family, long patientId);

	FamilyEntity saveOrUpdate(FamilyEntity family);

	FamilyEntity get(long familyId);

	List<FamilyEntity> loadAll();

	void delete(FamilyEntity family);

	void deletePermanently(FamilyEntity family);

}
