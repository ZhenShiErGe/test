package org.xyz.test.common.exception;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum ErrorEnum {
    PARAM_NULL("1", "参数为空"),
    PARAM_IS_INVALID("2", "参数 invalid"),
    USER_NOT_EXIST("2", "用户不存在"),
    USER_NOT_STUDENT("3", "用户不是学生"),
    USER_DELETE_FAIL("4","delet user fail"),

    RUNTIME_EXCEPTION("4", "runtime exception!");

    private String errCode;
    private String errDesc;

    private ErrorEnum(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrDesc() {
        return this.errDesc;
    }
}

