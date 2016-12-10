package org.xyz.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 16-12-10.
 */
public interface AbstractInterceptor {
    public boolean check(HttpServletRequest request, HttpServletResponse response);
}
