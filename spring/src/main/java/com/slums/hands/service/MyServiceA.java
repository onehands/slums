package com.slums.hands.service;

import com.slums.hands.annotation.AutoLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/14 14:36
 * @version: 1.0
 */
@Component
public class MyServiceA {
    @Autowired
    private MyServiceB myServiceB;

    public MyServiceA() {
        System.out.println("A init");
    }

    @AutoLog
    public void add(int a, int b) {
        System.out.println(myServiceB);
        System.out.println("call add");
    }

}
