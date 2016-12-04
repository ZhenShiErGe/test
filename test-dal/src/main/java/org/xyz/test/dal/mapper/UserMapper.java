
package org.xyz.test.dal.mapper;

import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.dal.dataobject.UserDO;

import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */
public interface UserMapper {

    /**
     * 根据账号获取用户
     * 
     * @param account
     * @return
     */
    UserDO getUserByAccount(String account);

    /**
     * 创建用户
     * 
     * @param userDO
     * @return
     */
    int createUser(UserDO userDO);

    /**
     * 统计员工数量
     * 
     * @param queryUserCondition
     * @return
     */
    int countQuery(QueryUserCondition queryUserCondition);

    /**
     * 分页获取用户列表
     * 
     * @param queryUserCondition
     * @return
     */
    List<UserDO> query(QueryUserCondition queryUserCondition);

    /**
     * 删除用户
     * 
     * @param account
     * @return
     */
    int deleteUserByAccount( String account);

}
