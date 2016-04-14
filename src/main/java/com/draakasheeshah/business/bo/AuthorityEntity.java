package com.draakasheeshah.business.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class AuthorityEntity implements GrantedAuthority, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349613084505785425L;

	// instance
	@Id
	@GeneratedValue
	private long authorityId;
	private String role;

	// setter-getter
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public long getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(long authorityId) {
		this.authorityId = authorityId;
	}

	// behaviour
	@Override
	public String getAuthority() {
		return this.getRole();
	}

}
