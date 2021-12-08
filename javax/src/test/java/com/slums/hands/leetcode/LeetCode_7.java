package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 0;
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x != 0) {
            if (result > (Integer.MAX_VALUE - (x % 10)) / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return flag * result;
    }

    @Test
    public void test() {
        System.out.println(reverse(123));
    }


}
