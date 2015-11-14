package com.draakasheeshah.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.PatientDAO;

@Repository
@Transactional(readOnly = false)
public class PatientDAOImpl
    implements PatientDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public PatientEntity savePatient(PatientEntity patient) {
        hibernateTemplate.save(patient);
        return patient;
    }

    @Override
    public void saveOrUpdatePatient(PatientEntity patient) {
        hibernateTemplate.saveOrUpdate(patient);
    }

    @Override
    public PatientEntity getPatient(long patientId) {
        return hibernateTemplate.get(PatientEntity.class, patientId);
    }

    @Override
    public List<PatientEntity> loadAllPatient() {
        return hibernateTemplate.loadAll(PatientEntity.class);
    }

    @Override
    public void deletePatient(PatientEntity patient) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deletePatientPermanently(PatientEntity patient) {
        hibernateTemplate.delete(patient);
    }
}
