package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.AuthorityEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.FamilyEntity;

public interface AuthorityDAO {

	AuthorityEntity save(AuthorityEntity authority);

	AuthorityEntity update(AuthorityEntity authority);

	AuthorityEntity saveOrUpdate(AuthorityEntity role);

	AuthorityEntity get(long roleId);

	List<AuthorityEntity> loadAll();

	void deletePermanently(AuthorityEntity family);

	BasicDetailEntity addRoleToUser(AuthorityEntity role, long basicDetailId);

	void delete(AuthorityEntity family);

}
