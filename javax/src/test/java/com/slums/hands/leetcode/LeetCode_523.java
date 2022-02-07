package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 10:23
 * @version: 1.0
 */
public class LeetCode_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                } else {
                    map.put(mod, map.get(mod));
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(checkSubarraySum(new int[]{5, 0, 0, 0}, 7));
    }
}
