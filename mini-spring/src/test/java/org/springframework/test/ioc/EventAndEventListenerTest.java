package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.common.event.CustomEvent;

public class EventAndEventListenerTest {


    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");

        applicationContext.publishEvent(new CustomEvent(applicationContext));
        applicationContext.registerShutdownHook();

    }
}
