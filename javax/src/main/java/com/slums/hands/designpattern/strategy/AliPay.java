package com.slums.hands.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:11
 * @version: 1.0
 */
public class AliPay implements Payment {
    @Override
    public PayType getPayType() {
        return PayType.WECHAT_PAY;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println(String.format("支付渠道为：%s,支付金额为：%s", getPayType(), amount));
        return true;
    }
}
