package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.AuthorityEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.AuthorityDAO;

@Repository
@Transactional
public class AuthorityDAOImpl extends AbstractDAO implements AuthorityDAO  {

	@Override
	public AuthorityEntity save(AuthorityEntity authority) {
		this.getSession().save(authority);
		return authority;
	}

	@Override
	public AuthorityEntity update(AuthorityEntity authority) {
		this.getSession().update(authority);
		return authority;
	}

	@Override
	public BasicDetailEntity addRoleToUser(AuthorityEntity role, long basicDetailId) {
		BasicDetailEntity basicDetail = null;
		Object basicDetailObject = this.getSession().get(BasicDetailEntity.class, basicDetailId);
		if (basicDetailObject != null) {
			basicDetail = (BasicDetailEntity) basicDetailObject;
			basicDetail.getAuthorities().add(role);
			/*
			Set<String> authorities = new HashSet<String>();

			Set<AuthorityEntity> setAuths = new HashSet<AuthorityEntity>();

			// Build user's authorities
			for (String rl : authorities) {
				setAuths.add(new AuthorityEntity());
			}
			
			//SimpleGrantedAuthority
			*/
			this.getSession().merge(basicDetail);
		}
		return basicDetail;
	}

	@Override
	public AuthorityEntity saveOrUpdate(AuthorityEntity role) {
		this.getSession().saveOrUpdate(role);
		return role;
	}

	@Override
	public AuthorityEntity get(long roleId) {
		AuthorityEntity family = null;
		Object patientObject = this.getSession().get(AuthorityEntity.class, roleId);
		if (patientObject != null) {
			family = (AuthorityEntity) patientObject;
		}
		return family;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorityEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(AuthorityEntity.class);
		return (List<AuthorityEntity>) criteria.list();
	}

	@Override
	public void delete(AuthorityEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(AuthorityEntity family) {
		this.getSession().delete(family);
	}
}