package com.draakasheeshah.business.service;

import java.util.List;
import java.util.Map;

import com.draakasheeshah.business.bo.RolesEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.util.Roles;

public interface AuthorityService {

	RolesEntity save(RolesEntity authority);

	RolesEntity update(RolesEntity authority);

	RolesEntity saveOrUpdate(RolesEntity role);

	RolesEntity get(long roleId);

	List<RolesEntity> loadAll();

	void delete(RolesEntity family);

	void deletePermanently(RolesEntity family);

	BasicDetailEntity addRoleToUser(RolesEntity role, long basicDetailId);

	Map<Roles, RolesEntity> getAuthorityMap();

}
