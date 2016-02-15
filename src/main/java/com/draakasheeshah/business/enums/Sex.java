package com.draakasheeshah.business.enums;

public enum Sex{
    MALE("male"),   FEMALE("female");

    private String desc;

    Sex(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
