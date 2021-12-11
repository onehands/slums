package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, j = 0; i < prices.length; i++) {
            int current = prices[i] - prices[j];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                j = i;
            }
        }
        return max;
    }

}
