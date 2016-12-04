package org.xyz.test.web.execute;


/**
 * Created by yizhenn on 2016/12/4.
 */
public interface CommonExecute<T extends BaseParam> {
    HttpResult execute(T param);
}
