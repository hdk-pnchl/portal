package com.draakasheeshah.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.AuthorityEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.dao.AuthorityDAO;
import com.draakasheeshah.business.service.AuthorityService;
import com.draakasheeshah.business.util.Roles;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService, InitializingBean {

	@Autowired
	AuthorityDAO authorityDAO;

	private Map<Roles, AuthorityEntity> authorityMap = new HashMap<Roles, AuthorityEntity>();

	@Override
	public Map<Roles, AuthorityEntity> getAuthorityMap() {
		return authorityMap;
	}

	public void setAuthorityMap(Map<Roles, AuthorityEntity> authorityMap) {
		this.authorityMap = authorityMap;
	}

	@Override
	public AuthorityEntity save(AuthorityEntity authority) {
		authority = this.authorityDAO.save(authority);
		return authority;
	}

	@Override
	public AuthorityEntity update(AuthorityEntity authority) {
		authority = this.authorityDAO.update(authority);
		return authority;
	}

	@Override
	public BasicDetailEntity addRoleToUser(AuthorityEntity role, long basicDetailId) {
		BasicDetailEntity basicDetail = this.addRoleToUser(role, basicDetailId);
		return basicDetail;
	}

	@Override
	public AuthorityEntity saveOrUpdate(AuthorityEntity role) {
		this.authorityDAO.saveOrUpdate(role);
		return role;
	}

	@Override
	public AuthorityEntity get(long roleId) {
		AuthorityEntity role = this.get(roleId);
		return role;
	}

	@Override
	public List<AuthorityEntity> loadAll() {
		List<AuthorityEntity> roles = this.authorityDAO.loadAll();
		return roles;
	}

	@Override
	public void delete(AuthorityEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(AuthorityEntity family) {
		this.authorityDAO.delete(family);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		AuthorityEntity guest = this.save(new AuthorityEntity(Roles.GUEST.getName()));
		AuthorityEntity admin = this.save(new AuthorityEntity(Roles.ADMIN.getName()));

		this.getAuthorityMap().put(Roles.GUEST, guest);
		this.getAuthorityMap().put(Roles.ADMIN, admin);

	}
}