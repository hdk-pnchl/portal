package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.UserEntity;
import com.draakasheeshah.business.dao.UserDao;
import com.draakasheeshah.business.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity get(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity get(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(UserEntity userEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePermanently(UserEntity patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
