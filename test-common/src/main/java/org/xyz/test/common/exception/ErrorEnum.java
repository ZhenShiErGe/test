package org.xyz.test.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum ErrorEnum {
    PARAM_NULL(1, "400", "参数为空"),
    PARAM_IS_INVALID(2, "400", "参数 invalid"),
    USER_NOT_EXIST(3, "400", "用户不存在"),
    USER_NOT_STUDENT(4, "400", "用户不是学生"),
    USER_DELETE_FAIL(5, "400", "delete user fail"),
    TEST_TRANSACTION_EXCEPTION(6, "400", "test transaction exception"),
    TEST_MULTI_DATASOURCE_EXCEPTION(7, "500", "test multi datasource exception"),
    MULTI_DATASOURCE_SWITCH_EXCEPTION(8, "500", "multi datasource switch exception"),
    RUNTIME_EXCEPTION(9, "500", "runtime exception!"),
    UNKNOWN_EXCEPTION(10, "500", "unknown exception"),
    RPC_EXCEPTION(11,"500","rpc exception");

    private int flag;
    private String errCode;
    private String errDesc;

    private ErrorEnum(int flag, String errCode, String errDesc) {
        this.flag = flag;
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public int getFlag() {
        return flag;
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

    public static ErrorEnum valueOf(int flag){
        return flag2ErrorEnum.get(flag);
    }

    private static final Map<Integer, ErrorEnum> flag2ErrorEnum = new HashMap<>();

    static {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            flag2ErrorEnum.put(errorEnum.flag, errorEnum);
        }
    }

}

