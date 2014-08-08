package com.lemon.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component is a generic stereotype for any Spring-managed component.
 * @Repository,@Service, and @Controller are specializations of @Component for more specific use cases.
 */
@Component
public class MessagePrinter {
    final private MessageService service;

    /*
    @Autowired inject a specific implementation.
     */
    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}
