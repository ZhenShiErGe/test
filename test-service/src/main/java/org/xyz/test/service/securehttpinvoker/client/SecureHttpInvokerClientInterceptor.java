package org.xyz.test.service.securehttpinvoker.client;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.remoting.RemoteInvocationFailureException;
import org.springframework.remoting.httpinvoker.*;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhenn on 2017/7/26.
 */

public class SecureHttpInvokerClientInterceptor extends HttpInvokerClientInterceptor {

    private static final String ACCESSKEYID_NAME_IN_REQUEST_PARAM = "accesskeyid";
    private static final String ACCESSKEYSECRET_NAME_IN_REQUEST_PARAM = "accesskeysecret";

    /**
     * 和被调用方约定的用户名
     */
    private String accessKeyId;
    /**
     * 和被调用方约定的密码
     */
    private String accessKeySecret;


    /**
     * 返回一个HTTP请求执行器
     * 将默认执行器修改为CommonsHttpInvokerRequestExecutor
     */
    @Override
    public HttpInvokerRequestExecutor getHttpInvokerRequestExecutor() {
        HttpInvokerRequestExecutor httpInvokerRequestExecutor = getParentHttpInvokerRequestExecutor();
        if (httpInvokerRequestExecutor == null) {
//            SimpleHttpInvokerRequestExecutor executor=new SimpleHttpInvokerRequestExecutor();
            CommonsHttpInvokerRequestExecutor executor = new CommonsHttpInvokerRequestExecutor();
            executor.setBeanClassLoader(getBeanClassLoader());
            httpInvokerRequestExecutor = executor;
        }
        return httpInvokerRequestExecutor;
    }

    /**
     * 重写调用方法，向RemoteInvocation中添加项目需要的验证信息
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (AopUtils.isToStringMethod(methodInvocation.getMethod())) {
            return "HTTP invoker proxy for service URL [" + getServiceUrl() + "]";
        }

        RemoteInvocation invocation = createRemoteInvocation(methodInvocation);
        try {
            //生成并写入验证信息
            Map<String, Serializable> needValaditeParams = getValaditeParam();
            if (!needValaditeParams.isEmpty()) {
                if (invocation.getAttributes() == null) {
                    invocation.setAttributes(needValaditeParams);
                } else {
                    invocation.getAttributes().putAll(needValaditeParams);
                }
            }
        } catch (Exception e) {
            logger.error("设置验证参数发生异常，请求将可能被服务端拦截...", e);
        }

        RemoteInvocationResult result = null;
        try {
            result = executeRequest(invocation, methodInvocation);
        } catch (Throwable ex) {
            throw convertHttpInvokerAccessException(ex);
        }
        try {
            return recreateRemoteInvocationResult(result);
        } catch (Throwable ex) {
            if (result.hasInvocationTargetException()) {
                throw ex;
            } else {
                throw new RemoteInvocationFailureException("Invocation of method [" + methodInvocation.getMethod() +
                        "] failed in HTTP invoker remote service at [" + getServiceUrl() + "]", ex);
            }
        }
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        getHttpInvokerRequestExecutor();
    }

    private Map<String, Serializable> getValaditeParam() {
        Map<String, Serializable> map = new HashMap<>();
        map.put(ACCESSKEYID_NAME_IN_REQUEST_PARAM, accessKeyId);
        map.put(ACCESSKEYSECRET_NAME_IN_REQUEST_PARAM, accessKeySecret);
        return map;
    }

    private HttpInvokerRequestExecutor getParentHttpInvokerRequestExecutor() {
        try {
            Field field = HttpInvokerClientInterceptor.class.getDeclaredField("httpInvokerRequestExecutor");
            field.setAccessible(true);
            return (HttpInvokerRequestExecutor) field.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

}
