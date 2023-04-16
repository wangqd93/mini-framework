package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;


public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "bycsyms"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));

        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) defaultListableBeanFactory.getBean("person");

        System.out.println(person);

        Assertions.assertThat(person.getName()).isEqualTo("bycsyms");
        Assertions.assertThat(person.getAge()).isEqualTo(18);
    }

    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        PropertyValues carPropertyValues = new PropertyValues();

        carPropertyValues.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, carPropertyValues);
        defaultListableBeanFactory.registerBeanDefinition("car", carBeanDefinition);

        //注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));

        //Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        defaultListableBeanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) defaultListableBeanFactory.getBean("person");
        System.out.println(person);
        Assertions.assertThat(person.getName()).isEqualTo("derek");
        Assertions.assertThat(person.getAge()).isEqualTo(18);
        Car car = person.getCar();
        Assertions.assertThat(car).isNotNull();
        Assertions.assertThat(car.getBrand()).isEqualTo("porsche");

    }


}
