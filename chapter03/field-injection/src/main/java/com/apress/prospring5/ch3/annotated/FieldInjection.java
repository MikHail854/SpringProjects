package com.apress.prospring5.ch3.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        Signer signerBean = ctx.getBean(Signer.class);
        signerBean.sign();
        ctx.close();

    }
}
