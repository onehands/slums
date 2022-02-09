package com.slums.hands.designpattern.state;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:34
 * @version: 1.0
 */
public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住！请勿打扰！");
    }
}
