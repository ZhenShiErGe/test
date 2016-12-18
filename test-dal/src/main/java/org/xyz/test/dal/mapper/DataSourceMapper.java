
package org.xyz.test.dal.mapper;

import org.xyz.test.common.common.userservice.QueryUserCondition;
import org.xyz.test.dal.dataobject.DataSourceDO;
import org.xyz.test.dal.dataobject.UserDO;

import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */
public interface DataSourceMapper {

    List<DataSourceDO> getAllDataSources();

}
