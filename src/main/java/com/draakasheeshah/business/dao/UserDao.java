package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.UserEntity;

public interface UserDao {

	UserEntity get(String emailId, String userName);

	UserEntity get(String emailId, String userName, String passwrod);

	UserEntity get(long userId);

	UserEntity save(String emailId, String userName, String passwrod);

	UserEntity update(String emailId, String userName, String passwrod);

	void deleteUser(String emailId, String userName);

	void deletePermanently(UserEntity patient);

	List<UserEntity> getAll();

}
