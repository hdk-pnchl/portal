package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.BasicDetailDAO;
import com.draakasheeshah.business.util.SearchInput;

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
			// this.getSession().merge(basicDetail);
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

	@Override
	public BasicDetailEntity get(String emailId) {
		BasicDetailEntity basicDetail = null;
		Criteria criteria = getSession().createCriteria(BasicDetailEntity.class);
		if (emailId != null) {
			criteria.add(Restrictions.eq("emailId", emailId));
		}
		Object userObject = criteria.uniqueResult();
		if (userObject != null) {
			basicDetail = (BasicDetailEntity) userObject;
		}
		return basicDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicDetailEntity> loadAll() {
		Criteria criteria = this.getSession().createCriteria(BasicDetailEntity.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicDetailEntity> loadAll(SearchInput searchInput) {
		int beginIndx = (searchInput.getPageNo() * searchInput.getRowsPerPage()) - searchInput.getRowsPerPage();
		Criteria criteria = this.getSession().createCriteria(BasicDetailEntity.class);
		criteria.setFirstResult(beginIndx);
		criteria.setMaxResults(searchInput.getRowsPerPage());
		//criteria.addOrder(Order.asc("lastUpdatedOn"));
		return criteria.list();
	}

	@Override
	public Long getTotalRowCount(SearchInput searchInput) {
		Criteria criteria = this.getSession().createCriteria(BasicDetailEntity.class);
		criteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) criteria.uniqueResult();
		return rowCount;
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