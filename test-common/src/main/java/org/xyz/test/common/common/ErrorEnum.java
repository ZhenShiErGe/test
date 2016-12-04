package org.xyz.test.common.common;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum ErrorEnum {

    RUNTIME_EXCEPTION("1", "runtime org.xyz.test.common.exception!");

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

