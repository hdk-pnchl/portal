package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.UserEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.UserDao;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDAO implements UserDao {
	@Override
	public UserEntity get(String emailId, String userName) {
		UserEntity userEntity = null;
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		if (userName != null) {
			criteria.add(Restrictions.eq("userName", userName));
		}
		if (emailId != null) {
			criteria.add(Restrictions.eq("emailId", emailId));
		}
		Object userObject = criteria.uniqueResult();
		if (userObject != null) {
			userEntity = (UserEntity) userObject;
		}
		return userEntity;
	}

	@Override
	public UserEntity get(String emailId, String userName, String passwrod) {
		UserEntity userEntity = null;
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		if (userName != null) {
			criteria.add(Restrictions.eq("userName", userName));
		}
		if (emailId != null) {
			criteria.add(Restrictions.eq("emailId", emailId));
		}
		if (passwrod != null) {
			criteria.add(Restrictions.eq("password", passwrod));
		}
		Object userObject = criteria.uniqueResult();
		if (userObject != null) {
			userEntity = (UserEntity) userObject;
		}
		return userEntity;
	}

	@Override
	public UserEntity get(long userId) {
		UserEntity userEntity = null;
		Object userObject = this.getSession().get(UserEntity.class, userId);
		if (userObject != null) {
			userEntity = (UserEntity) userObject;
		}
		return userEntity;
	}

	@Override
	public UserEntity save(String emailId, String userName, String passwrod) {
		UserEntity userEntity = null;
		this.getSession().save(userEntity);
		return userEntity;
	}

	@Override
	public UserEntity update(String emailId, String userName, String passwrod) {
		UserEntity userEntity = null;
		this.getSession().update(userEntity);
		return userEntity;
	}

	@Override
	public void deleteUser(String emailId, String userName) {
	}

	@Override
	public void deletePermanently(UserEntity patient) {
		this.getSession().delete(patient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAll() {
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		return (List<UserEntity>) criteria.list();
	}
}
