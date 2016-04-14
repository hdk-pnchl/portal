package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.UserEntity;

public interface UserService {

	UserEntity get(UserEntity userEntity);

	UserEntity get(long userId);

	UserEntity save(UserEntity userEntity);

	UserEntity update(UserEntity userEntity);

	void deleteUser(UserEntity userEntity);

	void deletePermanently(UserEntity patient);

	List<UserEntity> getAll();

}
