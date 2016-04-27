package com.draakasheeshah.business.service;

import java.util.List;
import java.util.Map;

import com.draakasheeshah.business.bo.AuthorityEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.util.Roles;

public interface AuthorityService {

	AuthorityEntity save(AuthorityEntity authority);

	AuthorityEntity update(AuthorityEntity authority);

	AuthorityEntity saveOrUpdate(AuthorityEntity role);

	AuthorityEntity get(long roleId);

	List<AuthorityEntity> loadAll();

	void delete(AuthorityEntity family);

	void deletePermanently(AuthorityEntity family);

	BasicDetailEntity addRoleToUser(AuthorityEntity role, long basicDetailId);

	Map<Roles, AuthorityEntity> getAuthorityMap();

}
