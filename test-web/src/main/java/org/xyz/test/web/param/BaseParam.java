package org.xyz.test.web.param;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
