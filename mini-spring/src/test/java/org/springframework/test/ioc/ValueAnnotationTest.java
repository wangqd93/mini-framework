package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;
import org.springframework.test.bean.CarByValue;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueAnnotationTest {


    @Test
    public void testValueAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

        CarByValue car = applicationContext.getBean("carByValue", CarByValue.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }

}
