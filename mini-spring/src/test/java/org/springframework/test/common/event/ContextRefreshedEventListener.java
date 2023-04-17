package org.springframework.test.common.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshEvent event) {
        System.out.println(this.getClass().getName());
    }
}
