package com.draakasheeshah.bo;

public class BasicResponse {
    private int responseCode;
    private String responseDesc;

    public BasicResponse(int responseCode, String responseDesc) {
        super();
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
}
