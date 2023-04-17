package org.springframework.test.ioc;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.core.convert.support.StringToNumberConverterFactory;
import org.springframework.test.common.StringToBooleanConverter;
import org.springframework.test.common.StringToIntegerConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeConversionFirstPartTest {


    @Test
    public void testStringToIntegerConverter() throws Exception {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("8888");
        Assertions.assertThat(num).isEqualTo(8888);
    }


    @Test
    public void testStringToNumberConverterFactory() throws Exception {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();
        Converter<String, Integer> converter = converterFactory.getConverter(Integer.class);

        Integer res = converter.convert("8888");
        Assertions.assertThat(res).isEqualTo(8888);

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        Long longNum = stringToLongConverter.convert("8888");
        assertThat(longNum).isEqualTo(8888L);
    }

    @Test
    public void testGenericConverter() throws Exception {
        StringToBooleanConverter converter = new StringToBooleanConverter();
        Boolean flag = (Boolean)converter.convert("true", String.class, Boolean.class);

        Assertions.assertThat(flag).isTrue();
    }

    @Test
    public void testGenericConversionService() throws Exception {
        GenericConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new StringToIntegerConverter());

        Integer intNum = conversionService.convert("8888", Integer.class);
        assertThat(conversionService.canConvert(String.class, Integer.class)).isTrue();
        assertThat(intNum).isEqualTo(8888);

        conversionService.addConverterFactory(new StringToNumberConverterFactory());
        Assertions.assertThat(conversionService.canConvert(String.class, Long.class)).isTrue();
        Long longNum = conversionService.convert("8888", Long.class);
        Assertions.assertThat(longNum).isEqualTo(8888L);

        conversionService.addConverter(new StringToBooleanConverter());
        Assertions. assertThat(conversionService.canConvert(String.class, Boolean.class)).isTrue();
        Boolean flag = conversionService.convert("true", Boolean.class);
        Assertions.assertThat(flag).isTrue();

    }
}
