package com.slums.hands.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:17
 * @version: 1.0
 */
public class PaymentContext {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        factory.getPayment(PayType.ALI_PAY).pay(new BigDecimal(100));
        factory.getPayment(PayType.BANK_CARD_PAY).pay(new BigDecimal(100));
    }
}
