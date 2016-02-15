package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.PatientDAO;
import com.draakasheeshah.business.service.PatientService;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientDAO patientDAO;

	@Override
	public PatientEntity save(PatientEntity patient) {
		return patientDAO.save(patient);
	}

	@Override
	public PatientEntity saveOrUpdate(PatientEntity patient) {
		patient = patientDAO.saveOrUpdate(patient);
		return patient;
	}

	@Override
	public PatientEntity get(long patientId) {
		return patientDAO.get(patientId);
	}

	@Override
	public PatientEntity getFull(long patientId) {
		return patientDAO.getFull(patientId);
	}

	@Override
	public List<PatientEntity> getAll() {
		return patientDAO.getAll();
	}

	@Override
	public void delete(PatientEntity patient) {
		patientDAO.delete(patient);
	}

	@Override
	public void deletePermanently(PatientEntity patient) {
		patientDAO.deletePermanently(patient);
	}
}