package com.draakasheeshah.business.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

@Entity
@Table
public final class AuthorityEntity implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349613084505785425L;

	// instance
	@Id
	@GeneratedValue
	private long authorityId;
	private String role;

	public AuthorityEntity() {
	}

	public AuthorityEntity(String role) {
		Assert.hasText(role, "A granted authority textual representation is required");
		this.role = role;
	}

	// behaviour
	// @Override
	public String getAuthority() {
		return this.getRole();
	}

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

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof AuthorityEntity) {
			return role.equals(((AuthorityEntity) obj).role);
		}

		return false;
	}

	public int hashCode() {
		return this.role.hashCode();
	}

	public String toString() {
		return this.role;
	}

}
