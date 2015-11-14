package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.PatientDAO;
import com.draakasheeshah.service.PatientService;

@Service
public class PatientServiceImpl
    implements PatientService
{
    @Autowired
    PatientDAO patientDAO;

    @Override
    public PatientEntity savePatient(PatientEntity patient) {
        return patientDAO.savePatient(patient);
    }

    @Override
    public void saveOrUpdatePatient(PatientEntity patient) {
        patientDAO.saveOrUpdatePatient(patient);
    }

    @Override
    public PatientEntity getPatient(long patientId) {
        return patientDAO.getPatient(patientId);
    }

    @Override
    public List<PatientEntity> loadAllPatient() {
        return patientDAO.loadAllPatient();
    }

    @Override
    public void deletePatient(PatientEntity patient) {
        patientDAO.deletePatient(patient);
    }

    @Override
    public void deletePatientPermanently(PatientEntity patient) {
        patientDAO.deletePatientPermanently(patient);
    }
}