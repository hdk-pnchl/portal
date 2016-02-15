package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.FamilyEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface FamilyService {

	public PatientEntity saveWithPatient(FamilyEntity family, long patientId);

	FamilyEntity save(FamilyEntity family, long patientId);

	FamilyEntity saveOrUpdate(FamilyEntity family);

	FamilyEntity get(long familyId);

	List<FamilyEntity> loadAll();

	void delete(FamilyEntity family);

	void deletePermanently(FamilyEntity family);

	FamilyEntity update(FamilyEntity family);

	PatientEntity update(FamilyEntity family, long patientId);

}
