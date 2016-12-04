package org.xyz.test.common.common;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.xyz.test.common.exception.ErrorEnum;

import java.io.Serializable;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class HttpResult<T> implements Serializable {
    private static final long serialVersionUID = -3404886040638951329L;

    protected boolean success;

    protected T model;

    protected String msgCode;

    protected String msgInfo;

    public HttpResult() {

    }

    public HttpResult(boolean success, String msgCode, String msgInfo) {
        this.success = success;
        this.msgCode = msgCode;
        this.msgInfo = msgInfo;
    }

    public static <T> HttpResult<T> successResult(T t) {
        HttpResult<T> result = new HttpResult<T>();
        result.setSuccess(true);
        result.setModel(t);
        return result;
    }

    public static <T> HttpResult<T> failedResult(String msgCode, String msgInfo) {
        HttpResult<T> result = new HttpResult<T>();
        result.setSuccess(false);
        result.setMsgCode(msgCode);
        result.setMsgInfo(msgInfo);
        return result;
    }

    public static <T> HttpResult<T> failedResult(ErrorEnum errorEnum) {
        HttpResult<T> result = new HttpResult<T>();
        result.setSuccess(false);
        if (errorEnum != null) {
            result.setMsgCode(errorEnum.getErrCode());
            result.setMsgInfo(errorEnum.getErrDesc());
        }
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
