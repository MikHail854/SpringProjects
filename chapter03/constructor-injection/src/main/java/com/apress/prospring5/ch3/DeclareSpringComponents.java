package com.apress.prospring5.ch3;

import com.apress.prospring5.ch2.decoupled.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext cxt = new GenericXmlApplicationContext();
        cxt.load("classpath:spring/app-context-annotation.xml");
        cxt.refresh();

        MessageProvider messageProvider = cxt.getBean("provider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }
}
