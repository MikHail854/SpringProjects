package com.apress.prospring5.ch4;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/app-context-xml-02.xml");

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
