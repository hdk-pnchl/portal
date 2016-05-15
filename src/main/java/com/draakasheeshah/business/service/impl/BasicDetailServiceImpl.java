package com.draakasheeshah.business.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.RolesEntity;
import com.draakasheeshah.business.dao.BasicDetailDAO;
import com.draakasheeshah.business.service.AuthorityService;
import com.draakasheeshah.business.service.BasicDetailService;
import com.draakasheeshah.business.util.Roles;
import com.draakasheeshah.business.util.SearchInput;

@Service
@Transactional
public class BasicDetailServiceImpl implements BasicDetailService, UserDetailsService {

	@Autowired
	BasicDetailDAO basicDetailDAO;
	@Autowired
	AuthorityService authorityService;

	@Override
	public PatientEntity saveWithPatient(BasicDetailEntity basicDetail) {
		RolesEntity role = authorityService.getAuthorityMap().get(Roles.MEMBER);
		basicDetail.getRoles().add(role);
		return basicDetailDAO.saveWithPatient(basicDetail);
	}

	@Override
	public BasicDetailEntity save(BasicDetailEntity basicDetail, long basicDetailId) {
		basicDetail.processInternalData();
		return basicDetailDAO.save(basicDetail, basicDetailId);
	}

	@Override
	public BasicDetailEntity update(BasicDetailEntity basicDetail) {
		basicDetail.processInternalData();
		basicDetailDAO.update(basicDetail);
		return basicDetail;
	}

	@Override
	public PatientEntity update(BasicDetailEntity basicDetail, long basicDetailId) {
		basicDetail.processInternalData();
		PatientEntity patientEntity = basicDetailDAO.update(basicDetail, basicDetailId);
		return patientEntity;
	}

	@Override
	public BasicDetailEntity saveOrUpdate(BasicDetailEntity basicDetail) {
		basicDetail.processInternalData();
		basicDetailDAO.saveOrUpdate(basicDetail);
		return basicDetail;
	}

	@Override
	public BasicDetailEntity get(long basicDetailId) {
		return basicDetailDAO.get(basicDetailId);
	}

	@Override
	public BasicDetailEntity get(String emailId) {
		return basicDetailDAO.get(emailId);
	}

	@Override
	public List<BasicDetailEntity> getAll() {
		return basicDetailDAO.loadAll();
	}
	
	@Override
	public Long getTotalRowCount(SearchInput searchInput) {
		return basicDetailDAO.getTotalRowCount(searchInput);
	}


	@Override
	public List<BasicDetailEntity> getAll(SearchInput searchInput) {
		return basicDetailDAO.loadAll(searchInput);
	}

	@Override
	public void delete(BasicDetailEntity basicDetail) {
		basicDetailDAO.delete(basicDetail);
	}

	@Override
	public void deletePermanently(BasicDetailEntity basicDetail) {
		basicDetailDAO.deletePermanently(basicDetail);
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		User user = null;
		BasicDetailEntity userDetails = basicDetailDAO.get(emailId);
		if (userDetails != null) {
			List<GrantedAuthority> roles = this.buildUserAuthority(userDetails.getRoles());
			user = this.buildUserForAuthentication(userDetails, roles);
		}
		return user;
	}

	private User buildUserForAuthentication(BasicDetailEntity basicDetail, List<GrantedAuthority> authorities) {
		return new User(basicDetail.getEmailId(), basicDetail.getPatientPassword(), basicDetail.isAccountEnabled(),
				basicDetail.isAccountExpired(), basicDetail.isAccountCredentialsExpired(),
				basicDetail.isAccountLocked(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<RolesEntity> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (RolesEntity userRole : roles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}