package org.xyz.test.web.constant;

import org.xyz.test.web.param.BaseParam;
import org.xyz.test.web.param.GetUserByAccountParam;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum CommonUrl {
    GET_USER_BY_ACCOUNT(UrlConstant.GET_USER_BY_ACCOUNT, GetUserByAccountParam.class);
    String url;
    Class<? extends BaseParam> paramClass;

    CommonUrl(String url, Class<? extends BaseParam> paramClass) {
        this.url = url;
        this.paramClass = paramClass;
    }

    public String getUrl() {
        return url;
    }

    public Class<? extends BaseParam> getParamClass() {
        return paramClass;
    }

    public static class UrlConstant{
        public static final String GET_USER_BY_ACCOUNT="/getUserByAccount";
    }
}