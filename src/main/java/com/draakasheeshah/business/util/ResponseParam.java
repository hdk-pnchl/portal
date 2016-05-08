package com.draakasheeshah.business.util;

public enum ResponseParam {
	ERROR_MSG("ERROR_MSG");

	ResponseParam(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
