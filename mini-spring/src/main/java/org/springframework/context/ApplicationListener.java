package org.springframework.context;

import java.util.EventListener;
import java.util.EventObject;

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
