package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_2121 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000008;
        }
        return result[n];
    }

    @Test
    public void test() {
//        System.out.println(numWays(0));
//        System.out.println(numWays(1));
//        System.out.println(numWays(2));
        System.out.println(numWays(44));
//        System.out.println(numWays(4));
    }
}
