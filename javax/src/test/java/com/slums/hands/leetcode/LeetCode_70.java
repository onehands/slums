package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/26 16:28
 * @version: 1.0
 */
public class LeetCode_70 {
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return climbStairs(cache, n);
    }

    private int climbStairs(Map<Integer, Integer> cache, int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = climbStairs(cache, n - 1) + climbStairs(cache, n - 2);
        cache.put(n, result);
        return result;
    }

    @Test
    public void test() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
