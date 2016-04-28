package com.draakasheeshah.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.RolesEntity;
import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.dao.AuthorityDAO;
import com.draakasheeshah.business.service.AuthorityService;
import com.draakasheeshah.business.util.Roles;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService, InitializingBean {

	@Autowired
	AuthorityDAO authorityDAO;

	private Map<Roles, RolesEntity> authorityMap = new HashMap<Roles, RolesEntity>();

	@Override
	public Map<Roles, RolesEntity> getAuthorityMap() {
		return authorityMap;
	}

	public void setAuthorityMap(Map<Roles, RolesEntity> authorityMap) {
		this.authorityMap = authorityMap;
	}

	@Override
	public RolesEntity save(RolesEntity authority) {
		authority = this.authorityDAO.save(authority);
		return authority;
	}

	@Override
	public RolesEntity update(RolesEntity authority) {
		authority = this.authorityDAO.update(authority);
		return authority;
	}

	@Override
	public BasicDetailEntity addRoleToUser(RolesEntity role, long basicDetailId) {
		BasicDetailEntity basicDetail = this.addRoleToUser(role, basicDetailId);
		return basicDetail;
	}

	@Override
	public RolesEntity saveOrUpdate(RolesEntity role) {
		this.authorityDAO.saveOrUpdate(role);
		return role;
	}

	@Override
	public RolesEntity get(long roleId) {
		RolesEntity role = this.get(roleId);
		return role;
	}

	@Override
	public List<RolesEntity> loadAll() {
		List<RolesEntity> roles = this.authorityDAO.loadAll();
		return roles;
	}

	@Override
	public void delete(RolesEntity family) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePermanently(RolesEntity family) {
		this.authorityDAO.delete(family);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(this.loadAll().isEmpty()){
			RolesEntity guest = this.save(new RolesEntity(Roles.GUEST.getName()));
			RolesEntity admin = this.save(new RolesEntity(Roles.ADMIN.getName()));

			this.getAuthorityMap().put(Roles.GUEST, guest);
			this.getAuthorityMap().put(Roles.ADMIN, admin);			
		}
	}
}