package org.xyz.test.common.common;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class BaseParam {
    //可以放一些公共参数

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
