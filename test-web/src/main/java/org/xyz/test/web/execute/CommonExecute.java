package org.xyz.test.web.execute;


import org.xyz.test.web.param.BaseParam;
import org.xyz.test.common.common.HttpResult;

/**
 * Created by yizhenn on 2016/12/4.
 */
public interface CommonExecute<T extends BaseParam> {
    HttpResult execute(T param);
}
