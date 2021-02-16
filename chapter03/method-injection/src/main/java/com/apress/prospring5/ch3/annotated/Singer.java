package com.apress.prospring5.ch3.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {

    private String lyric = "I played a dick game of chess with the salt and paper shaker";

    public void sing(){
        //System.out.println(lyric);
    }
}
