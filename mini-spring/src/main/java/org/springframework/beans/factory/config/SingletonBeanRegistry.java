package org.springframework.beans.factory.config;

/**
 * 定义添加和获取单例bean的方法
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void addSingleton(String beanName, Object singletonObject);

}
