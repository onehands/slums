package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 18:28
 * @version: 1.0
 */
public class LeetCode_122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int increase = prices[i] - prices[i - 1];
            if (increase > 0) {
                sum += increase;
            }
        }
        return sum;
    }
}
