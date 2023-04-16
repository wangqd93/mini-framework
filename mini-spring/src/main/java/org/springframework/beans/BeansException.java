package org.springframework.beans;

/**
 * 自定义bean异常
 */
public class BeansException extends RuntimeException{


    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
