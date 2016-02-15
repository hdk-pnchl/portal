package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.FamilyEntity;
import com.draakasheeshah.business.bo.PatientEntity;

public interface FamilyDAO {

	// -----Family

	FamilyEntity save(FamilyEntity family, long patientId);

	FamilyEntity saveOrUpdate(FamilyEntity family);

	FamilyEntity get(long familyId);

	List<FamilyEntity> loadAll();

	void delete(FamilyEntity family);

	void deletePermanently(FamilyEntity family);

	PatientEntity saveWithPatient(FamilyEntity family, long patientId);

	FamilyEntity update(FamilyEntity family);

	PatientEntity update(FamilyEntity family, long patientId);

}
