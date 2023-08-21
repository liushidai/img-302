package com.example.img302.common.enums;

import lombok.Getter;

/**
 * @author liushidai
 */
@Getter
public enum UserType {
    /**
     * 普通用户
     */
    COMMON((byte) 0, "COMMON"),
    /**
     * admin用户
     */
    ADMIN((byte) 1, "ADMIN");
    private final byte code;
    private final String name;

    UserType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * code 转枚举
     *
     * @param code code值
     * @return code对应的enum
     */
    public static UserType fromValue(byte code) {
        for (UserType userType : values()) {
            if (userType.getCode() == code) {
                return userType;
            }
        }
        return null;
    }

}
