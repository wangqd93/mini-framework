package org.springframework.context.event;

import org.springframework.context.ApplicationListener;

public class ContextCloseEvent extends ApplicationContextEvent {
    public ContextCloseEvent(Object source) {
        super(source);
    }
}
