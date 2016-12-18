package org.xyz.test.service.datasourceswitch.impl;

import org.xyz.test.service.datasourceswitch.DataSourceBeanBuilder;

/**
 * Created by yizhen on 16-12-18.
 */
public final class DataSourceHolder {
    private static ThreadLocal<DataSourceBeanBuilder> threadLocal=new ThreadLocal<DataSourceBeanBuilder>(){
        @Override
        protected DataSourceBeanBuilder initialValue() {
            return null;
        }
    };

    static DataSourceBeanBuilder getDataSource(){
        return threadLocal.get();
    }

    public static void setDataSource(DataSourceBeanBuilder dataSourceBeanBuilder){
        threadLocal.set(dataSourceBeanBuilder);
    }


    public static void clearDataSource(){
        threadLocal.remove();
    }
}
