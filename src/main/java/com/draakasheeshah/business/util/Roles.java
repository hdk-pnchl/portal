package com.draakasheeshah.business.util;

public enum Roles {
	GUEST("ROLE_GUEST"), ADMIN("ROLE_ADMIN");

	Roles(String name) {
		this.name = name;
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
