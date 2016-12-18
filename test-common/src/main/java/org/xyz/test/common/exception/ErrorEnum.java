package org.xyz.test.common.exception;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum ErrorEnum {
    PARAM_NULL("1", "参数为空"),
    PARAM_IS_INVALID("2", "参数 invalid"),
    USER_NOT_EXIST("3", "用户不存在"),
    USER_NOT_STUDENT("4", "用户不是学生"),
    USER_DELETE_FAIL("5","delet user fail"),
    TEST_TRANSACTION_EXCEPTION("6","test transaction exception"),
    TEST_MULTI_DATASOURCE_EXCEPTION("7","test multi datasource exception"),
    MULTI_DATASOURCE_SWITCH_EXCEPTION("8","multi datasource switch exception"),
    RUNTIME_EXCEPTION("500", "runtime exception!"),
    UNKNOWN_EXCEPTION("0","unknown exception");
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

    @Override
    public String toString() {
        return "ErrorEnum{" +
                "errCode='" + errCode + '\'' +
                ", errDesc='" + errDesc + '\'' +
                '}';
    }
}

