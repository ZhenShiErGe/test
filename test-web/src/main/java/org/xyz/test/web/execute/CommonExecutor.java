package org.xyz.test.web.execute;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.xyz.test.web.param.BaseParam;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.common.exception.SystemException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class CommonExecutor {
    public static String execute(HttpServletRequest request, HttpServletResponse response, Class<? extends BaseParam> paramClass, CommonExecute commonExecute) {
        //根据paramClass的原信息检查参数的是否存在以及各式是否正确
        BaseParam baseParam = null;
        try {
            baseParam = paramClass.newInstance();
        } catch (InstantiationException e) {
            throw new SystemException(ErrorEnum.RUNTIME_EXCEPTION);
        } catch (IllegalAccessException e) {
            throw new SystemException(ErrorEnum.RUNTIME_EXCEPTION);
        }
        //inject the values into the baseParam
        new ServletRequestDataBinder(baseParam).bind(request);
        HttpResult result = commonExecute.execute(baseParam);
        return JSON.toJSONString(result);
    }
}
