package com.apress.prospring5.ch3.xml;

public class Singer {
    private String name;
    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }
}
