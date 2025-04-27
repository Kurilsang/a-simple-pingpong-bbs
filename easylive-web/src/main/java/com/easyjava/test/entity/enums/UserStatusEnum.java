package com.easyjava.test.entity.enums;


public enum UserStatusEnum {
    DISABLED(0,"禁用"),
    ENABLE(1,"启用");


    private Integer status;
    private String desc;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    public static UserStatusEnum getUserStatusEnum(Integer status) {
        for(UserStatusEnum userStatusEnum : UserStatusEnum.values()) {
            if(userStatusEnum.getStatus().equals(status)) {
                return userStatusEnum;
            }
        }
        return null;
    }
    public Integer getStatus() {
        return status;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
