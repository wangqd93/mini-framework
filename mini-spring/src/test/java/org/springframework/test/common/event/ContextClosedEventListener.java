package org.springframework.test.common.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextCloseEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextCloseEvent> {
    @Override
    public void onApplicationEvent(ContextCloseEvent event) {
        System.out.println(this.getClass().getName());
    }
}
