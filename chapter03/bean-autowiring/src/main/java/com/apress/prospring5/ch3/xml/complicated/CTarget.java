package com.apress.prospring5.ch3.xml.complicated;

import com.apress.prospring5.ch3.xml.Bar;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CTarget {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public CTarget(){
    }

    public CTarget(Foo foo){
        System.out.println("Target(Foo) called");
    }

    public CTarget(Foo foo, Bar bar){
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTeo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04.xml");
        ctx.refresh();

        System.out.println("\nUsing byType:\n");

        CTarget cTarget = (CTarget) ctx.getBean("targetByType");
        ctx.close();
    }
}
