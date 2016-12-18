package org.xyz.test.service.datasourceswitch.impl;

import org.xyz.test.service.datasourceswitch.DataSourceBeanBuilder;

/**
 * Created by yizhen on 16-12-18.
 */
final class DataSourceBean {
    private final String beanName;
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;
    private final String validationQuery;
    private final boolean testOnBorrow;

    public DataSourceBean(DataSourceBeanBuilder beanBuilder){
        this.beanName=beanBuilder.getBeanName();
        this.driverClassName=beanBuilder.getDriverClassName();
        this.url=beanBuilder.getUrl();
        this.password=beanBuilder.getPassword();
        this.testOnBorrow=beanBuilder.isTestOnBorrow();
        this.username=beanBuilder.getUsername();
        this.validationQuery=beanBuilder.getValidationQuery();
    }

    public String getBeanName() {
        return beanName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }


    @Override
    public String toString() {
        return "DataSourceBean{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                ", testOnBorrow=" + testOnBorrow +
                '}';
    }
}
