package com.slums.hands.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/7 14:14
 * @version: 1.0
 */
public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }

    @Test
    public void test() {
        int[] param = new int[]{1, 1, 2};
        int result = removeDuplicates(param);
        System.out.println(result);
        System.out.println("source:");
        param = Arrays.copyOf(param, result);
        for (int i : param) {
            System.out.println(i);
        }
    }
}
