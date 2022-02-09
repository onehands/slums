package com.slums.hands.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:11
 * @version: 1.0
 */
public class WechatPay implements Payment {
    @Override
    public PayType getPayType() {
        return PayType.ALI_PAY;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println(String.format("支付渠道为：%s,支付金额为：%d", getPayType(), amount));
        return false;
    }
}
