package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.BasicDetailDAO;

@Repository
@Transactional
public class BasicDetailDAOImpl extends AbstractDAO implements BasicDetailDAO {
	@Override
	public PatientEntity saveWithPatient(BasicDetailEntity basicDetail) {
		PatientEntity patient = new PatientEntity();
		this.getSession().save(patient);

		basicDetail.setPatient(patient);
		this.getSession().save(basicDetail);

		patient.setBasicDetail(basicDetail);
		return patient;
	}

	@Override
	public BasicDetailEntity save(BasicDetailEntity basicDetail, long patientId) {
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			PatientEntity patient = (PatientEntity) patientObject;
			basicDetail.setPatient(patient);
			this.getSession().save(basicDetail);
			return basicDetail;
		}
		return null;
	}

	@Override
	public BasicDetailEntity update(BasicDetailEntity basicDetail) {
		basicDetail = (BasicDetailEntity) this.getSession().merge(basicDetail);
		this.getSession().update(basicDetail);
		return basicDetail;
	}

	@Override
	public PatientEntity update(BasicDetailEntity basicDetail, long patientId) {
		PatientEntity patient = null;
		Object patientObject = this.getSession().get(PatientEntity.class, patientId);
		if (patientObject != null) {
			patient = (PatientEntity) patientObject;
			patient.setBasicDetail(basicDetail);
			basicDetail.setPatient(patient);
			this.getSession().merge(patient);
			//this.getSession().merge(basicDetail);
		}
		return patient;
	}

	@Override
	public BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail) {
		// hibernateTemplate.saveOrUpdate(basicDetail);
		// hibernateTemplate.flush();
		this.getSession().merge(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity get(long basicDetailId) {
		BasicDetailEntity basicDetail = (BasicDetailEntity) this.getSession().get(BasicDetailEntity.class,
				basicDetailId);
		return basicDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicDetailEntity> getAll() {
		Criteria criteria = this.getSession().createCriteria(BasicDetailEntity.class);
		return criteria.list();
	}

	@Override
	public void delete(BasicDetailEntity basicDetail) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(BasicDetailEntity basicDetail) {
		this.getSession().delete(basicDetail);
	}
}