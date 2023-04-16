package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.service.HelloService;
import org.springframework.beans.factory.config.BeanDefinition;

public class BeanDefinitionAndBeanDefinitionRegistryTest {


    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("helloService", new BeanDefinition(HelloService.class));

        HelloService helloService = (HelloService) defaultListableBeanFactory.getBean("helloService");

        helloService.sayHello();
    }
}
