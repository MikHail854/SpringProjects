package com.apress.prospring5.ch3.annotated;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {
    private String someName;

    public ConstructorConfusion(String someName) {
        System.out.println("ConstructorConfusion(String) called");
        this.someName = someName;
    }

    @Autowired
    public ConstructorConfusion(@Value("90") int someName) {
        System.out.println("ConstructorConfusion(int) called");
        this.someName = "Number" + Integer.toString(someName);
    }

    public String toString(){
        return someName;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        System.out.println(cc);

        ctx.close();
    }
}
