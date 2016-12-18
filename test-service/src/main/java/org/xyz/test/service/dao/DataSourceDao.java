package org.xyz.test.service.dao;

import org.springframework.stereotype.Service;
import org.xyz.test.dal.dataobject.DataSourceDO;
import org.xyz.test.dal.mapper.DataSourceMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yizhen on 16-12-18.
 */
@Service("datasourceDao")
public class DataSourceDao {
    @Resource
    DataSourceMapper dataSourceMapper;

    public List<DataSourceDO> query() {
        return dataSourceMapper.getAllDataSources();

    }
}
