package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.bo.BasicDetailEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.BasicDetailDAO;

@Repository
@Transactional(readOnly = false)
public class BasicDetailDAOImpl implements BasicDetailDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public PatientEntity saveWithPatient(BasicDetailEntity basicDetail) {
		hibernateTemplate.save(basicDetail);

		PatientEntity patient = new PatientEntity();
		patient.setBasicDetail(basicDetail);
		hibernateTemplate.save(patient);
		
		basicDetail.setPatient(patient);
		hibernateTemplate.saveOrUpdate(basicDetail);
		
		return patient;
	}

	@Override
	public BasicDetailEntity save(BasicDetailEntity basicDetail, long patientId) {
		PatientEntity patient = hibernateTemplate.get(PatientEntity.class, patientId);
		basicDetail.setPatient(patient);
		hibernateTemplate.saveOrUpdate(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail) {
		hibernateTemplate.saveOrUpdate(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity get(long basicDetailId) {
		BasicDetailEntity basicDetail = hibernateTemplate.get(BasicDetailEntity.class, basicDetailId);
		return basicDetail;
	}

	@Override
	public List<BasicDetailEntity> getAll() {
		return hibernateTemplate.loadAll(BasicDetailEntity.class);
	}

	@Override
	public void delete(BasicDetailEntity basicDetail) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(BasicDetailEntity basicDetail) {
		hibernateTemplate.delete(basicDetail);
	}
}