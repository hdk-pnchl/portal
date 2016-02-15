package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.InterrogateEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.InterrogateDAO;
import com.draakasheeshah.business.service.InterrogateService;

@Service
@Transactional
public class InterrogateServiceImpl implements InterrogateService {
	@Autowired
	InterrogateDAO interrogateDAO;

	@Override
	public PatientEntity saveWithPatient(InterrogateEntity interrogate, long patientId) {
		return interrogateDAO.saveWithPatient(interrogate, patientId);
	}

	@Override
	public InterrogateEntity save(InterrogateEntity interrogate, long patientId) {
		return interrogateDAO.save(interrogate, patientId);
	}

	@Override
	public InterrogateEntity saveOrUpdate(InterrogateEntity interrogate) {
		interrogate = interrogateDAO.saveOrUpdate(interrogate);
		return interrogate;
	}

	@Override
	public InterrogateEntity update(InterrogateEntity interrogate) {
		interrogate = interrogateDAO.update(interrogate);
		return interrogate;
	}
	
	@Override
	public PatientEntity update(InterrogateEntity interrogate, long patientId){
		PatientEntity patient = interrogateDAO.update(interrogate, patientId);
		return patient;
	}
	
	@Override
	public InterrogateEntity get(long interrogateId) {
		return interrogateDAO.get(interrogateId);
	}

	@Override
	public List<InterrogateEntity> loadAll() {
		return interrogateDAO.loadAll();
	}

	@Override
	public void delete(InterrogateEntity interrogate) {
		interrogateDAO.delete(interrogate);
	}

	@Override
	public void deletePermanently(InterrogateEntity interrogate) {
		interrogateDAO.deletePermanently(interrogate);
	}
}