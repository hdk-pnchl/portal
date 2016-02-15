package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.InterrogateEntity;
import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.InterrogateDAO;

@Repository
@Transactional
public class InterrogateDAOImp extends AbstractDAO implements InterrogateDAO {
	@Override
	public PatientEntity saveWithPatient(InterrogateEntity interrogate, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			interrogate.setPatient(patient);
			this.getSession().save(interrogate);
		}
		return patient;
	}

	@Override
	public InterrogateEntity save(InterrogateEntity interrogate, long patientId) {
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			PatientEntity patient = (PatientEntity) patientObject;
			interrogate.setPatient(patient);
			this.getSession().saveOrUpdate(interrogate);
		}
		return interrogate;
	}

	@Override
	public InterrogateEntity update(InterrogateEntity interrogate) {
		this.getSession().update(interrogate);
		return interrogate;
	}
	
	@Override
	public PatientEntity update(InterrogateEntity interrogate, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			patient.setInterrogate(interrogate);
			interrogate.setPatient(patient);
			this.getSession().merge(patient);
		}
		return patient;
	}
	
	@Override
	public InterrogateEntity saveOrUpdate(InterrogateEntity interrogate) {
		this.getSession().saveOrUpdate(interrogate);
		return interrogate;
	}

	@Override
	public InterrogateEntity get(long interrogateId) {
		InterrogateEntity interrogate = null;
		Object patientObject = this.getSession().get(InterrogateEntity.class, interrogateId);
		if (patientObject != null) {
			interrogate = (InterrogateEntity) patientObject;
		}
		return interrogate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InterrogateEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(InterrogateEntity.class);
		return (List<InterrogateEntity>) criteria.list();
	}

	@Override
	public void delete(InterrogateEntity interrogate) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(InterrogateEntity interrogate) {
		this.getSession().delete(interrogate);
	}
}