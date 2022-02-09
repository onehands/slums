package com.slums.hands.designpattern.state;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:35
 * @version: 1.0
 */
public class HomeContext {
    private State state;

    public void setState(State s) {
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}
