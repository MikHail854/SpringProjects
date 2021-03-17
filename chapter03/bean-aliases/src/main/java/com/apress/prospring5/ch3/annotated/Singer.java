package com.apress.prospring5.ch3.annotated;

import org.springframework.stereotype.Component;

@Component("johnMayer")
@Award(prize = {"grammy", "platinum disk"})
public class Singer {

    //private String lyric = "We found a message in a bottle we were drinking";
    private String lyric = "Down there below us, under the clouds";

    public void sing(){
        System.out.println(lyric);
    }
}
