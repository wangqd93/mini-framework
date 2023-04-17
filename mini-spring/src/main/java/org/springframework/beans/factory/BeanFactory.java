package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * bean工厂
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @return
     */
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;



}
