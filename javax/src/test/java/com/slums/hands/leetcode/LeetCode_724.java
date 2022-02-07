package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/6 21:10
 * @version: 1.0
 * 724. 寻找数组的中心下标
 */
public class LeetCode_724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        if ((sum - nums[0]) / 2 == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if ((sum - value) / 2.0 == nums[i - 1]) {
                return i;
            } else {
                nums[i] = nums[i - 1] + value;
            }
        }
        return -1;

    }

    @Test
    public void test() {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,-1}));
    }
}
