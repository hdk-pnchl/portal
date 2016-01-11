package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.FamilyEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.FamilyDAO;
import com.draakasheeshah.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService {
	@Autowired
	FamilyDAO familyDAO;

	@Override
	public PatientEntity saveWithPatient(FamilyEntity family, long patientId) {
		return familyDAO.saveWithPatient(family, patientId);
	}

	@Override
	public FamilyEntity save(FamilyEntity family, long patientId) {
		return familyDAO.save(family, patientId);
	}

	@Override
	public FamilyEntity saveOrUpdate(FamilyEntity family) {
		family = familyDAO.saveOrUpdate(family);
		return family;
	}

	@Override
	public FamilyEntity get(long familyId) {
		return familyDAO.get(familyId);
	}

	@Override
	public List<FamilyEntity> loadAll() {
		return familyDAO.loadAll();
	}

	@Override
	public void delete(FamilyEntity family) {
		familyDAO.delete(family);
	}

	@Override
	public void deletePermanently(FamilyEntity family) {
		familyDAO.deletePermanently(family);
	}
}