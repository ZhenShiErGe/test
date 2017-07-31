package org.xyz.test.web.controller;

import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xyz.test.client.service.IRpcService;
import org.xyz.test.client.service.IUserService;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.web.constant.CommonUtils;
import org.xyz.test.web.constant.UrlConstant;
import org.xyz.test.web.execute.CommonExecute;
import org.xyz.test.web.execute.CommonExecutor;
import org.xyz.test.web.param.BaseParam;
import org.xyz.test.web.param.GetUserByAccountParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 2016/12/4.
 */

@Controller
@RequestMapping(value = UrlConstant.TEST_PREFIX)
public class TestSecureHttpInvokerController {

    @Resource(name="consumeRpcService")
    IRpcService rpcService;

    @RequestMapping(value = UrlConstant.TEST_SECURE_HTTP_INVOKER, produces = CommonUtils.CONTENT_TYPE)
    @ResponseBody
    public String testSecureHttpInvoker(final HttpServletRequest request, final HttpServletResponse response) {
        return CommonExecutor.execute(request, response, BaseParam.class, new CommonExecute() {
            @Override
            public HttpResult execute(BaseParam param) {
                String result=rpcService.service();
                if(StringUtils.isNullOrEmpty(result)){
                    return HttpResult.failedResult(ErrorEnum.RUNTIME_EXCEPTION);
                }else{
                    return HttpResult.successResult(result);
                }
            }
        });
    }
}
