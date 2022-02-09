package com.slums.hands.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:14
 * @version: 1.0
 */
public class PaymentFactory {
    private static final Map<PayType, Payment> map = new HashMap<>();

    static {
        map.put(PayType.ALI_PAY, new AliPay());
        map.put(PayType.WECHAT_PAY, new WechatPay());
    }

    public Payment getPayment(PayType payType) {
        if (map.containsKey(payType)) {
            return map.get(payType);
        }
        throw new IllegalArgumentException("未知支付方式：" + payType);
    }

}
