package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.BasicDetailEntity;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.dao.BasicDetailDAO;
import com.draakasheeshah.service.BasicDetailService;

@Service
public class BasicDetailServiceImpl implements BasicDetailService {

	@Autowired
	BasicDetailDAO basicDetailDAO;

	@Override
	public PatientEntity saveWithPatient(BasicDetailEntity basicDetail) {
		return basicDetailDAO.saveWithPatient(basicDetail);
	}

	@Override
	public BasicDetailEntity save(BasicDetailEntity basicDetail, long basicDetailId) {
		return basicDetailDAO.save(basicDetail, basicDetailId);
	}

	@Override
	public BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail) {
		basicDetailDAO.saveOrUpdate(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity get(long basicDetailId) {
		return basicDetailDAO.get(basicDetailId);
	}

	@Override
	public List<BasicDetailEntity> getAll() {
		return basicDetailDAO.getAll();
	}

	@Override
	public void delete(BasicDetailEntity basicDetail) {
		basicDetailDAO.delete(basicDetail);
	}

	@Override
	public void deletePermanently(BasicDetailEntity basicDetail) {
		basicDetailDAO.deletePermanently(basicDetail);
	}
}