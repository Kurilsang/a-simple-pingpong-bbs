package com.easyjava.test.entity.enums;

public enum LoginedEnum {
    LOGINED(1),NOTLOGIN(0);
    int isLogined;

    private LoginedEnum(int s) {
        this.isLogined = s;
    }

    public int getIsLogined() {
        return this.isLogined;
    }

}
