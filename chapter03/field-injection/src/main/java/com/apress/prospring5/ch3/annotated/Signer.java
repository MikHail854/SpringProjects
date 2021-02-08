package com.apress.prospring5.ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("signer")
public class Signer {

    @Autowired
    private Inspiration inspirationBean;

    public void sign(){
        System.out.println("...." + inspirationBean.getLyric());
    }


}
