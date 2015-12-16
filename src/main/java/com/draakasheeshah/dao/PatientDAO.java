package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.PatientEntity;

public interface PatientDAO {

    // -----Patient

    PatientEntity savePatient(PatientEntity patient);

    PatientEntity saveOrUpdatePatient(PatientEntity patient);

    PatientEntity getPatient(long patientId);

    List<PatientEntity> getAllPatients();

    void deletePatient(PatientEntity patient);

    void deletePatientPermanently(PatientEntity patient);

	PatientEntity getFullPatient(long patientId);
}
