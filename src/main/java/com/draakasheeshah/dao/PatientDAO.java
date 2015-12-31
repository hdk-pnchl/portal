package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.PatientEntity;

public interface PatientDAO {

    // -----Patient

    PatientEntity save(PatientEntity patient);

    PatientEntity saveOrUpdate(PatientEntity patient);

    PatientEntity get(long patientId);

    List<PatientEntity> getAll();

    void delete(PatientEntity patient);

    void deletePermanently(PatientEntity patient);

	PatientEntity getFull(long patientId);
}
