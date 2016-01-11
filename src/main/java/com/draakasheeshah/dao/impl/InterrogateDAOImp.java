package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.InterrogateEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.InterrogateDAO;

@Repository
public class InterrogateDAOImp implements InterrogateDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public PatientEntity saveWithPatient(InterrogateEntity interrogate, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		interrogate.setPatient(patient);
		hibernateTemplate.saveOrUpdate(interrogate);
		return patient;
	}
	
	@Override
	public InterrogateEntity save(InterrogateEntity interrogate, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		interrogate.setPatient(patient);
		hibernateTemplate.saveOrUpdate(interrogate);
		return interrogate;
	}

	@Override
	public InterrogateEntity saveOrUpdate(InterrogateEntity interrogate) {
		hibernateTemplate.saveOrUpdate(interrogate);
		return interrogate;
	}

	@Override
	public InterrogateEntity get(long interrogateId) {
		return hibernateTemplate.get(InterrogateEntity.class, interrogateId);
	}

	@Override
	public List<InterrogateEntity> loadAll() {
		return hibernateTemplate.loadAll(InterrogateEntity.class);
	}

	@Override
	public void delete(InterrogateEntity interrogate) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(InterrogateEntity interrogate) {
		hibernateTemplate.delete(interrogate);
	}
}