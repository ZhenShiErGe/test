package org.xyz.test.service.datasourceswitch.impl;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.xyz.test.common.exception.ErrorEnum;
import org.xyz.test.common.exception.SystemException;
import org.xyz.test.service.datasourceswitch.DataSourceBeanBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhen on 16-12-18.
 */
final class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware{

    private static final String DATA_SOURCES_NAME = "targetDataSources";

    private ApplicationContext applicationContext;

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceBeanBuilder dataSourceBeanBuilder = DataSourceHolder.getDataSource();
        System.out.println("----determineCurrentLookupKey---"+dataSourceBeanBuilder);
        if (dataSourceBeanBuilder == null) {
            return null;
        }
        DataSourceBean dataSourceBean = new DataSourceBean(dataSourceBeanBuilder);
        //查看当前容器中是否存在
        try {
            if (!getTargetDataSources().keySet().contains(dataSourceBean.getBeanName())) {
                addNewDataSourceToTargerDataSources(dataSourceBean);
            }
            return dataSourceBean.getBeanName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new SystemException(ErrorEnum.MULTI_DATASOURCE_SWITCH_EXCEPTION);
        }
    }

    private void addNewDataSourceToTargerDataSources(DataSourceBean dataSourceBean) throws NoSuchFieldException, IllegalAccessException {
        getTargetDataSources().put(dataSourceBean.getBeanName(), createDataSource(dataSourceBean));
        super.afterPropertiesSet();//通知spring有bean更新
    }

    private Object createDataSource(DataSourceBean dataSourceBean) throws IllegalAccessException {
        //在spring容器中创建并且声明bean
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BasicDataSource.class);
        //将dataSourceBean中的属性值赋给目标bean
        Map<String, Object> properties = getPropertyKeyValues(DataSourceBean.class, dataSourceBean);
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            beanDefinitionBuilder.addPropertyValue((String) entry.getKey(), entry.getValue());
        }
        beanFactory.registerBeanDefinition(dataSourceBean.getBeanName(), beanDefinitionBuilder.getBeanDefinition());
        return applicationContext.getBean(dataSourceBean.getBeanName());
    }

    private Map<Object, Object> getTargetDataSources() throws NoSuchFieldException, IllegalAccessException {
        Field field = AbstractRoutingDataSource.class.getDeclaredField(DATA_SOURCES_NAME);
        field.setAccessible(true);
        return (Map<Object, Object>) field.get(this);
    }


    private <T> Map<String, Object> getPropertyKeyValues(Class<T> clazz, Object object) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> result = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            result.put(field.getName(), field.get(object));
        }
        result.remove("beanName");
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}