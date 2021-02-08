package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext cxt = new GenericXmlApplicationContext();
        cxt.load("classpath:spring/app-context-xml.xml");
        cxt.refresh();

        InjectSimple injectSimple = (InjectSimple) cxt.getBean("injectSimple");
        System.out.println(injectSimple);
        cxt.close();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public String toString(){
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is programmer?: " + programmer;
    }
}
