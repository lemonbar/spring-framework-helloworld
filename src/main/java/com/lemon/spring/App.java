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
 * @ComponentScan can be replaced by the code ctx.scan("package-name") and ctx.refresh().
 */
@Configuration
//@ComponentScan
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
        //Can use more than one input parameters, such as App.class, App2.class.
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        //The above line can also be implemented by the following two lines.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(App.class);
        ctx.scan("com.lemon.spring");
        ctx.refresh();
        MessagePrinter printer = ctx.getBean(MessagePrinter.class);
        printer.printMessage();
        System.out.println("The helloworld is done!\nThanks very much for your info.");
    }
}
