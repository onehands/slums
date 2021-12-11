package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_2120 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n - 1];
    }

    @Test
    public void test() {
        System.out.println(fib(45));
    }


}
