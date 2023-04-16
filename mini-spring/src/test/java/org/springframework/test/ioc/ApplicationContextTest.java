package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Person person = (Person) applicationContext.getBean("person");

        System.out.println(person);

        Assertions.assertThat(person.getName()).isEqualTo("ivy");
        Car car = applicationContext.getBean("car", Car.class);

        System.out.println(car);
        Assertions.assertThat(car.getBrand()).isEqualTo("lamborghini");

    }
}
