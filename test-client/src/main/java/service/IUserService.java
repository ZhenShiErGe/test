
package service;

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

}
