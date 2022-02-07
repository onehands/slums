package com.slums.hands.leetcode;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/24 17:21
 * @version: 1.0
 */
public class LeetCode_326 {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
