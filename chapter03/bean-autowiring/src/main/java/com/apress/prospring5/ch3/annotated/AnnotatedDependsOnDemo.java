package com.apress.prospring5.ch3.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotatedDependsOnDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-02.xml");

        Singer johnMayer = ctx.getBean("johnMayer", Singer.class);
        johnMayer.sign();

        ctx.close();
    }
}
