package org.xyz.test.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yizhenn on 16-12-10.
 */
public class DefaultInterceptor extends HandlerInterceptorAdapter {

    private List<AbstractInterceptor> abstractInterceptorList;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        for(AbstractInterceptor abstractInterceptor:abstractInterceptorList){
            if(!abstractInterceptor.check(request,response)){
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //做一些统计工作
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    public void setAbstractInterceptorList(List<AbstractInterceptor> abstractInterceptorList) {
        this.abstractInterceptorList = abstractInterceptorList;
    }
}
