package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.InterrogateEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.InterrogateDAO;
import com.draakasheeshah.service.InterrogateService;

@Service
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