package org.xyz.test.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 16-12-10.
 */
public class InterceptorOne implements AbstractInterceptor {
    @Override
    public boolean check(HttpServletRequest request, HttpServletResponse response) {
        //在这里写验证逻辑，验证成功返回true，验证失败返回false
        System.out.println("pass interceptorOne");
        return true;
    }
}
