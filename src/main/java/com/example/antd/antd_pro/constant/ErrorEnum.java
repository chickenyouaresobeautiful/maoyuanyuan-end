package com.example.antd.antd_pro.constant;

public enum ErrorEnum {

    WRONG_USER_NAME_OR_PASSWORD(600, "用户名或密码错误"),
    USERNAME_AND_PASSWORD_CANNOT_BE_EMPTY(601, "用户名和密码不能为空"),
    USER_IS_DISABLED(602, "用户已被禁用");

    private int code;
    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
