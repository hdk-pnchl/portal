package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.PatientEntity;

public interface PatientDAO {

    // -----Patient

    PatientEntity save(PatientEntity patient);

    PatientEntity update(PatientEntity patient);

    PatientEntity get(long patientId);

    List<PatientEntity> loadAll();

    void delete(PatientEntity patient);

    void deletePermanently(PatientEntity patient);

	PatientEntity getFull(long patientId);
}
