package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

public class XmlFileDefineBeanTest {

    @Test
    public void testXmlFile() throws Exception {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) defaultListableBeanFactory.getBean("person");
        System.out.println(person);

        Assertions.assertThat(person.getName()).isEqualTo("derek");
        Assertions.assertThat(person.getCar().getBrand()).isEqualTo("porsche");

        Car car = (Car) defaultListableBeanFactory.getBean("car");
        System.out.println(car);
        Assertions.assertThat(car.getBrand()).isEqualTo("porsche");

    }

}
