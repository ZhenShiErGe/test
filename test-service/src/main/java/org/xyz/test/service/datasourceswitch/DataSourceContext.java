package org.xyz.test.service.datasourceswitch;

import org.xyz.test.service.datasourceswitch.impl.DataSourceHolder;

/**
 * Created by yizhen on 16-12-18.
 */
public class DataSourceContext {
    //使用该方法设置数据源
    public static void setDataSource(DataSourceBeanBuilder dataSourceBeanBuilder) {
        DataSourceHolder.setDataSource(dataSourceBeanBuilder);
    }

    //使用该方法清除数据源，清除后将使用默认数据源
    public static void clearDataSource() {
        DataSourceHolder.clearDataSource();
    }
}
