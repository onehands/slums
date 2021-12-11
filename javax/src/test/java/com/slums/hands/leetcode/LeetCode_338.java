package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_338 {
    public int[] countBits(int n) {
        //偶数=

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    public int[] countBits2(int n) {
        //偶数 = 偶数/2 → 奇数 = (偶数/2-1)的值
        //奇数 = （奇数-1）的值+1
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                //奇数
                result[i] = result[i - 1] + 1;
            } else {
                //偶数
                result[i] = result[i >> 1];
            }

        }
        return result;
    }

    @Test
    public void test() {
        for (int i : countBits2(8)) {
            System.out.println(i);
        }
    }
}
