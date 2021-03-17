package com.apress.prospring5.ch3.annotated;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {
    public void sign(){
        System.out.println("Cm Eb Fm Ab Bb");
    }
}
