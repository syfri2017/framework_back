package com.syfri.userservice.config;

public enum LoginType {

    MYSHIRO("MyShiro"), INFOCOLLECT("InfoCollect");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
