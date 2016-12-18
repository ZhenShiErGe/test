
package org.xyz.test.service.service.usermanage;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xyz.test.client.service.IUserService;
import org.xyz.test.common.common.HttpResult;
import org.xyz.test.common.common.Pagination;
import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.common.common.userservice.RoleEnum;
import org.xyz.test.common.common.userservice.UserCreateReqDTO;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.common.exception.BusinessException;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.common.exception.SystemException;
import org.xyz.test.dal.dataobject.DataSourceDO;
import org.xyz.test.dal.dataobject.UserDO;
import org.xyz.test.service.dao.DataSourceDao;
import org.xyz.test.service.dao.UserDao;
import org.xyz.test.service.datasourceswitch.DataSourceBeanBuilder;
import org.xyz.test.service.datasourceswitch.DataSourceContext;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {


    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "datasourceDao")
    private DataSourceDao dataSourceDao;

    @Override
    public HttpResult<UserDTO> getUserByAccount(String account) {
        UserDO userDO = userDao.getUserByAccount(account);
        if (userDO == null) {
            throw new BusinessException(ErrorEnum.USER_NOT_EXIST);
        }
        UserDTO userDTO = UserConvent.conventToUserDTO(userDO);
        return HttpResult.successResult(userDTO);
    }

    @Override
    public HttpResult<UserDTO> verifyAndGetUser(String account, String password, RoleEnum roleEnum) {
        if (account == null || password == null || roleEnum == null) {
            return HttpResult.successResult(null);
        }

        UserDO userDO = userDao.getUserByAccount(account);
        if (userDO == null) {
            // 账号不存在
            return HttpResult.successResult(null);
        }
        if (!userDO.getPassword().equals(password)) {
            // 密码错误
            return HttpResult.successResult(null);
        }
        if (userDO.getRole() != roleEnum.getStatus()) {
            // 用户不属于此角色
            return HttpResult.successResult(null);
        }

        UserDTO userDTO = UserConvent.conventToUserDTO(userDO);
        return HttpResult.successResult(userDTO);
    }

    @Override
    public HttpResult<Pagination<UserDTO>> query(QueryUserCondition queryUserCondition) {
        if (queryUserCondition == null) {
            throw new BusinessException(ErrorEnum.PARAM_NULL);
        }
        int totalCount = userDao.countQuery(queryUserCondition);
        List<UserDO> userDOList = userDao.query(queryUserCondition);
        Pagination<UserDTO> pagination = new Pagination<UserDTO>(queryUserCondition.getOffset(),
                queryUserCondition.getLimit(), totalCount, UserConvent.conventToUserDTOList(userDOList));
        return HttpResult.successResult(pagination);
    }

    @Override
    public HttpResult<Integer> countQuery(QueryUserCondition queryUserCondition) {
        int totalCount = userDao.countQuery(queryUserCondition);
        return HttpResult.successResult(totalCount);
    }

    @Override
    public HttpResult<Boolean> createUser(UserCreateReqDTO userCreateReqDTO) {
        if (userCreateReqDTO == null) {
            return HttpResult.successResult(Boolean.FALSE);
        }
        UserDO userDO = UserConvent.conventToUserDO(userCreateReqDTO);
        if (userDao.createUser(userDO)) {
            return HttpResult.successResult(Boolean.TRUE);
        }
        return HttpResult.successResult(Boolean.FALSE);
    }

    @Override
    public HttpResult<Boolean> deleteUserByAccount(String account) {
        if (account == null) {
            throw new BusinessException(ErrorEnum.PARAM_IS_INVALID);
        }
        HttpResult<UserDTO> accountResult = this.getUserByAccount(account);
        if (!accountResult.isSuccess()) {
            throw new BusinessException(ErrorEnum.USER_NOT_EXIST);
        }

        if (!this.userDao.deleteUserByAccount(account)) {
            throw new BusinessException(ErrorEnum.USER_DELETE_FAIL);
        }
        return HttpResult.successResult(Boolean.TRUE);
    }

    @Override
    @Transactional
    public HttpResult<Boolean> testTransaction(UserCreateReqDTO userCreateReqDTO) {
        if (userCreateReqDTO == null) {
            return HttpResult.successResult(Boolean.FALSE);
        }
        UserDO userDO = UserConvent.conventToUserDO(userCreateReqDTO);
        if (userDao.createUser(userDO)) {
            throw new SystemException(ErrorEnum.TEST_TRANSACTION_EXCEPTION);
        }
        return HttpResult.successResult(Boolean.FALSE);
    }

    /**
     * 注意！ @Transactional注解用在此处将导致错误，因为该注解支持的是单数据源的事务，而此方法中已经是多数据源了
     * @param userCreateReqDTO
     * @return
     */
    @Override
    public HttpResult<Boolean> testMultiDataSource(UserCreateReqDTO userCreateReqDTO) {
        if (userCreateReqDTO == null) {
            return HttpResult.successResult(Boolean.FALSE);
        }

        UserDO userDO = UserConvent.conventToUserDO(userCreateReqDTO);
        //先向默认数据源插入
        if (!userDao.createUser(userDO)) {
            throw new BusinessException(ErrorEnum.TEST_MULTI_DATASOURCE_EXCEPTION);
        }

        //再向起他数据源插入
        List<DataSourceDO> dataSourceDOList = this.dataSourceDao.query();
        for (DataSourceDO dataSourceDO : dataSourceDOList) {
            DataSourceBeanBuilder builder = new DataSourceBeanBuilder(
                    dataSourceDO.getDatabaseName(),
                    dataSourceDO.getDatabaseIp(),
                    dataSourceDO.getDatabasePort(),
                    dataSourceDO.getDatasourceName(),
                    dataSourceDO.getUsername(),
                    dataSourceDO.getPassword());
            DataSourceContext.setDataSource(builder);
            if (!userDao.createUser(userDO)) {
                throw new BusinessException(ErrorEnum.TEST_MULTI_DATASOURCE_EXCEPTION);
            }
            DataSourceContext.clearDataSource();
        }

        return HttpResult.successResult(Boolean.TRUE);
    }
}
