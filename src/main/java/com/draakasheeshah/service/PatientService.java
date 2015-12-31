package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.PatientEntity;

public interface PatientService {
    PatientEntity save(PatientEntity patient);

    PatientEntity saveOrUpdate(PatientEntity patient);

    PatientEntity get(long patientId);

    List<PatientEntity> getAll();

    void delete(PatientEntity patient);

    void deletePermanently(PatientEntity patient);

	PatientEntity getFull(long patientId);
}
