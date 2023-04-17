package org.springframework.test.aop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.test.service.HelloService;

import java.lang.reflect.Method;

public class PointcutExpressionTest {


    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.springframework.test.service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;

        Method method = clazz.getDeclaredMethod("sayHello");

        Assertions.assertThat(pointcut.matches(clazz)).isTrue();
        Assertions.assertThat(pointcut.matches(method, clazz)).isTrue();

    }
}
