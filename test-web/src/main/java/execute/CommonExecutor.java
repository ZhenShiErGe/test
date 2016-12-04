package execute;


import org.omg.CORBA.SystemException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class CommonExecutor {
    public static String execute(HttpServletRequest request, HttpServletResponse response, Class<? extends BaseParam> paramClass, CommonExecute commonExecute){
        //根据paramClass的原信息检查参数的是否存在以及各式是否正确
        BaseParam baseParam=null;
        try{
            baseParam=paramClass.newInstance();
        }catch (InstantiationException e){
            throw new SystemException(ErrorEnum.RUNTIME_EXCEPTION);
        }catch( IllegalAccessException e）{
            throw new SystemException(ErrorEnum.RUNTIME_EXCEPTION);
        }
        new ServletReq
    }
}
