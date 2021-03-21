package com.apress.prospring5.ch3.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("gigi")
@Lazy
public class TrickyTarget {

    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget(){
        System.out.println("Target.constructor()");
    }

    public TrickyTarget(Foo fooOne) {
        System.out.println("Target(Foo) called");
    }

    public TrickyTarget(Foo fooOne, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
    }

    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-05.xml");
        ctx.refresh();

        TrickyTarget t = ctx.getBean(TrickyTarget.class);

        ctx.close();
    }
}
