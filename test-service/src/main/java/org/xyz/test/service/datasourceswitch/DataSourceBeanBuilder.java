package org.xyz.test.service.datasourceswitch;

/**
 * Created by yizhen on 16-12-18.
 */
public class DataSourceBeanBuilder {
    private static final String URL_FORMATTER="jdbc:mysql://%s:%s/%s?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true&amp;failOverReadOnly=false";
    private String driverClassName="com.mysql.jdbc.Driver";
    private final String beanName;
    private final String databaseIP;
    private final String databasePort;
    private final String databaseName;
    private final String username;
    private final String password;
    private String validationQuery="select 1";
    private boolean testOnBorrow=true;

    public DataSourceBeanBuilder(String beanName,String databaseIP,String databasePort,String databaseName,String username,String password){
        this.beanName=beanName;
        this.databaseIP=databaseIP;
        this.databasePort=databasePort;
        this.databaseName=databaseName;
        this.username=username;
        this.password=password;
    }
    public DataSourceBeanBuilder driverClassName(String value){
        this.driverClassName=value;
        return this;
    }

    public DataSourceBeanBuilder validationQuery(String value){
        this.validationQuery=value;
        return this;
    }

    public DataSourceBeanBuilder testOnBorrow(boolean value){
        this.testOnBorrow=value;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
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

    public String getUrl(){
        return String.format(URL_FORMATTER,this.databaseIP,this.databasePort,this.databaseName);
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public String toString() {
        return "DataSourceBeanBuilder{" +
                "driverClassName='" + driverClassName + '\'' +
                ", databaseIP='" + databaseIP + '\'' +
                ", databasePort='" + databasePort + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                ", testOnBorrow=" + testOnBorrow +
                '}';
    }
}
