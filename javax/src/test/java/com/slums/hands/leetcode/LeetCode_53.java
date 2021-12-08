package com.slums.hands.leetcode;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/7 10:28
 * @version: 1.0
 */
public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-1}));
    }
}
