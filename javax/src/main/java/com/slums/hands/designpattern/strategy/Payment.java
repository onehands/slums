package com.slums.hands.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:08
 * @version: 1.0
 */
public interface Payment {
    PayType getPayType();

    boolean pay(BigDecimal amount);
}
