import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xyz.test.client.service.IUserService;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.Pagination;
import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.dal.dataobject.UserDO;
import org.xyz.test.dal.mapper.UserMapper;
import org.xyz.test.service.service.usermanage.UserServiceImpl;

import java.util.List;

/**
 * Created by yizhenn on 16-12-4.
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");


        IUserService userService= (IUserService) context.getBean("userService");
        HttpResult<Pagination<UserDTO>> httpResult = userService.query(new QueryUserCondition());
        System.out.println(httpResult);

    }
}
