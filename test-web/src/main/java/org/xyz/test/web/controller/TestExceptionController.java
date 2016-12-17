package org.xyz.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xyz.test.client.service.IUserService;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.userservice.RoleEnum;
import org.xyz.test.common.common.userservice.UserCreateReqDTO;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.common.exception.BusinessException;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.common.exception.SystemException;
import org.xyz.test.web.constant.CommonUrl;
import org.xyz.test.web.constant.CommonUtils;
import org.xyz.test.web.execute.CommonExecute;
import org.xyz.test.web.execute.CommonExecutor;
import org.xyz.test.web.param.BaseParam;
import org.xyz.test.web.param.CreateUserParam;
import org.xyz.test.web.param.GetUserByAccountParam;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 16-12-11.
 */
@Controller
@RequestMapping(value = CommonUrl.UrlConstant.TEST_PREFIX)
public class TestExceptionController {

    @Resource(name = "userService")
    IUserService userService;

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

    @RequestMapping(value = CommonUrl.UrlConstant.TEST_TRANSACTION, produces = CommonUtils.CONTENT_TYPE)
    @ResponseBody
    public String testTransaction(HttpServletRequest request, HttpServletResponse response) {
        return CommonExecutor.execute(request, response, CreateUserParam.class, new CommonExecute<CreateUserParam>() {
            @Override
            public HttpResult execute(CreateUserParam param) {
                RoleEnum roleEnum = RoleEnum.getRoleByStatus(param.getRole());
                if (roleEnum == null)
                    throw new BusinessException(ErrorEnum.PARAM_IS_INVALID);

                UserCreateReqDTO userCreateReqDTO = new UserCreateReqDTO();
                userCreateReqDTO.setAccount(param.getAccount());
                userCreateReqDTO.setPassword(param.getPassword());
                userCreateReqDTO.setRole(roleEnum);
                userCreateReqDTO.setUserName(param.getUsername());
                return userService.testTransaction(userCreateReqDTO);
            }
        });
    }
}
