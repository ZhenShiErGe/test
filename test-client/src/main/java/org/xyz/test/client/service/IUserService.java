
package org.xyz.test.client.service;

import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.Pagination;
import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.common.common.userservice.RoleEnum;
import org.xyz.test.common.common.userservice.UserCreateReqDTO;
import org.xyz.test.common.common.userservice.UserDTO;

/**
 * Created by yizhenn on 2016/12/4.
 */
public interface IUserService {

    HttpResult<UserDTO> getUserByAccount(String account);

    HttpResult<UserDTO> verifyAndGetUser(String account, String password, RoleEnum roleEnum);

    HttpResult<Boolean> createUser(UserCreateReqDTO userCreateReqDTO);


    HttpResult<Integer> countQuery(QueryUserCondition queryUserCondition);


    HttpResult<Pagination<UserDTO>> query(QueryUserCondition queryUserCondition);


    HttpResult<Boolean> deleteUserByAccount(String account);

    HttpResult<Boolean> testTransaction(UserCreateReqDTO userCreateReqDTO);

    HttpResult<Boolean> testMultiDataSource(UserCreateReqDTO userCreateReqDTO);

}
