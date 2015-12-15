package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.PatientEntity;

public interface PatientService {
    PatientEntity savePatient(PatientEntity patient);

    void saveOrUpdatePatient(PatientEntity patient);

    PatientEntity getPatient(long patientId);

    List<PatientEntity> getAllPatients();

    void deletePatient(PatientEntity patient);

    void deletePatientPermanently(PatientEntity patient);

	PatientEntity getFullPatient(long patientId);
}
