package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.dao.BasicDetailDAO;
import com.draakasheeshah.business.service.BasicDetailService;

@Service
@Transactional
public class BasicDetailServiceImpl implements BasicDetailService, UserDetailsService {

	@Autowired
	BasicDetailDAO basicDetailDAO;

	@Override
	public PatientEntity saveWithPatient(BasicDetailEntity basicDetail) {
		return basicDetailDAO.saveWithPatient(basicDetail);
	}

	@Override
	public BasicDetailEntity save(BasicDetailEntity basicDetail, long basicDetailId) {
		basicDetail.processInternalData();
		return basicDetailDAO.save(basicDetail, basicDetailId);
	}

	@Override
	public BasicDetailEntity update(BasicDetailEntity basicDetail) {
		basicDetail.processInternalData();
		basicDetailDAO.update(basicDetail);
		return basicDetail;
	}

	@Override
	public PatientEntity update(BasicDetailEntity basicDetail, long basicDetailId) {
		basicDetail.processInternalData();
		PatientEntity patientEntity = basicDetailDAO.update(basicDetail, basicDetailId);
		return patientEntity;
	}

	@Override
	public BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail) {
		basicDetail.processInternalData();
		basicDetailDAO.saveOrUpdate(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity get(long basicDetailId) {
		return basicDetailDAO.get(basicDetailId);
	}

	@Override
	public List<BasicDetailEntity> getAll() {
		return basicDetailDAO.loadAll();
	}

	@Override
	public void delete(BasicDetailEntity basicDetail) {
		basicDetailDAO.delete(basicDetail);
	}

	@Override
	public void deletePermanently(BasicDetailEntity basicDetail) {
		basicDetailDAO.deletePermanently(basicDetail);
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		BasicDetailEntity userDetails = basicDetailDAO.get(emailId);
		return userDetails;
	}
}