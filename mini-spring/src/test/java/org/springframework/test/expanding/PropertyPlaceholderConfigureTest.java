package org.springframework.test.expanding;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;

public class PropertyPlaceholderConfigureTest {



    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

        Car car = applicationContext.getBean("car", Car.class);
        Assertions.assertThat(car.getBrand()).isEqualTo("lamborghini");
    }
}
