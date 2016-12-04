
package org.xyz.test.service.dao;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;
import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.dal.dataobject.UserDO;
import org.xyz.test.dal.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */

@Service("userDao")
public class UserDao {

    @Resource
    private UserMapper userMapper;

    public UserDO getUserByAccount(String account) {
        if (StringUtils.isBlank(account)) {
            return null;
        }

        return userMapper.getUserByAccount(account);
    }

    public int countQuery(QueryUserCondition queryUserCondition) {
        if (queryUserCondition == null) {
            return 0;
        }
        return userMapper.countQuery(queryUserCondition);
    }

    public List<UserDO> query(QueryUserCondition queryUserCondition) {
        if (queryUserCondition == null) {
            return new ArrayList<UserDO>();
        }
        return userMapper.query(queryUserCondition);
    }

    public boolean createUser(UserDO userDO) {
        if (userDO == null) {
            return false;
        }
        int res = userMapper.createUser(userDO);
        if (res == 1) {
            return true;
        }
        return false;
    }

    public boolean deleteUserByAccount(String account) {
        if (account == null) {
            return false;
        }
        return this.userMapper.deleteUserByAccount(account) == 1;
    }
}
