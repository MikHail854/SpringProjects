package com.apress.prospring5.ch3.My;

import com.apress.prospring5.ch3.ArtworkSender;
import com.apress.prospring5.ch3.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("artworkManager")
public class ArtworkManager implements ArtworkSender {


    @Autowired
    @Qualifier("list")
    private List list;


    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {

    }

    @Override
    public String getFriendlyName() {
        return null;
    }

    @Override
    public String getShortName() {
        return null;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/my-app-context-annotation.xml");
        ctx.refresh();

        ArtworkManager manager = (ArtworkManager) ctx.getBean("artworkManager");
        manager.list.add("Is main");
        manager.list.forEach(obj -> System.out.println(obj));


        SecondClass secondClass = (SecondClass) ctx.getBean("secondClass");
        secondClass.addNewElementList(manager.list);
        manager.list.forEach(obj -> System.out.println(obj));

        ctx.close();

    }

    public void addList(){

    }

}
