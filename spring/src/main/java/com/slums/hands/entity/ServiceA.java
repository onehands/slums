package com.slums.hands.entity;

import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/11 22:54
 * @version: 1.0
 */
@Component
@ToString
public class ServiceA implements InitializingBean {
    @Autowired
    private ServiceB serviceB;

    @Autowired
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
