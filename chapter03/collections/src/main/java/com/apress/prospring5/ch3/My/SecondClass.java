package com.apress.prospring5.ch3.My;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("secondClass")
public class SecondClass {

    public List addNewElementList(List list){
        list.add("Element from second class");
        return list;
    }
}
