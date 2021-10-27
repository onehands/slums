package com.slums.hands.service;

import org.springframework.stereotype.Service;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/18 16:24
 * @version: 1.0
 */
@Service
public class DefaultService implements BaseService {
    @Override
    public String doSth(String name) {
        return name + "666";
    }

    @Override
    public int doSth() {
        return 0;
    }
}
