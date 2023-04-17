package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;
import org.springframework.test.bean.CarConverter;

import java.time.LocalDate;

/**
 * @author derekyi
 * @date 2021/1/17
 */
public class TypeConversionSecondPartTest {

	@Test
	public void testConversionService() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:type-conversion-second-part.xml");

		CarConverter carConverter = applicationContext.getBean("carConverter", CarConverter.class);
		Assertions.assertThat(carConverter.getPrice()).isEqualTo(1000000);
		Assertions.assertThat(carConverter.getProduceDate()).isEqualTo(LocalDate.of(2021, 1, 1));
	}
}
