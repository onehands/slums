package com.slums.hands.service.impl;

import com.slums.hands.service.IService;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/20 10:36
 * @version: 1.0
 */
public class MyService implements IService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
