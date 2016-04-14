package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.PatientEntity;

public interface PatientService {
    PatientEntity save(PatientEntity patient);

    PatientEntity update(PatientEntity patient);

    PatientEntity get(long patientId);

    List<PatientEntity> getAll();

    void delete(PatientEntity patient);

    void deletePermanently(PatientEntity patient);

	PatientEntity getFull(long patientId);
}
