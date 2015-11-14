package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.PatientEntity;

public interface PatientDAO {

    // -----Patient

    PatientEntity savePatient(PatientEntity patient);

    void saveOrUpdatePatient(PatientEntity patient);

    PatientEntity getPatient(long patientId);

    List<PatientEntity> loadAllPatient();

    void deletePatient(PatientEntity patient);

    void deletePatientPermanently(PatientEntity patient);
}
