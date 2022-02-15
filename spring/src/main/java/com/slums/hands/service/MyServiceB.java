package com.slums.hands.service;

import org.springframework.stereotype.Component;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/14 14:36
 * @version: 1.0
 */
@Component
public class MyServiceB {
    //    @Autowired
    private MyServiceA myServiceA;

    public MyServiceB(MyServiceA myServiceA) {
        this.myServiceA = myServiceA;
        System.out.println("B init");

    }

    public void add() {
        myServiceA.add(0, 0);
    }
}
