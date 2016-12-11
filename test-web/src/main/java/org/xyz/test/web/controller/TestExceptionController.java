package org.xyz.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.common.exception.SystemException;
import org.xyz.test.web.constant.CommonUrl;
import org.xyz.test.web.constant.CommonUtils;
import org.xyz.test.web.execute.CommonExecute;
import org.xyz.test.web.execute.CommonExecutor;
import org.xyz.test.web.param.BaseParam;
import org.xyz.test.web.param.GetUserByAccountParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 16-12-11.
 */
@Controller
@RequestMapping(value = CommonUrl.UrlConstant.TEST_PREFIX)
public class TestExceptionController {
    @RequestMapping(value = CommonUrl.UrlConstant.TEST_CONTROLLER_EXCEPTION, produces = CommonUtils.CONTENT_TYPE)
    @ResponseBody
    public String getUserByAccount(HttpServletRequest request, HttpServletResponse response) {
        return CommonExecutor.execute(request, response, BaseParam.class, new CommonExecute() {
            @Override
            public HttpResult execute(BaseParam param) {
                throw new SystemException(ErrorEnum.UNKNOWN_EXCEPTION);
            }
        });
    }
}
