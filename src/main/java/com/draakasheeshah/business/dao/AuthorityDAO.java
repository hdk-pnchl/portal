package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.RolesEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.FamilyEntity;

public interface AuthorityDAO {

	RolesEntity save(RolesEntity authority);

	RolesEntity update(RolesEntity authority);

	RolesEntity saveOrUpdate(RolesEntity role);

	RolesEntity get(long roleId);

	List<RolesEntity> loadAll();

	void deletePermanently(RolesEntity family);

	BasicDetailEntity addRoleToUser(RolesEntity role, long basicDetailId);

	void delete(RolesEntity family);

}
