package com.slums.hands.designpattern.state;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:35
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 获取房间对象
        HomeContext ctx = new HomeContext();
        // 设置房间状态
        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
    }
}
