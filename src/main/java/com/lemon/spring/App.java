package com.lemon.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration indicates that its primary purpose is as a source of bean definitions.
 * @ComponentScan configures component scanning directives for use with @Configuration classes.
 * @ComponentScan provides support parallel with Spring XML's <context:component-scan> element.
 */
@Configuration
@ComponentScan
public class App {

    /*
    @Bean is used to indicate that a method instantiates, configures and initializes a new object
    to be managed by the Spring IoC container.
    Plays the same role as the <bean/> element.
     */
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello world!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
        System.out.println("The helloworld is done!\nThanks very much for your info.");
    }
}
