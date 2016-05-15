package com.draakasheeshah.business.util;

public enum ResponseParam {
	ERROR_MSG("ERROR_MSG"), ROW_COUNT("ROW_COUNT"), TOTAL_PAGE_COUNT("TOTAL_PAGE_COUNT"), CURRENT_PAGE_NO(
			"CURRENT_PAGE_NO"), ROWS_PER_PAGE("ROWS_PER_PAGE"), EMAIL_ID("EMAIL_ID");

	ResponseParam(String desc) {
		this.desc = desc;
	}

	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
