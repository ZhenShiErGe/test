package org.xyz.test.service.securehttpinvoker.server;

import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.util.NestedServletException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by yizhenn on 2017/7/26.
 */
public class SecureHttpInvokerServiceExporter extends HttpInvokerServiceExporter {
    private static final String ACCESSKEYID_NAME_IN_REQUEST_PARAM="accesskeyid";
    private static final String ACCESSKEYSECRET_NAME_IN_REQUEST_PARAM="accesskeysecret";
    /**
     * 和调用方约定的用户名
     */
    private String accessKeyId;
    /**
     * 和调用方约定的密码
     */
    private String accessKeySecret;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RemoteInvocation invocation = this.readRemoteInvocation(request);
            RemoteInvocationResult result = null;
            if (!validate(invocation.getAttributes())){
                String msg="RPC Security Forbidden!";
                result=new RemoteInvocationResult(new ServletException(msg));
            }else{
                result=this.invokeAndCreateResult(invocation, this.getProxy());
            }
            this.writeRemoteInvocationResult(request, response, result);
        } catch (ClassNotFoundException var5) {
            throw new NestedServletException("Class not found during deserialization", var5);
        }
    }
    /**
     * 和调用方约定的验证方法
     */
    private boolean validate(Map<String,Serializable> params){
        String needVerifyAccesskeyId=params.get(ACCESSKEYID_NAME_IN_REQUEST_PARAM).toString();
        String needVerifyAccesskeySecret=params.get(ACCESSKEYSECRET_NAME_IN_REQUEST_PARAM).toString();

        //和调用发约定的验证方法
        boolean validate= accessKeyId.equals(needVerifyAccesskeyId) && accessKeySecret.equals(needVerifyAccesskeySecret);
        return validate;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
