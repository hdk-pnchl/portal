package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.RolesEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.AuthorityDAO;

@Repository
@Transactional
public class AuthorityDAOImpl extends AbstractDAO implements AuthorityDAO  {

	@Override
	public RolesEntity save(RolesEntity authority) {
		this.getSession().save(authority);
		return authority;
	}

	@Override
	public RolesEntity update(RolesEntity authority) {
		this.getSession().update(authority);
		return authority;
	}

	@Override
	public BasicDetailEntity addRoleToUser(RolesEntity role, long basicDetailId) {
		BasicDetailEntity basicDetail = null;
		Object basicDetailObject = this.getSession().get(BasicDetailEntity.class, basicDetailId);
		if (basicDetailObject != null) {
			basicDetail = (BasicDetailEntity) basicDetailObject;
			basicDetail.getRoles().add(role);
			this.getSession().merge(basicDetail);
		}
		return basicDetail;
	}

	@Override
	public RolesEntity saveOrUpdate(RolesEntity role) {
		this.getSession().saveOrUpdate(role);
		return role;
	}

	@Override
	public RolesEntity get(long roleId) {
		RolesEntity family = null;
		Object patientObject = this.getSession().get(RolesEntity.class, roleId);
		if (patientObject != null) {
			family = (RolesEntity) patientObject;
		}
		return family;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolesEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(RolesEntity.class);
		return (List<RolesEntity>) criteria.list();
	}

	@Override
	public void delete(RolesEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(RolesEntity family) {
		this.getSession().delete(family);
	}
}